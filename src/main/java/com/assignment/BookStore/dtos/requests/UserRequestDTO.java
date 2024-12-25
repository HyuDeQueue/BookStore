package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequestDTO {

    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private String bannedReason;

    public User toEntity() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setRole(this.role);
        user.setPhone(this.phone);
        user.setAddress(this.address);
        user.setCreatedAt(this.createdAt);
        user.setUpdatedAt(this.updatedAt);
        user.setStatus(this.status);
        user.setBannedReason(this.bannedReason);
        return user;
    }
}
