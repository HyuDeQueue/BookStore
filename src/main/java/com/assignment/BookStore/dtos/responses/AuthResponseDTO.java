package com.assignment.BookStore.dtos.responses;

import com.assignment.BookStore.dtos.jwt.TokenDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthResponseDTO {
    private TokenDTO token;
    private UserResponseDTO user;

    public static AuthResponseDTO toDto(TokenDTO token, UserResponseDTO user) {
        return new AuthResponseDTO(token, user);
    }
}
