package com.sk.superkassa.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sk.superkassa.exception.NoSuchElementException;
import com.sk.superkassa.model.dto.ExceptionMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.I_AM_A_TEAPOT;

@ControllerAdvice
public class ExceptionHelper {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(value = { NoSuchElementException.class })
    public ResponseEntity<ExceptionMessageResponse> handleNoSuchElementException(RuntimeException ex) {

        logger.error("No Such Element Exception: {}", ex.getMessage());

        return new ResponseEntity<>(new ExceptionMessageResponse("failed",ex.getMessage(),
                LocalDateTime.now()), I_AM_A_TEAPOT);
    }

    @ExceptionHandler(value = { InvalidFormatException.class })
    public ResponseEntity<ExceptionMessageResponse> handleInvalidFormatException(RuntimeException ex) {

        logger.error("Invalid Format Exception: id and add fields must be numbers");

        return new ResponseEntity<>(new ExceptionMessageResponse("failed",
                "Invalid Format Exception: id and add fields must be numbers",
                LocalDateTime.now()), I_AM_A_TEAPOT);
    }
}
