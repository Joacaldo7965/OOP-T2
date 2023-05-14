package com.example.oopt2;

public class Sensor {
    private SwitchState state;
    private int zone;

    public Sensor(int z){
        this(z, SwitchState.CLOSE);
    }

    public Sensor(int z, SwitchState s){
        zone = z;
        state = s;
    }

    public SwitchState getState(){
        return state;
    }
    
    protected void setState(SwitchState s) {
        state = s;
    }
}
