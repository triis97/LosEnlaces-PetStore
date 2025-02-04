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

@RestController // Anotación para definir un controlador de servicio web RESTful.
@RequiredArgsConstructor // Anotación de Lombok para generar un constructor con los argumentos requeridos (es decir, campos finales y campos con restricciones como
public class PetController implements IPetController { // Implementamos la interfaz IPetController para heredar las anotaciones y tener un controlador más sencillo

    // Inyección de dependencias: `petService` será inyectado por el contenedor de Spring
    private final IPetService petService;

    @Override
    public ResponseEntity<PetResponse> savePet(final Pet pet) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.savePet(pet), HttpStatusCode.valueOf(201));
    }

    @Override
    public ResponseEntity<PetResponse> getPetById(final String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.getPetById(id), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<List<PetResponse>> getAllPets() throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.getAllPets(), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<PetResponse> updatePetById(final String id, final Pet pet) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.updatePetById(id, pet), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<PetResponse> deletePetById(final String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(petService.deletePetById(id), HttpStatusCode.valueOf(200));
    }
}
