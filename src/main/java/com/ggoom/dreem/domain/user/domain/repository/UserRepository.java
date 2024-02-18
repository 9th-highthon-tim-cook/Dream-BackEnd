package com.ggoom.dreem.domain.user.domain.repository;

import com.ggoom.dreem.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsUserByNickname(String nickname);

    boolean existsUserByUserId(String userId);

    Optional<User> findByUserId(String userId);

    User findUserByUserId(String userId);
}
