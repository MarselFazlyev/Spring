package org.example.model.fabric_method;

import org.example.model.Music;

public class ClassicalMusicWithFabricMethod implements Music {
    private ClassicalMusicWithFabricMethod (){}

    public static ClassicalMusicWithFabricMethod getClassicalMusic(){
        return new ClassicalMusicWithFabricMethod();
    }

    @Override
    public String getSong() {
        return "Hungary Rhapsody";
    }


}
