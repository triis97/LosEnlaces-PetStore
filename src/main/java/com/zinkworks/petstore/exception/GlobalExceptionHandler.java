package com.zinkworks.petstore.exception;

import com.zinkworks.petstore.model.ProblemDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ProblemDetails handleException(final Exception ex){
        return new ProblemDetails(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({PetNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ProblemDetails handleNotFoundException(final Exception ex){
        return new ProblemDetails(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ProblemDetails handleValidationException(final Exception ex){
        return new ProblemDetails("Invalid request content", HttpStatus.BAD_REQUEST);
    }

}
