package com.example.oopt2.stage3;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class PIR_Detector {
    private final Timeline periodicCheck;
    private final PIR_DetectorView pView;
    private final Sensor sensor;
    private State state;

    public PIR_Detector(Sensor sensor, PIR_DetectorView pView) {
        this.sensor = sensor;
        this.state = State.CLOSE;
        this.pView = pView;
        pView.addSensorView();
        pView.setPIRModel(this);

        periodicCheck = new Timeline(new KeyFrame(Duration.millis(300),
                e -> scanForPeople()));
        periodicCheck.setCycleCount(Animation.INDEFINITE);
    }

    public PIR_DetectorView getpView() {
        return pView;
    }

    public void scanForPeople(){
        // TODO: Make the scan using houseModel
    }
}
