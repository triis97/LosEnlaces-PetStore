package com.zinkworks.petstore.exception;

import com.zinkworks.petstore.model.ProblemDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Anotación para manejar excepciones globalmente en un servicio web RESTful de Spring
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // Anotación para manejar excepciones genéricas
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Anotación para establecer el código de estado HTTP a 500
    ProblemDetails handleException(final Exception ex){
        return new ProblemDetails(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({PetNotFoundException.class}) // Anotación para manejar PetNotFoundException
    @ResponseStatus(HttpStatus.NOT_FOUND) // Anotación para establecer el código de estado HTTP a 404
    ProblemDetails handleNotFoundException(final Exception ex){
        return new ProblemDetails(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class}) // Anotación para manejar excepciones de validación
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Anotación para establecer el código de estado HTTP a 400
    ProblemDetails handleValidationException(final Exception ex){
        return new ProblemDetails("Invalid request content", HttpStatus.BAD_REQUEST);
    }

}