package com.assignment.BookStore.controllers;

import com.assignment.BookStore.dtos.requests.UserRequestDTO;
import com.assignment.BookStore.dtos.responses.UserResponseDTO;
import com.assignment.BookStore.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    private ResponseEntity<UserResponseDTO> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    private ResponseEntity<Page<UserResponseDTO>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return ResponseEntity.ok(userService.getAllUsers(page, limit));
    }

    @PutMapping("/{id}")
    private ResponseEntity<UserResponseDTO> updateUser(@PathVariable String id, @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.updateUser(id, userRequestDTO));
    }

    @DeleteMapping("/{id}")
    private void deleteUser(@PathVariable String id,
                            @RequestParam(defaultValue = "No reason") String banned_reason) {
        userService.deleteUser(id, banned_reason);
    }
}
