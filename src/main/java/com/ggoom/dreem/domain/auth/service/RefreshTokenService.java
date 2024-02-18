package com.ggoom.dreem.domain.auth.service;


import com.ggoom.dreem.domain.auth.domain.RefreshToken;
import com.ggoom.dreem.domain.auth.domain.repository.RefreshTokenRepository;
import com.ggoom.dreem.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.ggoom.dreem.global.security.jwt.JwtTokenProvider;
import com.ggoom.dreem.global.security.jwt.exception.ExpiredTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AccessTokenResponse execute(String token) {
        RefreshToken refreshToken = getRefreshToken(token);
        return AccessTokenResponse.builder().accessToken(jwtTokenProvider.generateAccessToken(refreshToken.getUserId())).build();
    }

    private RefreshToken getRefreshToken(String token) {
        return refreshTokenRepository.findById(token).orElseThrow(() -> ExpiredTokenException.EXCEPTION);
    }
}

