package com.ggoom.dreem.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponse {
    private KakaoUserInfoResponse kakaoUserInfoResponse;
    private boolean isSignedUp;
}
