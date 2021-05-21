package com.oramirez.atowencv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CVnotFound extends RuntimeException{
    public CVnotFound(String message){
        super(message);
    }
}
