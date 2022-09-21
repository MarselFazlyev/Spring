package innopolis.validators;

public class PasswordValidatorByCharacterImpl implements PasswordValidator {
    @Override
    public void validate(String password) {
        // indexOf() возвращает -1, если данный символ в строке не найден
        if (password.indexOf('&') == -1 &&
                password.indexOf('!') == -1 &&
                password.indexOf('#') == -1) {

            throw new IllegalArgumentException("Отсутствуют спецсимволы в пароле ");
        }

    }
}
