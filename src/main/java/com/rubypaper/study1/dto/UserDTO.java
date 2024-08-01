package com.rubypaper.study1.dto;
import com.rubypaper.study1.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String phone;

    public User toEntity() {
        return new User(name, email, phone);
        };


    }


