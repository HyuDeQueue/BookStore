package com.assignment.BookStore.dtos.requests;

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
}
