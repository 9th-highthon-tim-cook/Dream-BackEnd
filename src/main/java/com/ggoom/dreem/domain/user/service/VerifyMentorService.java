package com.ggoom.dreem.domain.user.service;

import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifyMentorService {
    UserRepository userRepository;
    public void execute(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow();

    }
}
