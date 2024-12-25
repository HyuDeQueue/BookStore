package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.entities.User;
import com.assignment.BookStore.repositories.UserRepository;
import com.assignment.BookStore.dtos.jwt.CustomUserDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class JwtUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public CustomUserDetailsDTO loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new CustomUserDetailsDTO(user);
    }
}
