package com.assignment.BookStore.dtos.responses;

import com.assignment.BookStore.dtos.jwt.TokenDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private TokenDTO token;
    private UserResponseDTO user;
}
