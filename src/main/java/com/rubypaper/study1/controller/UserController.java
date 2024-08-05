package com.rubypaper.study1.controller;

import com.rubypaper.study1.domain.User;
import com.rubypaper.study1.dto.UserDTO;
import com.rubypaper.study1.dto.ResponseDTO;

import com.rubypaper.study1.repository.UserRepository;
import com.rubypaper.study1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @PostMapping("/users")
    @Transactional
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }


    @DeleteMapping("/users/{id}")
    @Transactional
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable Long id){
        User findUser = userRepository.findById(id).orElse(null);
        return userService.delete(findUser);
    }

    @PatchMapping("/users/{id}")
    @Transactional
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        User findUser = userRepository.findById(id).orElse(null);
        return userService.update(findUser,userDTO);
    }

    @GetMapping("/users")
    @Transactional
    public ResponseEntity<List<User>> getUsers(){
        return userService.getUsers();
    }

}
