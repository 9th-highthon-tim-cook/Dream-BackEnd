package com.ggoom.dreem.domain.auth.presentation;


import com.ggoom.dreem.domain.auth.presentation.dto.request.LoginRequest;
import com.ggoom.dreem.domain.auth.presentation.dto.response.AccessTokenResponse;
import com.ggoom.dreem.domain.auth.presentation.dto.response.TokenResponse;
import com.ggoom.dreem.domain.auth.service.KakaoUserExistService;
import com.ggoom.dreem.domain.auth.service.LoginService;
import com.ggoom.dreem.domain.auth.service.LogoutService;
import com.ggoom.dreem.domain.auth.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RefreshTokenService refreshTokenService;
    private final LoginService loginService;
    private final KakaoUserExistService kakaoUserExistService;
    private final LogoutService logoutService;


    @PutMapping
    public AccessTokenResponse refreshToken(@RequestHeader(value = "Refresh-Token") String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        kakaoUserExistService.execute(request.getUserId());
        return loginService.execute(request);
    }

    @DeleteMapping("/logout")
    public void logout() {
        logoutService.execute();
    }
}
