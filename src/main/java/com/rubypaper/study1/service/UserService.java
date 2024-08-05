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

    public ResponseDTO save(UserDTO userDTO) {
        User user = userDTO.toEntity();
        userRepository.save(user);
        return new ResponseDTO("저장");
    }

    public ResponseDTO delete(Long id) {
        User findUser = userRepository.findById(id).orElse(null);
        userRepository.delete(findUser);
        return new ResponseDTO("삭제");
    }


    public ResponseDTO update(Long id,UserDTO userDTO) {
        User findUser = userRepository.findById(id).orElse(null);
        findUser.setName(userDTO.getName());
        findUser.setEmail(userDTO.getEmail());
        findUser.setPhone(userDTO.getPhone());
        return new ResponseDTO("수정");
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
