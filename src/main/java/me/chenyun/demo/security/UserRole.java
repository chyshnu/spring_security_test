package me.chenyun.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static me.chenyun.demo.security.UserPermission.*;

public enum UserRole {
    GUEST(Collections.emptySet()),
    STUDENT(new HashSet<>(Arrays.asList(COURSE_READ, STUDENT_READ))),
    MAINTAINER(new HashSet<>(Arrays.asList(COURSE_READ, COURSE_WRITE, STUDENT_READ))),
    ADMIN(new HashSet<>(Arrays.asList(COURSE_WRITE, COURSE_READ, STUDENT_READ, STUDENT_WRITE)));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
