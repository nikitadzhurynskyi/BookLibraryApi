package com.flamierd.booklibraryapi.domain.user.service.impl;

import com.flamierd.booklibraryapi.core.exception.NotFoundException;
import com.flamierd.booklibraryapi.domain.user.dto.CreateUserDto;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.repository.UserRepository;
import com.flamierd.booklibraryapi.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByEmailOrThrow(String email) {
        return findByEmail(email).orElseThrow(() ->
                new NotFoundException("User with email=%s has not found".formatted(email)));
    }

    @Override
    public User create(CreateUserDto dto) {
        User user = User.builder()
                .email(dto.email())
                .password(dto.password())
                .authorities(dto.authorities())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String email) {
        return findByEmailOrThrow(email);
    }
}
