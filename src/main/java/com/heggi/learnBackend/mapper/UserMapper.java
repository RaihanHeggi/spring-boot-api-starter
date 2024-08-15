package com.heggi.learnBackend.mapper;

import com.heggi.learnBackend.dto.UserDto;
import com.heggi.learnBackend.entity.User;

public class UserMapper {
   
    public static UserDto mapToUserDto(User user){
        return new UserDto(
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            user.getCreatedBy(),
            user.getCreatedDate(),
            user.getModifiedBy(),
            user.getModifiedDate()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
            userDto.getId(),
            userDto.getUsername(),
            userDto.getPassword(),
            userDto.getCreatedBy(),
            userDto.getCreatedDate(),
            userDto.getModifiedBy(),
            userDto.getModifiedDate()
        );
    } 

}
