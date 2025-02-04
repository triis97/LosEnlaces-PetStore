package com.zinkworks.petstore.service;

import com.zinkworks.petstore.model.Pet;
import com.zinkworks.petstore.model.PetResponse;

import java.util.List;
import java.util.concurrent.ExecutionException;

// Interfaz que define el contrato para las operaciones de PetService.
public interface IPetService {
    PetResponse savePet(final Pet pet) throws ExecutionException, InterruptedException;
}
