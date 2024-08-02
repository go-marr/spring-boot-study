package com.rubypaper.study1.controller;

import com.rubypaper.study1.domain.User;
import com.rubypaper.study1.dto.UserDTO;
import com.rubypaper.study1.dto.ResponseDTO;

import com.rubypaper.study1.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/users")
    @Transactional
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody UserDTO userDTO){
        if(!userDTO.getEmail().contains("@"))
            return  new ResponseEntity<>(new ResponseDTO("@ 없음"), HttpStatus.BAD_GATEWAY);
        User user = userDTO.toEntity();
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseDTO("저장"), HttpStatus.OK);
    }


    @DeleteMapping("/users/{id}")
    @Transactional
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable Long id){
        User findUser = userRepository.findById(id).orElse(null);
        userRepository.delete(findUser);
        return new ResponseEntity<>(new ResponseDTO("삭제"),HttpStatus.OK);
    }


    @PatchMapping("/users/{id}")
    @Transactional
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        User findUser = userRepository.findById(id).orElse(null);

        findUser.setName(userDTO.getName());
        findUser.setEmail(userDTO.getEmail());
        findUser.setPhone(userDTO.getPhone());
        return new ResponseEntity<>(new ResponseDTO("수정"),HttpStatus.OK);

    }

    @GetMapping("/users")
    @Transactional
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }

}
