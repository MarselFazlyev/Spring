package innopolisLection.validators;

import java.util.regex.Pattern;

public class EmailValidatorRegexImpl implements EmailValidator {

    private Pattern pattern;

    public void setPattern(String regex) {
        this.pattern = Pattern.compile(regex);
    }


    @Override
    public void validate(String email) {
        // если строка не подходит под регулярное выражение, то мы выкинем exception
        // в нашем случае, если будет отсутствовать знак @,то почта некорректна
        if(!pattern.matcher(email).find()){
            throw new IllegalArgumentException("Некорректная почта. Нет '@' ");
        }
    }
}
