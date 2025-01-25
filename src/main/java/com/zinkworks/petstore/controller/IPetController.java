package com.zinkworks.petstore.controller;

import com.zinkworks.petstore.model.Pet;
import com.zinkworks.petstore.model.PetResponse;
import com.zinkworks.petstore.model.ProblemDetails;
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

@RequestMapping("pet-shop")
public interface IPetController {

    @Operation(
            summary = "Introduce a new pet into the system",
            description = "This method will receive a pet in the request and insert it into firestore"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Pet successfully saved",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PetResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProblemDetails.class)
                            ))
            }
    )
    @PostMapping(value = "/pet")
    ResponseEntity<PetResponse> savePet(@Valid @RequestBody final Pet pet) throws ExecutionException, InterruptedException;

    @Operation(
            summary = "Retrieve a pet by its ID",
            description = "This method will retrieve a pet from the system using its ID"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Pet successfully retrieved",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PetResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Pet not found",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProblemDetails.class)
                            )),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProblemDetails.class)
                            ))
            }
    )
    @GetMapping(value = "/pet/{id}")
    ResponseEntity<PetResponse> getPetById(@PathVariable("id") final String id) throws ExecutionException, InterruptedException;

    @Operation(
            summary = "Retrieve all pets",
            description = "This method will retrieve all pets from the system"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Pets successfully retrieved",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PetResponse[].class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProblemDetails.class)
                            ))
            }
    )
    @GetMapping(value = "/pets")
    ResponseEntity<List<PetResponse>> getAllPets() throws ExecutionException, InterruptedException;

    @Operation(
            summary = "Update a pet by its ID",
            description = "This method will update a pet in the system using its ID"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Pet successfully updated",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PetResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Pet not found",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProblemDetails.class)
                            )),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProblemDetails.class)
                            ))
            }
    )
    @PutMapping(value = "/pet/{id}")
    ResponseEntity<PetResponse> updatePetById(@PathVariable("id") final String id, @Valid @RequestBody Pet pet) throws ExecutionException, InterruptedException;

    @Operation(
            summary = "Delete a pet by its ID",
            description = "This method will delete a pet from the system using its ID"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Pet successfully deleted",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PetResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Pet not found",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProblemDetails.class)
                            )),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProblemDetails.class)
                            ))
            }
    )
    @DeleteMapping(value = "/pet/{id}")
    ResponseEntity<PetResponse> deletePetById(@PathVariable("id") final String id) throws ExecutionException, InterruptedException;
}
