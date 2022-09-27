package org.example.annotations.intro;

import org.springframework.stereotype.Component;

@Component
public class MyMusic implements Music {

    @Override
    public String getSong() {
        return "Мой рок-н ролл";
    }


}
