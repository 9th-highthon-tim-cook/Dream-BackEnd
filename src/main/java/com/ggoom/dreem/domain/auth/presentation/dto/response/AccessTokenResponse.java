package com.ggoom.dreem.domain.auth.presentation.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AccessTokenResponse {

    private String accessToken;
}