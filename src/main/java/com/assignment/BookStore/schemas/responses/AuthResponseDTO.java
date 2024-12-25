package com.assignment.BookStore.schemas.responses;

import com.assignment.BookStore.schemas.jwt.TokenDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private TokenDTO token;
    private UserResponseDTO user;
}
