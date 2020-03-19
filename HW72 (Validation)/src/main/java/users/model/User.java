package users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import users.validator.Password;
import users.validator.Phone;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Password(password = "password", replayPassword = "replayPassword", message = "Введённые значения не совпадают!")
public class User {
    @NotBlank(message = "Поле не должно быть пустым!")
    private String login;
    @NotBlank(message = "Поле не должно быть пустым!")
    private String password;
    @NotBlank(message = "Поле не должно быть пустым!")
    private String replayPassword;
    @NotBlank(message = "Поле не должно быть пустым!")
    @Email
    private String email;
    @Phone(message = "Введённый формат телефона неверный!")
    private String phone;
    private String gender;
}