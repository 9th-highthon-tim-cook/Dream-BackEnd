package com.ggoom.dreem.domain.user.presentation;

import com.ggoom.dreem.domain.user.presentation.dto.request.SignUpRequest;
import com.ggoom.dreem.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignUpService signUpService;


    @PostMapping("/signup")
    public void Signup(@RequestBody SignUpRequest request) {
        signUpService.execute(request);
    }

}
