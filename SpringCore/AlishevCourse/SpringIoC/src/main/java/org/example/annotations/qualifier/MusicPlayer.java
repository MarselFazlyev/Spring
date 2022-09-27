package org.example.annotations.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {


    private Music music1;
    private Music music2;

//    @Autowired
//    public MusicPlayer(@Qualifier("rockMusic")Music music1, @Qualifier("classicalMusic") Music music2) {
//        this.music1 = music1;
//        this.music2 = music2;
//    }

    public MusicPlayer(){}

    @Autowired
    @Qualifier("rockMusic")
    public void setMusic1(Music music1) {
        this.music1 = music1;
    }

    @Autowired
    @Qualifier("classicalMusic")
    public void setMusic2(Music music2) {
        this.music2 = music2;
    }

    public String playMusic() {
        return "Music " + music1.getSong() + " is playng now" +" , "+ music2.getSong() + " is playng now";
    }




}
