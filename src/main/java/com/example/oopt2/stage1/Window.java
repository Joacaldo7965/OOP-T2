package com.example.oopt2.stage1;

/**
 * A window with its magnetic sensor.
 */

public class Window {
    private final WindowView wView;
    private final MagneticSensor magneticSensor;
    private State state;
    public Window(int zone, WindowView view) {
        magneticSensor = new MagneticSensor(zone);
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
                magneticSensor.setSensorOpen();
            }
            case CLOSE, CLOSING -> {
                wView.startOpening();
                state = State.OPENING;
            }
        }
    }
    public void finishMovement(State s) { // is called when this window ends closing or opening
        state = s;
        System.out.println("State: " + s);
        if(s == State.CLOSE)
            magneticSensor.setSensorClose();
    }
    public WindowView getView(){
        return wView;
    }

}
