package web.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.ApplicationConfig;
import web.dto.SignUpForm;
import web.repositories.AccountsRepository;
import web.services.AccountService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
//        SignUpForm signUpForm = new SignUpForm("Dean", "Vinchester", "dean@mail.com", "password");
//        accountService.createAccount(signUpForm);
//
        AccountsRepository accountsRepository = applicationContext.getBean(AccountsRepository.class);
//        System.out.println(accountsRepository.findById(2L));
//        System.out.println(accountService.getAllAccounts());
        System.out.println(accountsRepository.findAllByCarsColor("Red"));

    }
}
