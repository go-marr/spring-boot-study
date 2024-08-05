package com.rubypaper.study1.api;

import com.rubypaper.study1.domain.Board;
import com.rubypaper.study1.dto.BoardDTO;
import com.rubypaper.study1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardApiController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<List<Board>> getBoards(){
        return new ResponseEntity<>(boardService.getBoards(), HttpStatus.OK);
    }

    @GetMapping("/board/list")
    public ResponseEntity<Page<Board>> getListBoards(@RequestParam(value="page",defaultValue = "0") int page){
        return new ResponseEntity<>(boardService.getListBoards(page),HttpStatus.OK);
    }

    @PostMapping("/board")
    public ResponseEntity<Board> createBoard(@RequestBody  BoardDTO boardDTO){
        Board board = boardDTO.toEntity();
        return new ResponseEntity<>(boardService.save(board),HttpStatus.OK);

    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long id){
       Board deleteBoard = boardService.delete(id);
        return new ResponseEntity<>(deleteBoard,HttpStatus.OK);
    }
    @Transactional
    @PostMapping("/board/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long id,@RequestBody BoardDTO boardDTO){
        return new ResponseEntity<>(boardService.update(id,boardDTO),HttpStatus.OK);

    }
}
