package org.example.annotations.intro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic ;

    private RockMusic rockMusic;

    //IoC здес мы внедряем зависимость

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public MusicPlayer() {
    }

    public ClassicalMusic getClassicalMusic() {
        return classicalMusic;
    }

    public void setClassicalMusic(ClassicalMusic classicalMusic) {
        this.classicalMusic = classicalMusic;
    }

    public RockMusic getRockMusic() {
        return rockMusic;
    }

    public void setRockMusic(RockMusic rockMusic) {
        this.rockMusic = rockMusic;
    }

    public String playMusic() {
            return "Music " + rockMusic.getSong() + " is playng now";
    }


}
