package innopolisLection.validators;

public class EmailValidatorImplByLength implements EmailValidator{

    private int minLength;

    public EmailValidatorImplByLength(int minLength){
        this.minLength =minLength;
    }

    @Override
    public void validate(String email) {
        if(email.length()<minLength){
            throw new IllegalArgumentException("Dlina pochty nekorrektna!");
        }

    }
}
