package com.ggoom.dreem.global.security.jwt.exception;


import com.ggoom.dreem.global.error.exception.DreamException;
import com.ggoom.dreem.global.security.jwt.exception.error.JwtErrorProperty;

public class ExpiredTokenException extends DreamException {

    public final static ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(JwtErrorProperty.EXPIRED_TOKEN);
    }
}