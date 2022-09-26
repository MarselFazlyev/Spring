package org.example.model;

public class MyMusic implements Music {
    @Override
    public String getSong() {
        return "Мой рок-н ролл";
    }

    public void doMyInit() {
        System.out.println("Doing my initialization");
    }

    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }
}
