package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String address;
    private String createdAt;
    private String updatedAt;
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
