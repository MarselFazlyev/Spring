package org.example.newSpringConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ComponentScan("org.example.newSpringConfig")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic (){return new ClassicalMusic();}

    @Bean
    public RockMusic rockMusic (){return  new RockMusic();}

    @Bean
    public  RapMusic rapMusic () {return new RapMusic();}

    @Bean MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }

    @Bean
    public List<Music> musicList() {
        return List.of(classicalMusic(),rapMusic(),rockMusic());
    }



}
