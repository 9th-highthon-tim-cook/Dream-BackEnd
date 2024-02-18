package com.ggoom.dreem.domain.user.presentation.dto.request;

import com.ggoom.dreem.domain.user.domain.Mentor;
import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.domain.user.domain.enums.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {


    private String nickname;

    private String userId;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private int salary;
    private String career;
    private String company;
    private int careerYear;
    private String description;

    public User toEntityUser() {
        return User.builder()
                .userId(userId)
                .nickname(nickname)
                .userType(userType)
                .build();
    }
    public Mentor toEntityMentor(User user) {
        return Mentor.builder()
                .salary(salary)
                .career(career)
                .company(company)
                .careerYear(careerYear)
                .user(user)
                .description(description)
                .build();
    }

}
