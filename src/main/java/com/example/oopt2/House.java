package com.example.oopt2;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Scanner;

public class House extends Pane {
    public House(Scanner in) {
        // reading <#_doors> <#_windows> <#_PIRs>
        in.nextInt(); // TODO: Doors
        int numWindows = in.nextInt();
        in.nextInt(); // TODO: PIRs
        // TODO: get doors
        for (int i = 0; i < numWindows; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int angle = in.nextInt();
            int zone = in.nextInt();
            WindowView windowView = new WindowView(x, y, angle);
            Window window = new Window(zone , windowView);

            // Add properties
            windowView.setWindowModel(window);

            getChildren().add(window.getView());
        }
        // TODO: get PIRs
    }
}
