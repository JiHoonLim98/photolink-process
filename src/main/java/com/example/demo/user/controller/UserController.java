package com.example.demo.user.controller;

import com.example.demo.user.dto.request.UserCreate;
import com.example.demo.user.dto.request.UserLogin;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author jerry
 * @description user controller
 * @since 2023.08.23
 **********************************************************************************************************************/
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signUp")
    public void signUp(@Valid @RequestBody UserCreate userCreate) {
        userService.signUp(userCreate);
    }

    @GetMapping("/user/check/{email}")
    public boolean checkLoginId(@PathVariable String email) {
        return userService.checkLoginId(email);
    }

    @GetMapping("/user/login")
    public void login(@Valid @RequestBody UserLogin userLogin) {
        userService.login(userLogin);
    }
}
