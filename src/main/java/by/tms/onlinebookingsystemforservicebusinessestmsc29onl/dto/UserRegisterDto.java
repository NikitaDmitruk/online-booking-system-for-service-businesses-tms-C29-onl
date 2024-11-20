package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterDto {

    @Size(min = 4, max = 20)
    @NotBlank(message = "Имя пользователя не может быть пустым или состоять только из пробелов")
    private String username;
    @Size(min = 4, max = 20)
    @NotBlank(message = "Пароль не может быть пустым или состоять только из пробелов")
    private String password;

    @Email(message = "Некорректный формат email")
    private String email;

    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Формат номера +12345678910. Номер должен содержать от 10 до 15 цифр")
    @NotBlank(message = "Номер телефона не может быть пустым")
    private String phone;

}
