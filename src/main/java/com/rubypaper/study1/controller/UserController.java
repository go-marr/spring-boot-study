package com.rubypaper.study1.controller;

import com.rubypaper.study1.domain.User;
import com.rubypaper.study1.dto.UserDTO;
import com.rubypaper.study1.dto.ResponseDTO;

import com.rubypaper.study1.repository.UserRepository;
import com.rubypaper.study1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
//    @Autowired
//    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @PostMapping("/users")
    @Transactional
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody UserDTO userDTO){
        if(!userDTO.getEmail().contains("@"))
            return  new ResponseEntity<>(new ResponseDTO("@ 없음"), HttpStatus.BAD_GATEWAY);
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.OK);
    }


    @DeleteMapping("/users/{id}")
    @Transactional
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    @Transactional
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.update(id,userDTO),HttpStatus.OK);
    }

    @GetMapping("/users")
    @Transactional
    public ResponseEntity<List<User>> getUsers(){
        List<User> userList = userService.getUsers();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

}
