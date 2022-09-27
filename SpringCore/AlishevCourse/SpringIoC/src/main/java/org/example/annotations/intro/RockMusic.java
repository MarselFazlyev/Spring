package org.example.annotations.intro;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Wind cryes Mary";
    }

}
