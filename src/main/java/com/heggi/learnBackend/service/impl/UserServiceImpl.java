package com.heggi.learnBackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.heggi.learnBackend.dto.UserDto;
import com.heggi.learnBackend.entity.User;
import com.heggi.learnBackend.exception.ResourceNotFoundException;
import com.heggi.learnBackend.mapper.UserMapper;
import com.heggi.learnBackend.repository.UserRepository;
import com.heggi.learnBackend.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository UserRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        // From Database Map to Entity
        User user = UserMapper.mapToUser(userDto);

        // Saving Data to Repository
        User savedUser = UserRepository.save(user);
        
        // Mapper to DTO
        return UserMapper.mapToUserDto(savedUser); 
    }

    @Override
    public UserDto getUserById(Long userID) {
        User user  = UserRepository.findById(userID)
            .orElseThrow(() -> new ResourceNotFoundException("User is Not Exist"));
        
        return UserMapper.mapToUserDto(user);
        
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = UserRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = UserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User is Not Exist"));

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setModifiedBy(userDto.getModifiedBy());
        user.setModifiedDate(userDto.getModifiedDate());

        User updatedData = UserRepository.save(user);

        return UserMapper.mapToUserDto(updatedData);
    }

    @Override
    public UserDto deleteUser(Long userId) {      
        try{
            User user = UserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User is Not Exist"));
            UserRepository.deleteById(userId);

            return UserMapper.mapToUserDto(user);
        }catch(Exception ex){
            return new UserDto();
        }
    }
    
}
