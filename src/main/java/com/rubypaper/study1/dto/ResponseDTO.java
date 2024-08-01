package com.rubypaper.study1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDTO {
    private String msg;

    public ResponseDTO(String msg){
        this.msg=msg;
    }
}
