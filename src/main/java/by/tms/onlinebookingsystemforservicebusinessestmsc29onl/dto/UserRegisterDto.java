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
    @NotBlank
    private String username;
    @Size(min = 4, max = 20)
    @NotBlank
    private String password;

    @Email(message = "Некорректный формат email")
    private String email;

    @Pattern(regexp = "^\\+?\\d{10,15}$")
    @NotBlank
    private String phone;

}
