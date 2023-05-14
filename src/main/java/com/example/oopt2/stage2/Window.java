package com.example.oopt2.stage2;

import com.example.oopt2.stage1.MagneticSensor;
import com.example.oopt2.stage1.State;

/**
 * A window with its magnetic sensor.
 */

public class Window {
    private final WindowView wView;
    private final com.example.oopt2.stage1.MagneticSensor magneticSensor;
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
            case OPEN -> {
                wView.startClosing();
                state = State.CLOSING;
            }
            case OPENING -> {
                wView.startClosing();
                state = State.CLOSING;
            }
            case CLOSE -> {
                wView.startOpening();
                state = State.OPENING;
            }
            case CLOSING -> {
                wView.startOpening();
                state = State.OPENING;
            }
        }
    }
    public void finishMovement(State s) { // is called when this window ends closing or opening
        // TODO: set state
        state = s;
        System.out.println("State: " + s);
    }
    public WindowView getView(){
        return wView;
    }

}
