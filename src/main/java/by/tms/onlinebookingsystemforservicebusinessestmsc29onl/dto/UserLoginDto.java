package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

    @NotBlank(message = "Имя пользователя не может быть пустым или состоять только из пробелов")
    private String username;
    @NotBlank(message = "Пароль не может быть пустым или состоять только из пробелов")
    private String password;
}
