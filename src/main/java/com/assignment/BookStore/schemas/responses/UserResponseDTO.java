package com.assignment.BookStore.schemas.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private String id;
    private String name;
    private String email;
    private String role;
    private String phone;
    private String address;
    private String createdAt;
    private String updatedAt;
}
