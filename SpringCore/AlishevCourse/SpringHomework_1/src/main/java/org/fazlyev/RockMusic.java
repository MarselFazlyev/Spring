package org.fazlyev;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RockMusic implements  Music{

    private List<String> songs = List.of("Moy Rock-n-Roll","Rodina","Eto vsyo");

    @Override
    public String getSong() {
        return " Rock Music: "+ songs.get(new Random().nextInt(songs.size()));
    }
}
