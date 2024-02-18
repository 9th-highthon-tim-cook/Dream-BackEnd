package com.ggoom.dreem.global.security.jwt.exception;

import com.ggoom.dreem.global.error.exception.DreamException;
import com.ggoom.dreem.global.security.jwt.exception.error.JwtErrorProperty;

public class InvalidTokenException extends DreamException {

    public final static InvalidTokenException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(JwtErrorProperty.INVALID_TOKEN);
    }
}