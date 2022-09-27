package org.example.annotations.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScopeAnnotation {
    public static void main(String[] args) {

        ApplicationContext context = new  ClassPathXmlApplicationContext("AppContextScope.xml");
        MusicPlayer musicPlayer = context.getBean(MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        //scope "singleton"
        ClassicalMusic classicalMusic1 = context.getBean(ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean(ClassicalMusic.class);
        boolean compareSingletonScope = classicalMusic1==classicalMusic2;
        System.out.println(compareSingletonScope);

        //scope "prototype"
        RockMusic rockMusic1 = context.getBean(RockMusic.class);
        RockMusic rockMusic2 = context.getBean(RockMusic.class);
        boolean comparePrototypeScope = rockMusic1==rockMusic2;
        System.out.println(comparePrototypeScope);


    }
}
