package com.ggoom.dreem.global.infra.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "oauth-info-client", url = "https://kapi.kakao.com")
public interface KakaoInfoClient {

    @PostMapping("/v2/user/me")
    @JsonProperty("id")
    String getProfile(
            @RequestHeader("Authorization") String accessToken
    );

}
