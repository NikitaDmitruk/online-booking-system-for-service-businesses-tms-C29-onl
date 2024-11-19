package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {

    @Size(min = 2, max = 20)
    private String username;
    @Size(min = 2, max = 20)
    private String password;
    @Email(message = "Некорректный формат email")
    private String email;

    private String phone;

}
