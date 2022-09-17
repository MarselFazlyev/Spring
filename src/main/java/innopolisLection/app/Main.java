package innopolisLection.app;

import innopolisLection.service.SignUpService;
import innopolisLection.service.SignUpServiceImpl;
import innopolisLection.validators.*;

public class  Main {
    public static void main(String[] args) {

        // валидация по длине почты и пароля
//        EmailValidator emailValidator = new EmailValidatorImplByLength(5);
//        PasswordValidator passwordValidator = new PasswordValidatorByLengthImpl(5);
//        SignUpService signUpService = new SignUpServiceImpl(emailValidator,passwordValidator);
//        signUpService.signUp("abrakadabra@milo.ru","password");

        // валидация по спецсимволам и взломанным паролям
        EmailValidatorRegexImpl emailValidator = new EmailValidatorRegexImpl();
        emailValidator.setPattern(".+@.+");
        PasswordValidator passwordValidator = new PasswordValidatorByCharacterImpl();
        // в статичном поле BROKEN_PASSWORDS класса PasswordBlackLIstImpl() лежат все взломанные пароли
        PasswordBlackLIst passwordBlackLIst = new PasswordBlackLIstImpl();
        SignUpService signUpService = new SignUpServiceImpl(emailValidator,passwordValidator, passwordBlackLIst);
        signUpService.signUp("abrakadabra@milo.ru","password");

    }
}
