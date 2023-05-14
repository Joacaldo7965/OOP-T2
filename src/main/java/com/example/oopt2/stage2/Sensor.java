package com.example.oopt2.stage2;

public class Sensor {
    private boolean isClose;
    private int zone;

    public Sensor(int z){
        this(z, true);
    }
    public Sensor(int z, boolean close){
        zone = z;
        isClose = close;
    }
    public boolean isClose(){
        return isClose;
    }
    public int getZone() {
        return zone;
    }
    protected void setClose(boolean close) {
        isClose = close;
    }
}
