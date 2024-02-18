package com.ggoom.dreem.domain.user.service;

import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.domain.user.domain.enums.UserType;
import com.ggoom.dreem.domain.user.domain.repository.MentorRepository;
import com.ggoom.dreem.domain.user.domain.repository.UserRepository;
import com.ggoom.dreem.domain.user.exception.UserAlreadyExistsException;
import com.ggoom.dreem.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;
    private final MentorRepository mentorRepository;

    @Transactional
    public void execute(SignUpRequest request) {
        userRepository.findByUserId(request.getUserId())
                .ifPresent(m -> {
                    throw UserAlreadyExistsException.EXCEPTION;
                });
        User user = userRepository.save(request.toEntityUser());
        if (request.getUserType().equals(UserType.MENTOR)) {
            mentorRepository.save(request.toEntityMentor(user));
        }
    }
}
