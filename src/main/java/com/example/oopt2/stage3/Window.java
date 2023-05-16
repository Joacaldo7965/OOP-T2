package com.example.oopt2.stage3;


/**
 * A window with its magnetic sensor.
 */

public class Window {
    private final WindowView wView;
    private final MagneticSensor magneticSensor;
    private State state;
    public Window(MagneticSensor sensor, WindowView view) { // Changed from Window(int zone,...) to Window(MagneticSensor sensor,...)
        magneticSensor = sensor;
        state = State.CLOSE;
        wView = view;
        wView.addMagneticSensorView(magneticSensor.getView());
        wView.setWindowModel(this);
    }
    public void changeState() {  // is called when this window's view is clicked
        switch (state) {
            case OPEN, OPENING -> {
                wView.startClosing();
                state = State.CLOSING;
            }
            case CLOSE, CLOSING -> {
                wView.startOpening();
                state = State.OPENING;
            }
        }
        magneticSensor.setClose(false);
        magneticSensor.getView().setOpenView();
        System.out.println("State: " + state);
    }
    public void finishMovement(State s) { // is called when this window ends closing or opening
        state = s;
        System.out.println("State: " + state);
        boolean isClosed = state == State.CLOSE;
        if(isClosed){
            magneticSensor.setClose(true);
            magneticSensor.getView().setCloseView();
        }
    }
    public WindowView getView(){
        return wView;
    }

}
