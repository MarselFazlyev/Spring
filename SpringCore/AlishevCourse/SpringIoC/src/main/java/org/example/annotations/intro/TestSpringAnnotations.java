package org.example.annotations.intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AppContextIntro.xml");
//        Music music = applicationContext.getBean(MyMusic.class);
//        Music music1 = applicationContext.getBean(RockMusic.class);
//        Music music2 = applicationContext.getBean(ClassicalMusic.class);
//        MusicPlayer musicPlayer = new MusicPlayer(music2);
//        musicPlayer.playMusic();

//        MusicPlayer musicPlayer = applicationContext.getBean(MusicPlayer.class);
//        musicPlayer.playMusic();

        Computer computer = applicationContext.getBean(Computer.class);
        System.out.println(computer);
    }
}
