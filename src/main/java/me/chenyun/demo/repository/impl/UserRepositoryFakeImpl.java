package me.chenyun.demo.repository.impl;

import lombok.RequiredArgsConstructor;
import me.chenyun.demo.entity.User;
import me.chenyun.demo.repository.UserRepository;
import me.chenyun.demo.security.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static me.chenyun.demo.security.UserRole.*;

@Repository("fake")
@RequiredArgsConstructor
public class UserRepositoryFakeImpl implements UserRepository {
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> selectUserByUsername(String username) {
        return getUsers()
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }

    private List<User> getUsers() {
        List<User> users = Arrays.asList(
            new User("admin",
                    passwordEncoder.encode("123123"),
                    ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true),
            new User("chenyun",
                    passwordEncoder.encode("123123"),
                    MAINTAINER.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true),
            new User("zhangsan",
                    passwordEncoder.encode("123123"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true),
            new User("lisi",
                    passwordEncoder.encode("123123"),
                    GUEST.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true)
        );
        return users;
    }
}
