package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.mapper;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto.UserRegisterDto;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRegisterDto userRegisterDto);
    UserRegisterDto toDto(User user);
}
