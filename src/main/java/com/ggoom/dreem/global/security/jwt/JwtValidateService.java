package com.ggoom.dreem.global.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JwtValidateService {

    private final JwtTokenProvider jwtTokenProvider;

    public String getUserId(String token) {
        return jwtTokenProvider.extractAllClaims(token)
                .get("userId", String.class);
    }
}
