package com.caiomacedo.illegalityleague.exceptions.handler;

import com.caiomacedo.illegalityleague.exceptions.HeroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = HeroNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage heroNotFoundException() {
        return new ErrorMessage(
                LocalDateTime.now(),
                "Hero not found");
    }

}
