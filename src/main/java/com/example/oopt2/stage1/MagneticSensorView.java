package com.example.oopt2.stage1;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MagneticSensorView extends Group {
    private final Rectangle switchView;
    private final Rectangle magnetView;

    public MagneticSensorView () {
        switchView = new Rectangle(6,6);
        magnetView = new Rectangle(6,6);
        magnetView.setFill(Color.BLACK);
        getChildren().addAll(magnetView,switchView);
        setCloseView();
    }
    public void setCloseView(){
        magnetView.setFill(Color.BLACK);
    }
    public void setOpenView(){
        magnetView.setFill(Color.RED);
    }
    public Rectangle getSwitchView(){
        return switchView;
    }
    public Rectangle getMagnetView(){
        return magnetView;
    }

}
