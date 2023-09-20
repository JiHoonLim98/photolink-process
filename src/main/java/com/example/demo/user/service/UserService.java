package com.example.demo.user.service;

import com.example.demo.user.dto.request.UserCreate;
import com.example.demo.user.dto.request.UserLogin;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author jerry
 * @description user service
 * @since 2023.08.23
 **********************************************************************************************************************/
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void signUp(UserCreate userCreate) {
        User user = User.create(userCreate, passwordEncoder);
        userRepository.save(user);
    }

    public boolean checkLoginId(String email) {
        return userRepository.existsByEmail(email);
    }

    public void login(UserLogin userLogin) {
        userRepository.findByEmail(userLogin.getEmail()).orElseThrow(NotFoundException::new);
    }
}
