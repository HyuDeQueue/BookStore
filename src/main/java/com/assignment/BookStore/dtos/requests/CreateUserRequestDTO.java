package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateUserRequestDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;

    public User toEntity() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setPhone(this.phone);
        user.setAddress(this.address);
        return user;
    }
}
