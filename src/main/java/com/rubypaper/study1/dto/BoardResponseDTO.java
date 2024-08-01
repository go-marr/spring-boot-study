package com.rubypaper.study1.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDTO {
    private String title;

    private String content;

    private String author;

    private Date date;
}
