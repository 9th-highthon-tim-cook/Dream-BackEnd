package com.ggoom.dreem.global.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter
@AllArgsConstructor
@ConfigurationProperties("jwt")
@RefreshScope
public class JwtProperties {

    private Long accessExp;
    private Long refreshExp;
    private String prefix;
    private String header;
    private String secretKey;
}
