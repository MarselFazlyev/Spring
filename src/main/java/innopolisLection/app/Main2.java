package innopolisLection.app;

import innopolisLection.service.SignUpService;
import innopolisLection.service.SignUpServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {

        //создание конфигурационного объекта Spring
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        // вызов прописанного в конфигурационном файле "context.xml" бина
        SignUpService signUpService = applicationContext.getBean(SignUpService.class);

        //работа объекта-бина, созданного и вызванного через Spring
        signUpService.signUp("Test@mail.ru", "TestPassword#");
    }
}
