package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
