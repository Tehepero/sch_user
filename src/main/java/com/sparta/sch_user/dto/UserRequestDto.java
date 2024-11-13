package com.sparta.sch_user.dto;

import com.sparta.sch_user.entity.User;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private final String writerName;
    private final String email;
    private final String password;

    public UserRequestDto(String writerName, String email, String password) {
        this.writerName = writerName;
        this.email = email;
        this.password = password;
    }

    public User toEntity() {
        return new User(
                this.writerName,
                this.email,
                this.password
        );
    }
}
