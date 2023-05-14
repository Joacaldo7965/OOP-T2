package com.example.oopt2.stage2;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Scanner;

public class House extends Pane {
    public House(Scanner in, Central central) {
        // reading <#_doors> <#_windows> <#_PIRs>
        int numDoors = in.nextInt();
        int numWindows = in.nextInt();
        in.nextInt(); // just to conform the first line format
        for (int i = 0; i < numDoors; i++){
            //...
        }
        for (int i = 0; i < numWindows; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int angle = in.nextInt();
            int zone = in.nextInt();
            WindowView windowView= new WindowView(x, y, angle);
            MagneticSensor sensor = new MagneticSensor(zone);
            central.addNewSensor(sensor);
            //new Window(sensor, windowView);
            new Window(zone, windowView);
            getChildren().add(windowView);
        }
        setMinWidth(700);
    }
}
