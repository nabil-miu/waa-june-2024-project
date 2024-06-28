package edu.miu.cs545.project.mapper.impl;

import edu.miu.cs545.project.dto.UserDto;
import edu.miu.cs545.project.mapper.UserDtoMapper;
import edu.miu.cs545.project.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoMapperImpl implements UserDtoMapper {
    @Override
    public UserDto toUserDto(User user) {
        //TODO: Implement this method
        return null;
    }

    @Override
    public User toUser(UserDto userDto) {
        //TODO: Implement this method
        return null;
    }
}
