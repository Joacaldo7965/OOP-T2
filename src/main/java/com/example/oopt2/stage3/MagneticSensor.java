package com.example.oopt2.stage3;

public class MagneticSensor extends Sensor {
    private final MagneticSensorView view;

    public MagneticSensor(int z){
        super(z);
        view = new MagneticSensorView();
    }
    public MagneticSensorView getView(){
        return view;
    }

}
