package com.zinkworks.petstore.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProblemDetails {
    @NotNull private String message;
    @NotNull private int code;
    @NotNull private String status;

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
