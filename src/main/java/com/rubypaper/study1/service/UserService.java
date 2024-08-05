package com.rubypaper.study1.service;

import com.rubypaper.study1.domain.User;
import com.rubypaper.study1.dto.ResponseDTO;
import com.rubypaper.study1.dto.UserDTO;
import com.rubypaper.study1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<ResponseDTO> save(UserDTO userDTO) {
        if(!userDTO.getEmail().contains("@"))
            return  new ResponseEntity<>(new ResponseDTO("@ 없음"), HttpStatus.BAD_GATEWAY);
        User user = userDTO.toEntity();
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseDTO("저장"),HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> delete(User findUser) {
        userRepository.delete(findUser);
        return new ResponseEntity<>(new ResponseDTO("삭제"),HttpStatus.OK);
    }


    public ResponseEntity<ResponseDTO> update(User findUser,UserDTO userDTO) {
        findUser.setName(userDTO.getName());
        findUser.setEmail(userDTO.getEmail());
        findUser.setPhone(userDTO.getPhone());
        return new ResponseEntity<>(new ResponseDTO("수정"),HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }
}
