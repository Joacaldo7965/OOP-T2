package com.example.oopt2.stage3;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Polygon;

public class Siren {
    private SirenView view;
    private MediaPlayer mediaPlayer;
    boolean isSounding;
    public Siren (String mediaURL){
        Media media = new Media(mediaURL);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        view = new SirenView();
        isSounding = false;
    }
    public void play(){
        if(!isSounding) { // Play alarm sound only if it's not sounding
            mediaPlayer.play();
            view.startBlinking();
            isSounding = true;
        }
    }
    public void stop(){
        if(isSounding) { // Stop the alarm sound only if it's sounding
            mediaPlayer.stop();
            view.stopBlinking();
            isSounding = false;
        }
    }
    public Polygon getView() {
        return view;
    }

}
