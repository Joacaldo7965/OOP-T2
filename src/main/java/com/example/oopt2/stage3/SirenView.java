package com.example.oopt2.stage3;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class SirenView extends Polygon {
    private final Timeline timeline;

    public SirenView() {
        getPoints().addAll(0d,30d,
                0d,50d,
                40d, 80d,
                40d, 0d);
        setFill(Color.WHITE);
        setStroke(Color.RED);
        timeline = new Timeline(new KeyFrame(Duration.millis(250), evt -> {
            if(getFill() == Color.RED)
                setFill(Color.GREEN);
            else // If it needs to toggle color or activate alarm
                setFill(Color.RED);

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    public void startBlinking(){
        timeline.play();
    }
    public void stopBlinking() {
        timeline.stop();
        setFill(Color.WHITE);
    }

}
