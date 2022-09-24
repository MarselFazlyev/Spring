package org.example;

import org.example.model.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestBean testBean =  applicationContext.getBean("testBean", TestBean.class);
        System.out.println(testBean);
    }
}
