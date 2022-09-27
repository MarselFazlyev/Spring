package org.fazlyev;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean(MusicPlayer.class);

//        musicPlayer.playMusic(TypeOfAlbom.CLASSICAL);
        musicPlayer.playMusic(TypeOfAlbom.ROCK);
    }
}
