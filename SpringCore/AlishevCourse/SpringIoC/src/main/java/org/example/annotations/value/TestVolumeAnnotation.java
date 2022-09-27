package org.example.annotations.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestVolumeAnnotation {
    public static void main(String[] args) {

        ApplicationContext context = new  ClassPathXmlApplicationContext("AppContextValue.xml");
        MusicPlayer musicPlayer = context.getBean(MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());


    }
}
