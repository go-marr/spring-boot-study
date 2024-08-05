package com.rubypaper.study1.service;

import com.rubypaper.study1.domain.Board;
import com.rubypaper.study1.dto.BoardDTO;
import com.rubypaper.study1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    public ResponseEntity<List<Board>> getBoards() {
        return new ResponseEntity<>(boardRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Page<Board>> getListBoards(int page) {
        return new ResponseEntity<>(this.boardRepository.findAll(PageRequest.of(page,5)),HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Board> save(Board board) {
        boardRepository.save(board);
        return new ResponseEntity<>(board,HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Board> delete(Board findBoard) {
        boardRepository.delete(findBoard);
        return new ResponseEntity<>(findBoard,HttpStatus.OK);
    }

    public ResponseEntity<Board> update(Board findBoard, BoardDTO boardDTO) {
        findBoard.updateBoard(boardDTO.getTitle(),boardDTO.getContent(),boardDTO.getAuthor());
        return new ResponseEntity<>(findBoard,HttpStatus.OK);
    }
}
