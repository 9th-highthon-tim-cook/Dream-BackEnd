package com.ggoom.dreem.domain.user.exception.error;


import com.ggoom.dreem.global.error.exception.DreamException;

public class UserIsDeactivateException extends DreamException {
    public final static UserIsDeactivateException EXCEPTION = new UserIsDeactivateException();

    private UserIsDeactivateException() {
        super(UserErrorProperty.USER_IS_DEACTIVATED);
    }
}
