package com.rubypaper.study1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOARD")
@Getter
public class Board extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String author;


    public Board(String title, String content, String author) {
        this.title=title;
        this.content=content;
        this.author=author;
    }
    public void updateBoard(String title, String content, String author) {
        this.title=title;
        this.content=content;
        this.author=author;
    }
}
