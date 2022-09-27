package org.example.annotations.qualifier;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Hungary Rhapsody";
    }


}
