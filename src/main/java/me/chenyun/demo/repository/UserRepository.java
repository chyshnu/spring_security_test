package me.chenyun.demo.repository;

import me.chenyun.demo.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> selectUserByUsername(String username);
}
