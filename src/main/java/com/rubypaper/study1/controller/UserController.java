package com.rubypaper.study1.controller;

import com.rubypaper.study1.domain.User;
import com.rubypaper.study1.dto.UserDTO;
import com.rubypaper.study1.dto.ResponseDTO;

import com.rubypaper.study1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody UserDTO userDTO){
        User user = userDTO.toEntity();
        log.info(user.toString());
       return userService.save(user);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable Long id){
        return  userService.delete(id);
    }


    @PatchMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.update(id,userDTO);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

}
