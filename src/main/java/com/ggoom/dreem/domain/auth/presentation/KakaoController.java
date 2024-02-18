package com.ggoom.dreem.domain.auth.presentation;


import com.ggoom.dreem.domain.auth.presentation.dto.response.UserInfoResponse;
import com.ggoom.dreem.domain.auth.service.KakaoAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/kakao")
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoAuthService kakaoAuthService;

    @GetMapping("/info")
    public UserInfoResponse GetKakaoUserInfo(@RequestParam String token) {
        return kakaoAuthService.getKakaoProfile(token);
    }

}
