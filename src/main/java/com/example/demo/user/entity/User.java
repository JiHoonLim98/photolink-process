package com.example.demo.user.entity;

import com.example.demo.role.entity.Role;
import com.example.demo.role.enumurate.RoleType;
import com.example.demo.user.dto.request.UserCreate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * @author jerry
 * @description user
 * @since 2023.08.23
 **********************************************************************************************************************/
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String password;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 11)
    private String phoneNumber;

    @Column(nullable = false, length = 64)
    private String email;

    private LocalDate birthday;

    @Column(length = 128)
    private String introduction;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "role_id")
    private Role role;

    @Builder
    public User(String password, String name, String phoneNumber, String email, LocalDate birthday, String introduction, Role role) {
        this.password     = password;
        this.name         = name;
        this.phoneNumber  = phoneNumber;
        this.email        = email;
        this.birthday     = birthday;
        this.introduction = introduction;
        this.role         = role;
    }

    public static User create(UserCreate userCreate, PasswordEncoder passwordEncoder) {
        return User.builder()
                .password    (passwordEncoder.encode(userCreate.getPassword()))
                .name        (userCreate.getName())
                .phoneNumber (userCreate.getPhoneNumber())
                .email       (userCreate.getEmail())
                .birthday    (userCreate.getBirthday())
                .introduction(userCreate.getIntroduction())
                .role        (Role.createUserRole())
                .build();
    }
}
