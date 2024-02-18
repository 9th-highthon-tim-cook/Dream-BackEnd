package com.ggoom.dreem.domain.auth.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotNull
    private String userId;

}
