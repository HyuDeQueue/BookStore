package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDTO {
    private String email;
    private String password;

    public User toEntity() {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
