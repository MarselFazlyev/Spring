package org.example.model;

import org.example.model.fabric_method.ClassicalMusicWithFabricMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInitAndDestroyMethods {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyMusic myMusic = applicationContext.getBean("MyMusicBean", MyMusic.class);
//        System.out.println(myMusic.getSong());
        // Не удалось вызвать destroy-method на консоль..

        //Тестирование бина, внедренного не с помощью конструктора,а с помощью фабричного метода.
        //прописан в контексте
        ClassicalMusicWithFabricMethod classicalMusicWithFabricMethod = applicationContext.getBean(ClassicalMusicWithFabricMethod.class);
        System.out.println(classicalMusicWithFabricMethod.getSong());



    }
}
