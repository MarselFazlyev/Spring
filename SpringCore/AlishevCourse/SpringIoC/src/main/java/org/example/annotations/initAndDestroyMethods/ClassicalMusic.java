package org.example.annotations.initAndDestroyMethods;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ClassicalMusic implements Music {

    @PostConstruct
    public void doMyInit() {
        System.out.println("Doing My Initialization");
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Doing Me Destruction");
    }

    @Override
    public String getSong() {
        return "Hungary Rhapsody";
    }


}
