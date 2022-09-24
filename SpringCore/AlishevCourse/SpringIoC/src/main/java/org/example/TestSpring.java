package org.example;

import org.example.model.MusicPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//      Music music =  applicationContext.getBean("musicBean",Music.class);
//      MusicPlayer musicPlayer = new MusicPlayer(music);

//      в конструктор MusicPlayer через application context внедрена зависимость-бин musicBean,
//      что позволяет не создавать вручную реализацию интерфейса Music
        MusicPlayer musicPlayer = applicationContext.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());
        musicPlayer.playMusic();

        // по умолчанию scope "Singleton", поэтому при всех вызовах getBean() ссылки ведут на один и тот же объект
        // если указать scope="prototype",то каждый раз getBean(),будет возвращать разные объекты.
        MusicPlayer musicPlayer1 = applicationContext.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer == musicPlayer1);

    }
}
