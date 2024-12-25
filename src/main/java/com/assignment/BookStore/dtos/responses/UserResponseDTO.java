package com.assignment.BookStore.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponseDTO {
    private String id;
    private String name;
    private String email;
    private String role;
    private String phone;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserResponseDTO toDto(com.assignment.BookStore.entities.User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getPhone(),
                user.getAddress(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
