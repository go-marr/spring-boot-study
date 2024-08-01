package com.rubypaper.study1.domain;

import com.rubypaper.study1.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name="USERS")
@Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;


    public User (String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


}
