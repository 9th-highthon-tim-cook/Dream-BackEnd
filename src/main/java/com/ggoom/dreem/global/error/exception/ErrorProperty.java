package com.ggoom.dreem.global.error.exception;

import org.springframework.http.HttpStatus;

public interface ErrorProperty {
    HttpStatus getStatus();

    String getMessage();
}
