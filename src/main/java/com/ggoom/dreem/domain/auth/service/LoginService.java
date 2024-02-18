package com.ggoom.dreem.domain.auth.service;


import com.ggoom.dreem.domain.auth.presentation.dto.request.LoginRequest;
import com.ggoom.dreem.domain.auth.presentation.dto.response.TokenResponse;
import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.domain.user.domain.repository.UserRepository;
import com.ggoom.dreem.domain.user.exception.UserNotFoundException;
import com.ggoom.dreem.domain.user.facade.UserFacade;
import com.ggoom.dreem.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class, noRollbackFor = UserNotFoundException.class)
    public TokenResponse execute(LoginRequest request) {
        User user = userFacade.findUserByUserId(request.getUserId());
        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getUserId()))
                .refreshToken(jwtTokenProvider.generateRefreshToken(user.getUserId()))
                .name(user.getNickname())
                .userId(user.getUserId())
                .build();
    }

}
