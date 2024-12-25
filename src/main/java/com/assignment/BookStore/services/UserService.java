package com.assignment.BookStore.services;

import com.assignment.BookStore.schemas.requests.AuthRequestDTO;
import com.assignment.BookStore.schemas.requests.UserRequestDTO;
import com.assignment.BookStore.schemas.responses.AuthResponseDTO;
import com.assignment.BookStore.schemas.responses.UserResponseDTO;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserService {
    AuthResponseDTO login(AuthRequestDTO authRequestDto);
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(UUID Id);
    Page<UserResponseDTO> getAllUsers(int page, int limit);
    UserResponseDTO updateUser(String Id, UserRequestDTO userRequestDTO);
    void deleteUser(String Id, String banned_reason);
    UserResponseDTO getUserByEmail(String email);

}
