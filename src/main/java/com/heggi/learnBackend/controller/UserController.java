package com.heggi.learnBackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heggi.learnBackend.dto.BaseResponseDto;
import com.heggi.learnBackend.dto.UserDto;

import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


// Handling HTTP Request
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private com.heggi.learnBackend.service.UserService userService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> createUser(@RequestBody UserDto userDto){
        BaseResponseDto response = null;

        UserDto saveUser = userService.createUser(userDto);
        
        if(saveUser.getId() != null){            
            response = new BaseResponseDto("200","Success Inserting Data",saveUser);
        }else{
            response = new BaseResponseDto("404","Failed Inserting Data","");
        }

        return ResponseEntity.ok(response);
    }

    // Update Functionality
    @PostMapping("/update/{id}")    
    public ResponseEntity<BaseResponseDto> updateUser(@PathVariable("id") Long userID, @RequestBody UserDto userDto){
        BaseResponseDto response = null;

        UserDto updateUser = userService.updateUser(userID, userDto);
        
        if(updateUser.getId() != null){            
            response = new BaseResponseDto("200","Success Update Data",updateUser);
        }else{
            response = new BaseResponseDto("404","Data Not Found","");
        }

        return ResponseEntity.ok(response);
    }

    // Delete Functionality 
    @PostMapping("/delete/{id}")
    public ResponseEntity<BaseResponseDto> deleteUser(@PathVariable("id") Long userID){
        BaseResponseDto response = null;

        UserDto deleteUser = userService.deleteUser(userID);
        
        if(deleteUser.getId() != null){            
            response = new BaseResponseDto("200","Success Delete Data",deleteUser);
        }else{
            response = new BaseResponseDto("404","Data Not Found","");
        }

        return ResponseEntity.ok(response);
    }
    

    // Getter Employee By ID
    @GetMapping("{id}")
    public ResponseEntity<BaseResponseDto> getUserById(@PathVariable("id") Long userID){
        BaseResponseDto response = null;
        UserDto userDto =  userService.getUserById(userID);
       
        if(userDto.getId() != null){            
            response = new BaseResponseDto("200","Success Get Data",userDto);
        }else{
            response = new BaseResponseDto("404","Data Not Found","");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getAllUser(){
        BaseResponseDto response = null;
        List<UserDto> usersDto =  userService.getAllUsers();

        response = new BaseResponseDto("200","Success Get Data",usersDto);
        return ResponseEntity.ok(response);
    }
}
