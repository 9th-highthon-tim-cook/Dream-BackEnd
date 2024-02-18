package com.ggoom.dreem.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DreamException extends RuntimeException {

    private final ErrorProperty errorProperty;

}
