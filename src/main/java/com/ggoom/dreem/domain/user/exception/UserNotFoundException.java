package com.ggoom.dreem.domain.user.exception;


import com.ggoom.dreem.domain.user.exception.error.UserErrorProperty;
import com.ggoom.dreem.global.error.exception.DreamException;

public class UserNotFoundException extends DreamException {
    public final static UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
