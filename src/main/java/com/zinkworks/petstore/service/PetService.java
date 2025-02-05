package com.zinkworks.petstore.service;


import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.zinkworks.petstore.model.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service // Anotación de Spring para indicar que esta clase es un servicio
@RequiredArgsConstructor // Anotación de Lombok para generar un constructor con los argumentos necesarios para los campos finales
public class PetService implements IPetService {

    private final Firestore firestore;

    @Override
    public Pet savePet(Pet pet) throws ExecutionException, InterruptedException {
        final DocumentReference docRef = firestore.collection("test-collection").document();
        docRef.set(pet).get();
        return docRef.get().get().toObject(Pet.class);
    }

    @Override
    public List<Pet> getAllPets() throws ExecutionException, InterruptedException {
        return firestore.collection("test-collection").get().get().toObjects(Pet.class);
    }
}
