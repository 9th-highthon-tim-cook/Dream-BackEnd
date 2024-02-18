package com.ggoom.dreem.domain.user.exception;

import com.ggoom.dreem.domain.user.exception.error.UserErrorProperty;
import com.ggoom.dreem.global.error.exception.DreamException;

public class UserAlreadyExistsException extends DreamException {
    public final static UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(UserErrorProperty.USER_ALREADY_EXISTS);
    }
}
