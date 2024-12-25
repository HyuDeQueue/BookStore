package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.models.User;
import com.assignment.BookStore.repositories.UserRepository;
import com.assignment.BookStore.schemas.jwt.CustomUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class JwtUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Email not found");
        }
        return new CustomUserDetails(user);
    }
}
