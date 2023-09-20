package com.example.demo.role.enumurate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author jerry
 * @description role type
 * @since 2023.08.24
 **********************************************************************************************************************/
@Getter
@RequiredArgsConstructor
public enum RoleType {

    USER    ("일반사용자"),
    MANAGER ("매니저"),
    ADMIN   ("관리자")
    ;

    private final String description;
}
