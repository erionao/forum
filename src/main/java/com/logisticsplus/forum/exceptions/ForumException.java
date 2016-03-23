package com.logisticsplus.forum.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ForumException extends RuntimeException {

    public ForumException(String s) {
        super(s);
    }

}
