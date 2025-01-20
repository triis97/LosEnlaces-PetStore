package com.zinkworks.petstore.controller;

import com.zinkworks.petstore.model.Pet;
import com.zinkworks.petstore.model.PetResponse;
import com.zinkworks.petstore.service.IPetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class PetController implements IPetController {

    private final IPetService petService;

    @Override
    public ResponseEntity<PetResponse> savePet(Pet pet) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.savePet(pet), HttpStatusCode.valueOf(201));
    }

    @Override
    public ResponseEntity<PetResponse> getPetById(String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.getPetById(id), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<List<PetResponse>> getAllPets() throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.getAllPets(), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<PetResponse> updatePetById(String id, Pet pet) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.updatePetById(id, pet), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<PetResponse> deletePetById(String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.deletePetById(id), HttpStatusCode.valueOf(200));
    }
}
