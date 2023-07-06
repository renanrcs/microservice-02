package io.github.renanrcs.userapi.services;

import io.github.renanrcs.userapi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
}
