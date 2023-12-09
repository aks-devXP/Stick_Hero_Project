package com.aks.stick_hero_ap;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicController {
    private MediaPlayer mediaPlayer;
    private Media media;
    private String audioFile;

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }

    public MusicController(String audioFile) {
        this.audioFile = audioFile;
        this.media = new Media(audioFile);
        this.mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop the audio
    }

    public void playAudio() {
        if (!mediaPlayer.isMute()) {
            mediaPlayer.play();
        }
    }

    public void muteUnmute(){
        if(AudioManager.isMuted()) { // if sound is muted
            this.stopAudio(); // stops the audio
        }
        else {
            this.playAudio(); //plays the audio
        }
    }

    public void stopAudio() {
        mediaPlayer.pause();
    }
}

