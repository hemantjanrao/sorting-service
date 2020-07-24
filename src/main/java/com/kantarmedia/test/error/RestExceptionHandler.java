package com.kantarmedia.test.error;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {IOException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse badRequest(Exception ex) {
        return new ErrorResponse(400, "Bad Request");
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse unKnownException(Exception ex) {
        return new ErrorResponse(404, "Not Found");
    }
}
