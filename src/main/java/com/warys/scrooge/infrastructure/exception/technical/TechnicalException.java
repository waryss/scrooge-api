package com.warys.scrooge.infrastructure.exception.technical;

import com.warys.scrooge.infrastructure.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class TechnicalException extends ApiException {

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
