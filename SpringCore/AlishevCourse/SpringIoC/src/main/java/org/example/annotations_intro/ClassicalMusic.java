package org.example.annotations_intro;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Hungary Rhapsody";
    }


}
