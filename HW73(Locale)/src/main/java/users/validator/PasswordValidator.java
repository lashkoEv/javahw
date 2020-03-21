package users.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import users.model.User;


@Component
public class PasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (!user.getPassword().equals(user.getReplayPassword())) {
            errors.rejectValue("password", "user.rePassword");
        }
    }
}

