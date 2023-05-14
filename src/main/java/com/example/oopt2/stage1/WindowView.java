package com.example.oopt2.stage1;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class WindowView extends Group {
    private TranslateTransition transition;
    private Window winModel;
    private Rectangle switchPillar;
    private Rectangle slidingGlass;

    public WindowView(int x, int y, int angle){
        makeWindowViewWithoutSensor();
        //setRotate(angle);  // to rotate at the geometric center.
        getTransforms().add(new Rotate(angle,0,0));  // to rotate at anchor pivot
        relocate(x, y);
        prepareOpen_CloseTransition();

        setOnMouseClicked(event -> {
            winModel.changeState();
        });
    }
    private void makeWindowViewWithoutSensor(){
        Rectangle origenPillar = new Rectangle(0, 0, 20, 20);
        origenPillar.setFill(Color.BLUE);
        origenPillar.setStroke(Color.BLUE);
        switchPillar = new Rectangle(180, 0, 20, 20);
        switchPillar.setFill(Color.BLUE);
        switchPillar.setStroke(Color.BLUE);
        Rectangle fixedGlass = new Rectangle(21, 4, 82, 6);
        fixedGlass.setFill(Color.LIGHTBLUE);
        slidingGlass = new Rectangle(97,11,82,6);
        slidingGlass.setFill(Color.LIGHTBLUE);

        // DEBUG
        Rectangle dev1 = new Rectangle(97, 11, 2, 2);
        dev1.setFill(Color.rgb(0, 255, 0));


        Rectangle border = new Rectangle(0, 0, 200, 20);
        border.setFill(Color.WHITE);
        border.setStroke(Color.BLACK);
        border.setStrokeWidth(1);
        border.getStrokeDashArray().addAll(4d,4d );
        getChildren().add(border);
        getChildren().addAll(origenPillar, switchPillar, fixedGlass, slidingGlass, dev1);
    }
    public void setWindowModel(Window model) {
        winModel = model;
    }
    public void addMagneticSensorView(MagneticSensorView msView){
        placeMagneticSensor(msView);
        getChildren().add(msView);
    }
    private void placeMagneticSensor(MagneticSensorView mv){
        mv.getMagnetView().setX(slidingGlass.getX()+ slidingGlass.getWidth()-mv.getMagnetView().getWidth());
        //..
        mv.getMagnetView().translateXProperty().bind(slidingGlass.translateXProperty()); // so it moves along with window
    }
    private void prepareOpen_CloseTransition(){
        transition = new TranslateTransition(Duration.millis(2000), slidingGlass);
        transition.setCycleCount(1);
        transition.setOnFinished(evt -> {
            // TODO: Closed??
            if(slidingGlass.getTranslateX() == 0.0){
                winModel.finishMovement(State.CLOSE);
                System.out.println("SETTING STATE TO CLOSE");
            }else{
                winModel.finishMovement(State.OPEN);
                System.out.println("SETTING STATE TO OPEN");
            }

        });
    }
    public void startOpening(){
        System.out.println("Opening...");
        transition.stop();
        double w = slidingGlass.getWidth();
        double fromX = slidingGlass.getTranslateX();
        double toX = -w + (slidingGlass.getX() - w);
        System.out.println("from " + fromX + " to " + toX);
        transition.setFromX(fromX);// in case the user decides to close before it opens.
        transition.setToX(toX); // TODO: check this
        transition.play();
    }
    public void startClosing(){
        System.out.println("Closing...");
        transition.stop();
        double fromX = slidingGlass.getTranslateX();
        double toX = 0.0;
        System.out.println("from " + fromX + " to " + toX);
        transition.setFromX(fromX);  // in case the user decides to open before it closes.
        transition.setToX(toX); // original position
        transition.play();
    }
}
