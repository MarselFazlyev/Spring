package org.fazlyev;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music{

    private List<String> songs = List.of("5stSimphony","Shelkunchik","Gamlet") ;

    @Override
    public String getSong() {
        return "Classical Music: "+ songs.get(new Random().nextInt(songs.size()));
    }
}
