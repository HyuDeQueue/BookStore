package com.assignment.BookStore.services.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.assignment.BookStore.entities.User;
import com.assignment.BookStore.repositories.UserRepository;
import com.assignment.BookStore.dtos.jwt.CustomUserDetails;
import com.assignment.BookStore.dtos.jwt.TokenDTO;
import com.assignment.BookStore.dtos.requests.AuthRequestDTO;
import com.assignment.BookStore.dtos.requests.UserRequestDTO;
import com.assignment.BookStore.dtos.responses.AuthResponseDTO;
import com.assignment.BookStore.dtos.responses.UserResponseDTO;
import com.assignment.BookStore.services.UserService;
import com.assignment.BookStore.utils.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthResponseDTO login(AuthRequestDTO authRequestDto) {
        User user = userRepository.findByEmail(authRequestDto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,("User not found")));
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("User not found"));
        }
        if (user.getStatus().equals("banned")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("User is banned, reason is: " + user.getBannedReason()));
        }
        if (!BCrypt.verifyer().verify(authRequestDto.getPassword().toCharArray(), user.getPassword()).verified) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Wrong password"));
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        AuthResponseDTO authResponseDto = new AuthResponseDTO();

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setAddress(user.getAddress());
        userResponseDTO.setCreatedAt(user.getCreatedAt());
        userResponseDTO.setUpdatedAt(user.getUpdatedAt());
        TokenDTO tokenDto = new TokenDTO();
        tokenDto.setToken(token);
        authResponseDto.setToken(tokenDto);
        authResponseDto.setUser(userResponseDTO);
        return authResponseDto;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        return UserResponseDTO.toDto(userRepository.save(userRequestDTO.toEntity()));
    }

    @Override
    public UserResponseDTO getUserById(String Id) {
        return userRepository.findById(Id)
                .map(UserResponseDTO::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Override
    public Page<UserResponseDTO> getAllUsers(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserResponseDTO::toDto);
    }

    @Override
    public UserResponseDTO updateUser(String Id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(Id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setAddress(userRequestDTO.getAddress());
        return UserResponseDTO.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(String Id, String banned_reason) {
        User user = userRepository.findById(Id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setStatus("banned");
        user.setBannedReason(banned_reason);
        userRepository.save(user);
    }

    @Override
    public UserResponseDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserResponseDTO::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
}
