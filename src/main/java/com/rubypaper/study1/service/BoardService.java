package com.rubypaper.study1.service;

import com.rubypaper.study1.domain.Board;
import com.rubypaper.study1.dto.BoardDTO;
import com.rubypaper.study1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    public Page getListBoards(int page) {
        return this.boardRepository.findAll(PageRequest.of(page,5));
    }

    @Transactional
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Transactional
    public void delete(Board findBoard) {
        boardRepository.delete(findBoard);
    }
    @Transactional
    public Board update(Board updateBoard, BoardDTO boardDTO) {
        updateBoard.updateBoard(boardDTO.getTitle(),boardDTO.getContent(),boardDTO.getAuthor());
        return updateBoard;
    }
}
