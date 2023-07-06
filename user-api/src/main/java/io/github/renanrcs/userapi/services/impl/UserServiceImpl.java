package io.github.renanrcs.userapi.services.impl;

import io.github.renanrcs.userapi.domain.User;
import io.github.renanrcs.userapi.repositories.UserRepository;
import io.github.renanrcs.userapi.services.UserService;
import io.github.renanrcs.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found" + "test commit"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
