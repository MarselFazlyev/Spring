package org.example.annotations.initAndDestroyMethods;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInitAndDestroyMethodsAnnotation {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("AppContextInitAndDestroyMethods.xml");

        ClassicalMusic classicalMusic = context.getBean(ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());

        context.close();

    }
}
