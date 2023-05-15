package com.example.oopt2.stage2;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class DoorView extends Group {
    private RotateTransition rotateTransition;
    private Door doorModel;
    private Polygon switchPillar;
    private Rectangle slidingSheet;

    public DoorView(int x, int y, int angle){
        makeDoorViewWithoutSensor();
        //setRotate(angle);  // to rotate at the geometric center.
        getTransforms().add(new Rotate(angle,0,0));
        relocate(x,y);

        prepareOpen_CloseTransition();
    }

    private void makeDoorViewWithoutSensor(){
        Polygon origenPillar = new Polygon();
        origenPillar.getPoints().addAll(0d,0d,
                0d,20d,
                10d, 20d,
                10d, 10d,
                20d, 10d,
                20d, 0d);
        origenPillar.setFill(Color.BLUE);
        origenPillar.setStroke(Color.BLUE);
        switchPillar = new Polygon(
                160d,0d,
                160d, 10d,
                170d, 10d,
                170d, 20d,
                180d, 20d,
                180d, 0d );
        switchPillar.setFill(Color.BLUE);
        switchPillar.setStroke(Color.BLUE);
        slidingSheet = new Rectangle(10,10,160,10);
        slidingSheet.setFill(Color.BURLYWOOD);
        Rectangle border = new Rectangle(0,0 ,180, 180);
        border.setFill(Color.TRANSPARENT);
        border.setStroke(Color.GRAY);
        border.getStrokeDashArray().addAll(4d,4d );
        getChildren().addAll(border);
        getChildren().addAll(origenPillar, switchPillar,slidingSheet);
    }
    public void setDoorModel(Door model) {
        doorModel = model;

        setOnMouseClicked(event -> {
            doorModel.changeState();
        });
    }
    public void addMagneticSensorView(MagneticSensorView msView){
        placeMagneticSensor(msView);
        //....
        getChildren().add(msView);
    }
    private void placeMagneticSensor( MagneticSensorView mv){
        mv.getMagnetView().setX(slidingSheet.getX());
        mv.getMagnetView().setY(switchPillar.getBoundsInLocal().getHeight());

        // TODO: fix this... I give up with this ****
        //mv.getMagnetView().translateXProperty().bind(slidingSheet.translateXProperty().add(slidingSheet.getWidth() / 2));
        //mv.getMagnetView().translateYProperty().bind(slidingSheet.translateYProperty().add(slidingSheet.getHeight() / 2 - mv.getMagnetView().getHeight()));
        mv.getMagnetView().rotateProperty().bind(slidingSheet.rotateProperty());

        // Switch
        mv.getSwitchView().setY(switchPillar.getBoundsInLocal().getHeight());
    }

    private void prepareOpen_CloseTransition() {
        rotateTransition = new RotateTransition(Duration.millis(2000), slidingSheet);
        rotateTransition.setCycleCount(1);
        rotateTransition.setOnFinished(evt -> {
            if(slidingSheet.getRotate() == 0)
                doorModel.finishMovement(State.CLOSE);
            else
                doorModel.finishMovement(State.OPEN);
        });
        // Set pivot
        double x = slidingSheet.getWidth() / 2;
        double y = slidingSheet.getHeight() / 2;
        slidingSheet.getTransforms().add(new Translate(-x,-y));
        slidingSheet.setTranslateX(x);
        slidingSheet.setTranslateY(y);
    }

    public void startOpening(){
        rotateTransition.stop();
        rotateTransition.setFromAngle(slidingSheet.getRotate());
        rotateTransition.setToAngle(-90);
        rotateTransition.play();
    }
    public void startClosing(){
        rotateTransition.stop();
        rotateTransition.setFromAngle(slidingSheet.getRotate());
        rotateTransition.setToAngle(0);
        rotateTransition.play();
    }
}
