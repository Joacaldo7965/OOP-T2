package com.example.oopt2.stage2;

public class MagneticSensor extends Sensor {
    private final MagneticSensorView view;

    public MagneticSensor(int z){
        super(z);
        view = new MagneticSensorView();
    }
    public void setSensorOpen() {
        //setState(SwitchState.OPEN);
    }
    public void setSensorClose() {
        //setState(SwitchState.CLOSE);
    }
    public MagneticSensorView getView(){ return view;}

}
