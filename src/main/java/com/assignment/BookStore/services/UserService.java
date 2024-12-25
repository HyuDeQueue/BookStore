package com.assignment.BookStore.services;

import com.assignment.BookStore.dtos.requests.AuthRequestDTO;
import com.assignment.BookStore.dtos.requests.UserRequestDTO;
import com.assignment.BookStore.dtos.responses.AuthResponseDTO;
import com.assignment.BookStore.dtos.responses.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface UserService {
    AuthResponseDTO login(AuthRequestDTO authRequestDto);
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(String Id);
    Page<UserResponseDTO> getAllUsers(int page, int limit);
    UserResponseDTO updateUser(String Id, UserRequestDTO userRequestDTO);
    void deleteUser(String Id, String banned_reason);
    UserResponseDTO getUserByEmail(String email);

}
