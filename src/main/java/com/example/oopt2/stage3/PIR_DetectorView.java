package com.example.oopt2.stage3;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;

public class PIR_DetectorView extends Group{
    private House houseModel;
    private PIR_Detector pirModel;
    private Rectangle scanningArea; // Change this to the corresponding shape of the scanning area
    private Rectangle sensorView;

    public PIR_DetectorView(int x, int y, int angle, int sensing_angle, int sensing_range) {
        makePIRViewWithoutSensor(angle, sensing_angle, sensing_range);
        getTransforms().add(new Rotate(angle,0,0));  // to rotate at anchor pivot
        relocate(x, y);
    }

    private void makePIRViewWithoutSensor(int direction_angle, int sensing_angle, int sensing_range) {
        // Base shape
        Rectangle base = new Rectangle(0,0, 30, 20);
        base.setFill(Color.GREEN);
        base.setStroke(Color.BLACK);

        // Circular sector shape
        // FIXME: fix this mess adjusting direction_angle, sensing_angle in the 5th parameter of Arc()
        double radius = (float) sensing_range / 2.0;
        Arc arc = new Arc(base.getWidth()/2, 0, radius, radius, direction_angle , sensing_angle); // cx, cy, rx, ry, direction_angle, sensing_angle, length
        /*
        Arc arc = new Arc();
        arc.setCenterX(0);
        arc.setCenterY(0);
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        arc.setStartAngle(45 + sensing_angle);
         */
        arc.setType(ArcType.ROUND);
        arc.setFill(Color.rgb(240, 10, 10, 0.3));

        getChildren().addAll(arc, base);
    }

    public void setPIRModel(PIR_Detector pirModel){
        this.pirModel = pirModel;
    }

    public void setHouseModel(House houseModel){
        this.houseModel = houseModel;
    }

    public void addSensorView(){
        sensorView =  createSensorView();
        //placeSensor(sensorView); // Needed? -> we can place the sensor in the creation
        getChildren().add(sensorView);
    }

    private Rectangle createSensorView() {
        Rectangle sensor = new Rectangle(0, 0, 6, 6);
        sensor.setFill(Color.RED);
        return sensor;
    }
    public void setCloseView(){
        sensorView.setFill(Color.GREEN);
    }

    public void setOpenView(){
        sensorView.setFill(Color.RED);
    }
}
