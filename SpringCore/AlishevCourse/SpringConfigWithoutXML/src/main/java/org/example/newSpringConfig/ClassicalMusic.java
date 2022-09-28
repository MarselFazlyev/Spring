package org.example.newSpringConfig;

import org.springframework.stereotype.Component;


public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Hungary Rhapsody";
    }


}
