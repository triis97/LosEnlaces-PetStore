package com.zinkworks.petstore.service;

import com.zinkworks.petstore.model.Pet;

import java.util.List;
import java.util.concurrent.ExecutionException;

// Interfaz que define el contrato para las operaciones de PetService.
public interface IPetService {
    Pet savePet(final Pet pet) throws ExecutionException, InterruptedException;
    List<Pet> getAllPets() throws ExecutionException, InterruptedException;
}
