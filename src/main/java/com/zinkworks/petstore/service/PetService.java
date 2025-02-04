package com.zinkworks.petstore.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.zinkworks.petstore.exception.PetNotFoundException;
import com.zinkworks.petstore.model.Pet;
import com.zinkworks.petstore.properties.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service // Anotación de Spring para indicar que esta clase es un servicio
@RequiredArgsConstructor // Anotación de Lombok para generar un constructor con los argumentos necesarios para los campos finales
public class PetService implements IPetService {
}
