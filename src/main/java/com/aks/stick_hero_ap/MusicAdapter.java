package com.aks.stick_hero_ap;

public class MusicAdapter implements Sound{
    private MusicController musicController;
    private String music;

    public MusicAdapter(MusicController musicController,String music) {
        this.music = music;
        this.musicController = musicController;
    }

    @Override
    public void initialiseSound() {
        musicController = new MusicController(getClass().getResource(music).toExternalForm());
        this.muteUnmute();
    }

    @Override
    public void muteUnmute() {
        this.musicController.muteUnmute();
    }

    public void muteSound(){
        this.musicController.stopAudio();
    }
}
