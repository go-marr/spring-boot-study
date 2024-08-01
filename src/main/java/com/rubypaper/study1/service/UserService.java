package com.rubypaper.study1.service;

import com.rubypaper.study1.domain.User;
import com.rubypaper.study1.dto.UserDTO;
import com.rubypaper.study1.dto.ResponseDTO;
import com.rubypaper.study1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ResponseEntity<ResponseDTO> save(User user) {
        if(!user.getEmail().contains("@"))
            return  new ResponseEntity<>(new ResponseDTO("@ 없음"), HttpStatus.BAD_GATEWAY);
         userRepository.save(user);
         return new ResponseEntity<>(new ResponseDTO("저장"), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ResponseDTO> delete(Long id) {
        User findUser = userRepository.findById(id).orElse(null);
        userRepository.delete(findUser);
        return new ResponseEntity<>(new ResponseDTO("삭제"),HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ResponseDTO> update(Long id, UserDTO userDTO) {
        User findUser = userRepository.findById(id).orElse(null);

        findUser.setName(userDTO.getName());
        findUser.setEmail(userDTO.getEmail());
        findUser.setPhone(userDTO.getPhone());
        return new ResponseEntity<>(new ResponseDTO("수정"),HttpStatus.OK);
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
