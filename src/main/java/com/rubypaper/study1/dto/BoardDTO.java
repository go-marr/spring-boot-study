package com.rubypaper.study1.dto;

import com.rubypaper.study1.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;


@AllArgsConstructor
@Getter
public class BoardDTO {
    private String title;

    private String content;

    private String author;

    public Board toEntity() {
        return new Board(title,content,author);
    };
}
