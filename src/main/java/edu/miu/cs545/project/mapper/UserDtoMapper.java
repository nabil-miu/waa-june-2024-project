package edu.miu.cs545.project.mapper;

import edu.miu.cs545.project.dto.UserDto;
import edu.miu.cs545.project.model.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserDtoMapper {
    UserDto toUserDto(User user);

    User toUser(UserDto userDto);
}
