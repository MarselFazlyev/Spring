package org.example.annotations.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQualifierAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AppContextQualifier.xml");

        MusicPlayer musicPlayer = applicationContext.getBean(MusicPlayer.class);
        System.out.println(musicPlayer.playMusic());
    }
}
