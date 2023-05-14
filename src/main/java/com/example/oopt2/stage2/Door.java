package com.example.oopt2.stage2;

public class Door {
    public Door(MagneticSensor sensor, DoorView view) {
        magneticSensor = sensor;
        state = State.CLOSE;
        dView = view;
        dView.addMagneticSensorView(magneticSensor.getView());
        dView.setDoorModel(this);
    }
    public void changeState() {
        switch (state) {  // this is the enhanced version of switch statement. It does not require breaks.
            case OPEN, OPENING -> {
                state = State.CLOSING;
                //...
            }
            case CLOSE, CLOSING -> {
                state = State.OPENING;
                //...
            }
        }
    }
    private final DoorView dView;
    private final MagneticSensor magneticSensor;
    private State state;
 }