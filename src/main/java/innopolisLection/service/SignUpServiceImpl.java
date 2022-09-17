package innopolisLection.service;

import innopolisLection.models.Account;
import innopolisLection.validators.EmailValidator;
import innopolisLection.validators.PasswordBlackLIst;
import innopolisLection.validators.PasswordValidator;

public class SignUpServiceImpl implements SignUpService {

    private EmailValidator emailValidator;

    private PasswordValidator passwordValidator;

    private PasswordBlackLIst passwordBlackLIst;

    public SignUpServiceImpl(EmailValidator emailValidator,
                             PasswordValidator passwordValidator,
                             PasswordBlackLIst passwordBlackLIst) {
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
        this.passwordBlackLIst = passwordBlackLIst;
    }

    @Override
    public void signUp(String email, String password) {

        if(passwordBlackLIst.contains(password)){
            throw new IllegalArgumentException("Ваш пароль был уже взломан");
        }

        emailValidator.validate(email);
        passwordValidator.validate(password);


        Account account = Account.builder()
                .email(email)
                .password(password)
                .build();

        System.out.println("Аккаунт создан");
        System.out.println("Email "+account.getEmail());
        System.out.println("Password "+account.getPassword());
    }
}
