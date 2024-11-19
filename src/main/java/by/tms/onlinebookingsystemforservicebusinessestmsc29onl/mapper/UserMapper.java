package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.mapper;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto.UserRegisterDto;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface UserMapper {

    User userRegisterDtoToUser(UserRegisterDto userRegisterDto);

    UserRegisterDto userToUserRegisterDto(User user);
}
