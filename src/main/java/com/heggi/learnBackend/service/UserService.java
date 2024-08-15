package com.heggi.learnBackend.service;


import java.util.List;

import com.heggi.learnBackend.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long userId, UserDto userDto);

    UserDto deleteUser(Long userId);

    UserDto getUserById(Long userID);

    List<UserDto> getAllUsers();
}
