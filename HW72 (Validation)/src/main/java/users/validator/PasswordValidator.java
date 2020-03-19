package users.validator;

import java.lang.reflect.Method;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator <Password, Object> {
    private String password;
    private String replayPassword;
    private String message;

    @Override
    public void initialize(Password constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.replayPassword = constraintAnnotation.replayPassword();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        try {
            final Object pass = getValid(o, password);
            final Object replayPass = getValid(o, replayPassword);
            if (pass == null && replayPass == null) {
                return true;
            }
            boolean isEquals = pass != null && pass.equals(replayPass);
            if (!isEquals) {
                String msg = this.message;
                if("".equals(this.message) || this.message == null || Password.MESSAGE.equals(this.message)) {
                    msg = "Поля не равны!";
                }
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(msg).addNode(replayPassword).addConstraintViolation();
            }
            return isEquals;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private Object getValid(Object o, String field) {
        Class<?> valueClass = o.getClass();
        String methodName = "get" + Character.toUpperCase(field.charAt(0)) + field.substring(1);
        try {
            Method method = valueClass.getDeclaredMethod(methodName);
            return method.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}