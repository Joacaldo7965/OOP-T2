package com.example.oopt2.stage3;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class PersonView extends Group {
    private Circle head;
    private Person personModel;
    public PersonView(int x, int y){
        makePersonView();
        relocate(x, y);
    }

    private void makePersonView() {
        head = new Circle(100, 100, 50);
        getChildren().add(head);
    }

    public void setPersonModel(Person personModel){
        this.personModel = personModel;

        setOnMousePressed(evt -> {
            double offsetX = evt.getX() - head.getCenterX();
            double offsetY = evt.getY() - head.getCenterY();
            head.setUserData(new double[]{offsetX, offsetY});
        });
        setOnMouseDragged(evt -> {
            double[] offset = (double[]) head.getUserData();
            double newCenterX = evt.getX() - offset[0];
            double newCenterY = evt.getY() - offset[1];
            head.setCenterX(newCenterX);
            head.setCenterY(newCenterY);
        });
    }
}
