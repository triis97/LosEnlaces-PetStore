package com.zinkworks.petstore.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.zinkworks.petstore.model.Pet;
import com.zinkworks.petstore.model.PetResponse;
import com.zinkworks.petstore.properties.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service // Anotación de Spring para indicar que esta clase es un servicio
@RequiredArgsConstructor // Anotación de Lombok para generar un constructor con los argumentos necesarios para los campos finales
public class PetService implements IPetService {
    private final Firestore firestore;
    private final ApplicationProperties applicationProperties;
    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public PetResponse savePet(final Pet pet) throws ExecutionException, InterruptedException {
        final DocumentReference docRef = firestore.collection(applicationProperties.getCollectionName()).document();
        docRef.set(pet).get();
        return docRef.get().get().toObject(PetResponse.class);
    }
}
