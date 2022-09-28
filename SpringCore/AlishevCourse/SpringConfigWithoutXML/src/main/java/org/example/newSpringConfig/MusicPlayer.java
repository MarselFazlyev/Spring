package org.example.newSpringConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;


public class MusicPlayer {

    private List<Music> musicList;

    public MusicPlayer (List<Music> musicList){
        this.musicList = musicList;
    }

    public String playMusic() {
        return "Music " + musicList.get(new Random().nextInt(musicList.size())).getSong() + " is playng now";
    }


}
