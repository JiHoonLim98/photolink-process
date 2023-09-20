package com.example.demo.role.entity;

import com.example.demo.role.enumurate.RoleType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author jerry
 * @description role
 * @since 2023.08.23
 **********************************************************************************************************************/
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    @Builder
    public Role(RoleType roleType) {
        this.roleType = roleType;
    }

    public static Role createUserRole() {
        return Role.builder()
                .roleType(RoleType.USER)
                .build();
    }
}
