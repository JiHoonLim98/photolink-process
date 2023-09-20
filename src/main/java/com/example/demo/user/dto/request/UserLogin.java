package com.example.demo.user.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @since       2023.08.30
 * @author      jerry
 * @description user login
 **********************************************************************************************************************/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLogin {

    private String email;
    private String password;
}
