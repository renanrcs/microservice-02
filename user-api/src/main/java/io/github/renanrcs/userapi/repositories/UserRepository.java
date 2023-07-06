package io.github.renanrcs.userapi.repositories;

import io.github.renanrcs.userapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
