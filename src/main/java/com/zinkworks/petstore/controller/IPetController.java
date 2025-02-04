package com.zinkworks.petstore.controller;

import com.zinkworks.petstore.model.Pet;
import com.zinkworks.petstore.model.PetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RequestMapping("pet-shop") // Anotación para mapear solicitudes HTTP a métodos de controlador
public interface IPetController {
    @PostMapping(value = "/pet") // Anotación para mapear solicitudes HTTP POST
    // @RequestBody: Anotación para indicar que el parámetro debe ser tomado del cuerpo de la solicitud HTTP
    // @Valid: Anotación para validar el objeto recibido en el cuerpo de la solicitud
    ResponseEntity<PetResponse> savePet(@Valid @RequestBody final Pet pet) throws ExecutionException, InterruptedException;
}
