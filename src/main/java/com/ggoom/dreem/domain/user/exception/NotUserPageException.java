package com.ggoom.dreem.domain.user.exception;


import com.ggoom.dreem.domain.user.exception.error.UserErrorProperty;
import com.ggoom.dreem.global.error.exception.DreamException;

public class NotUserPageException extends DreamException {
    public final static NotUserPageException EXCEPTION = new NotUserPageException();

    private NotUserPageException() {
        super(UserErrorProperty.NOT_USER_PAGE);
    }
}
