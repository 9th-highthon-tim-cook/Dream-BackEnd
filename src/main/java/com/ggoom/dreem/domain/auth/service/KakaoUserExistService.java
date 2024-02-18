package com.ggoom.dreem.domain.auth.service;

import com.ggoom.dreem.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoUserExistService {
    private final UserFacade userFacade;

    public void execute(String userId) {
        userFacade.existsUserByUserId(userId);
    }
}
