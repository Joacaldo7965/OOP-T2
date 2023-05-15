package com.example.oopt2.stage2;

public class Door {
    private final DoorView dView;
    private final MagneticSensor magneticSensor;
    private State state;

    public Door(MagneticSensor sensor, DoorView view) {
        magneticSensor = sensor;
        state = State.CLOSE;
        dView = view;
        dView.addMagneticSensorView(magneticSensor.getView());
        dView.setDoorModel(this);
    }
    public void changeState() {
        switch (state) {
            case OPEN, OPENING -> {
                dView.startClosing();
                state = State.CLOSING;
            }
            case CLOSE, CLOSING -> {
                dView.startOpening();
                state = State.OPENING;
            }
        }
        magneticSensor.setClose(false);
        System.out.println("State: " + state);
    }

    public void finishMovement(State s) {
        state = s;
        System.out.println("State: " + state);
        magneticSensor.setClose(state == State.CLOSE);
    }
}