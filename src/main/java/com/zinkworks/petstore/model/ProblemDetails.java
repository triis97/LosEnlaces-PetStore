package com.zinkworks.petstore.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ProblemDetails {
    @NotNull private final String message;
    @NotNull private final int code;
    @NotNull private final String status;

    public ProblemDetails(final Exception e, final HttpStatus httpStatusCode){
        this.message = e.getLocalizedMessage();
        this.code =  httpStatusCode.value();
        this.status = httpStatusCode.getReasonPhrase();
    }
}
