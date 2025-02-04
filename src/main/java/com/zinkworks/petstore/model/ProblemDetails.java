package com.zinkworks.petstore.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data // Anotación de Lombok para generar automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Anotación de Lombok para generar un constructor sin argumentos
@AllArgsConstructor // Anotación de Lombok para generar un constructor con todos los argumentos
@Accessors(chain = true) // Anotación de Lombok para permitir el encadenamiento de métodos setter
public class ProblemDetails {
    @NotNull private String message; // Anotación para validar que el campo no sea nulo
    @NotNull private int code; // Anotación para validar que el campo no sea nulo
    @NotNull private String status; // Anotación para validar que el campo no sea nulo

    public ProblemDetails(final Exception e, final HttpStatus httpStatusCode){
        this.message = e.getLocalizedMessage();
        this.code =  httpStatusCode.value();
        this.status = httpStatusCode.getReasonPhrase();
    }

    public ProblemDetails(final String message, final HttpStatus httpStatusCode){
        this.message = message;
        this.code =  httpStatusCode.value();
        this.status = httpStatusCode.getReasonPhrase();
    }
}
