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
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String replayPassword;
    @NotBlank
    @Email
    private String email;
    @Phone
    private String phone;
    @NotBlank
    private String gender;
}