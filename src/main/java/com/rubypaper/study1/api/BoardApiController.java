package com.rubypaper.study1.api;

import com.rubypaper.study1.domain.Board;
import com.rubypaper.study1.dto.BoardDTO;
import com.rubypaper.study1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardApiController {
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board")
    public ResponseEntity<List<Board>> getBoard(){
        return new ResponseEntity<>(boardRepository.findAll(),HttpStatus.OK);
    }

    @PostMapping("/board")
    public ResponseEntity<Board> createBoard(@RequestBody  BoardDTO boardDTO){
        Board board = boardDTO.toEntity();
        boardRepository.save(board);
        return new ResponseEntity<>(board,HttpStatus.OK);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long id){
        Board findBoard = boardRepository.findById(id).orElse(null);
        boardRepository.delete(findBoard);
        return new ResponseEntity<>(findBoard,HttpStatus.OK);
    }
    @Transactional
    @PostMapping("board/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long id,@RequestBody BoardDTO boardDTO){
        Board findBoard = boardRepository.findById(id).orElse(null);
        findBoard.updateBoard(boardDTO.getTitle(),boardDTO.getContent(),boardDTO.getAuthor());
        return new ResponseEntity<>(findBoard,HttpStatus.OK);

    }
}
