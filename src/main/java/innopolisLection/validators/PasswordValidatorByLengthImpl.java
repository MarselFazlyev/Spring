package innopolisLection.validators;
// проверка пароля по длине

public class PasswordValidatorByLengthImpl implements PasswordValidator {

    private int minLength;

    public PasswordValidatorByLengthImpl(int minLength){
        this.minLength = minLength;
    }

    @Override
    public void validate(String password) {
        if (password.length()<minLength){
            throw new IllegalArgumentException("Длина пароля меньше допустимой длины!");

        }
    }
}
