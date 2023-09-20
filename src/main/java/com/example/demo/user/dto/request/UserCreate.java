package com.example.demo.user.dto.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author jerry
 * @description user create
 * @since 2023.08.23
 **********************************************************************************************************************/
@Getter
public class UserCreate {

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private LocalDate birthday;

    private String introduction;

}
