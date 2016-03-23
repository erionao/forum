package com.logisticsplus.forum.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ForumNotFoundException extends RuntimeException {

    public ForumNotFoundException(String s) {
        super(s);
    }
}
