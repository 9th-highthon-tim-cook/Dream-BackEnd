package com.ggoom.dreem.global.infra.kakao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "oauth2.kakao")
public class KakaoInfo {

    private String baseUrl;
    private String clientId;
    private String redirectUri;
    private String secretKey;
    private String grantType;

}
