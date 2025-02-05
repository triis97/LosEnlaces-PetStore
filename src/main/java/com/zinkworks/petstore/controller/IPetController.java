package com.zinkworks.petstore.controller;

import com.zinkworks.petstore.model.Pet;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RequestMapping("pet-shop") // Anotación para mapear solicitudes HTTP a métodos de controlador
public interface IPetController {
    @PostMapping(value = "/pet") // Anotación para mapear solicitudes HTTP POST
    // @RequestBody: Anotación para indicar que el parámetro debe ser tomado del cuerpo de la solicitud HTTP
    // @Valid: Anotación para validar el objeto recibido en el cuerpo de la solicitud
    ResponseEntity<Pet> savePet(@Valid @RequestBody final Pet pet) throws ExecutionException, InterruptedException;

    @GetMapping(value = "/pets")
    ResponseEntity<List<Pet>> getAllPets() throws ExecutionException, InterruptedException;
}
