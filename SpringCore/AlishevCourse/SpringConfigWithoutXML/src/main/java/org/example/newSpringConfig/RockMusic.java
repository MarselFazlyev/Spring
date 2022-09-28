package org.example.newSpringConfig;

import org.springframework.stereotype.Component;


public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Wind cryes Mary";
    }

}
