package com.ggoom.dreem.domain.auth.service;


import com.ggoom.dreem.domain.auth.domain.repository.RefreshTokenRepository;
import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogoutService {

    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser(false);
        refreshTokenRepository.findByUserId(user.getUserId())
                .ifPresent(refreshTokenRepository::delete);
    }
}
