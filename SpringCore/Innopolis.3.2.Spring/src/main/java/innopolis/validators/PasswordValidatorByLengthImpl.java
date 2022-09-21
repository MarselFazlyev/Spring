package innopolis.validators;
// проверка пароля по длине

import org.springframework.beans.factory.annotation.Value;

public class PasswordValidatorByLengthImpl implements PasswordValidator {

    private int minLength;

    public PasswordValidatorByLengthImpl(@Value("5") int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void validate(String password) {
        if (password.length() < minLength) {
            throw new IllegalArgumentException("Длина пароля меньше допустимой длины!");

        }
    }
}

