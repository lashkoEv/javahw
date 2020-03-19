package users.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    Phone phone;

    @Override
    public void initialize(Phone constraintAnnotation) {
        this.phone = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches("(^((\\+)?38)?0\\d{9}$)",value);
    }
}