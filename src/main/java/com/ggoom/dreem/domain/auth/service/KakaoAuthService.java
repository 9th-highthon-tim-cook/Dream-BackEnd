package com.ggoom.dreem.domain.auth.service;


import com.ggoom.dreem.domain.auth.presentation.dto.response.KakaoUserInfoResponse;
import com.ggoom.dreem.domain.auth.presentation.dto.response.UserInfoResponse;
import com.ggoom.dreem.domain.user.domain.repository.UserRepository;
import com.ggoom.dreem.global.infra.kakao.KakaoInfoClient;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoAuthService {
    private final KakaoInfoClient kakaoInfoClient;
    private final UserRepository userRepository;

    public UserInfoResponse getKakaoProfile(String token) {
//        String response = kakaoLoginClient.getAccessToken(
//                "authorization_code",
//                kakaoInfo.getClientId(),
//                kakaoInfo.getRedirectUri(),
//                code
//        );

        try {
//            String accessToken = new JSONObject(response)
//                    .get("access_token")
//                    .toString();

            String profile = new JSONObject(kakaoInfoClient.getProfile("Bearer " + token))
                    .get("id")
                    .toString();

            KakaoUserInfoResponse kakaoUserInfoResponse = KakaoUserInfoResponse.builder()
                    .id(profile)
                    .build();

            if (userRepository.findByUserId(profile).isPresent()) {
                return UserInfoResponse.builder()
                        .kakaoUserInfoResponse(kakaoUserInfoResponse)
                        .isSignedUp(true)
                        .build();
            } else return UserInfoResponse.builder()
                    .kakaoUserInfoResponse(kakaoUserInfoResponse)
                    .isSignedUp(false)
                    .build();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
