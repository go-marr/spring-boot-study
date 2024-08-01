package com.rubypaper.study1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOARD")
@Getter
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String author;

    @Column
    private Date date;

    public Board(String title, String content, String author, Date date) {
        this.title=title;
        this.content=content;
        this.author=author;
        this.date=date;
    }


    public void updateBoard(String title, String content, String author, Date date) {
        this.title=title;
        this.content=content;
        this.author=author;
        this.date=date;
    }
}
