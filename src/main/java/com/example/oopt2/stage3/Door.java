package com.example.oopt2.stage3;

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
        magneticSensor.getView().setOpenView();
        System.out.println("State: " + state);
    }

    public void finishMovement(State s) {
        state = s;
        System.out.println("State: " + state);
        magneticSensor.setClose(state == State.CLOSE);
        if(state == State.CLOSE){
            magneticSensor.setClose(true);
            magneticSensor.getView().setCloseView();
        }
    }
}