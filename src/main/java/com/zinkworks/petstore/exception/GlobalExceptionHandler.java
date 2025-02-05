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
}