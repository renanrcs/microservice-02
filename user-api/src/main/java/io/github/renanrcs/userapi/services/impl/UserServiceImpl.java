package io.github.renanrcs.userapi.services.impl;

import io.github.renanrcs.userapi.domain.User;
import io.github.renanrcs.userapi.repositories.UserRepository;
import io.github.renanrcs.userapi.services.UserService;
import io.github.renanrcs.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Environment env;

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found" + "test commit"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
