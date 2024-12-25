package com.assignment.BookStore.controllers;

import com.assignment.BookStore.dtos.requests.AuthRequestDTO;
import com.assignment.BookStore.dtos.requests.UserRequestDTO;
import com.assignment.BookStore.dtos.responses.AuthResponseDTO;
import com.assignment.BookStore.dtos.responses.UserResponseDTO;
import com.assignment.BookStore.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    private ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authRequestDto) {
        return ResponseEntity.ok(userService.login(authRequestDto));
    }

    @PostMapping("/register")
    private ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO userRequestDto) {
        return new ResponseEntity<>(userService.createUser(userRequestDto), HttpStatus.CREATED);
    }
}
