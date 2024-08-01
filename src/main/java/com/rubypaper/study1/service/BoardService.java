package com.rubypaper.study1.service;

import com.rubypaper.study1.domain.Board;
import com.rubypaper.study1.dto.BoardDTO;
import com.rubypaper.study1.dto.ResponseDTO;
import com.rubypaper.study1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.border.Border;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public ResponseEntity<ResponseDTO> save(Board board) {
        boardRepository.save(board);
        return new ResponseEntity<>(new ResponseDTO("저장"),HttpStatus.OK);
    }



}
