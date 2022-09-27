package org.example.annotations.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Hungary Rhapsody";
    }


}
