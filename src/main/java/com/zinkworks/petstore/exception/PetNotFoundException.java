package com.zinkworks.petstore.exception;

// Excepción personalizada para mascota no encontrada
public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException(final String documentId){
        super("Pet with id %s was not found".formatted(documentId));
    }
}
