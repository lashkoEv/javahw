package users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import users.validator.Phone;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotBlank(message = "Поле не должно быть пустым!")
    private String login;
    @NotBlank(message = "Поле не должно быть пустым!")
    private String password;
    @NotBlank(message = "Поле не должно быть пустым!")
    @Email
    private String email;
    @Phone(message = "Введённый формат телефона неверный!")
    private String phone;
    @NotBlank(message = "Поле не должно быть пустым!")
    private String gender;
}