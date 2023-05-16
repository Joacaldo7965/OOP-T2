package com.example.oopt2.stage3;

import javafx.scene.layout.Pane;

import java.util.Scanner;

public class House extends Pane {
    public House(Scanner in, Central central) {
        // reading <#_doors> <#_windows> <#_PIRs>
        int numDoors = in.nextInt();
        int numWindows = in.nextInt();
        int numPIRs = in.nextInt();

        // Setup Doors
        for (int i = 0; i < numDoors; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int angle = in.nextInt();
            int zone = in.nextInt();

            DoorView doorView = new DoorView(x, y, angle);
            MagneticSensor sensor = new MagneticSensor(zone);
            central.addNewSensor(sensor);
            new Door(sensor, doorView); // Needed?
            getChildren().add(doorView);
        }
        // Setup Windows
        for (int i = 0; i < numWindows; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int angle = in.nextInt();
            int zone = in.nextInt();
            WindowView windowView = new WindowView(x, y, angle);
            MagneticSensor sensor = new MagneticSensor(zone);
            central.addNewSensor(sensor);
            new Window(sensor, windowView); // Needed?
            getChildren().add(windowView);
        }
        // Setup PIRs
        for(int i = 0; i < numPIRs; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int angle = in.nextInt();
            int sensing_angle = in.nextInt();
            int sensing_range = in.nextInt();
            int zone = in.nextInt();
            PIR_DetectorView pirDetectorView = new PIR_DetectorView(x, y, angle, sensing_angle, sensing_range);
            pirDetectorView.setHouseModel(this); // Add house
            Sensor sensor = new Sensor(zone);
            central.addNewSensor(sensor);
            new PIR_Detector(sensor, pirDetectorView);
            getChildren().add(pirDetectorView);
        }
        // Setup People
        PersonView personView = new PersonView(100, 100);
        new Person(personView);
        getChildren().add(personView);

        setMinWidth(700);
    }
}
