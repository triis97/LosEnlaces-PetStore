package com.zinkworks.petstore.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.zinkworks.petstore.exception.PetNotFoundException;
import com.zinkworks.petstore.model.Pet;
import com.zinkworks.petstore.model.PetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class PetService implements IPetService {
    //TODO: make this name configurable
    private static final String COLLECTION_NAME = "pet-collection";
    private final Firestore firestore;
    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public PetResponse savePet(final Pet pet) throws ExecutionException, InterruptedException {
        final DocumentReference docRef = firestore.collection(COLLECTION_NAME).document();
        docRef.set(pet).get();
        return docRef.get().get().toObject(PetResponse.class);
    }

    @Override
    public PetResponse getPetById(final String documentId) throws ExecutionException, InterruptedException {
        return Optional.ofNullable(firestore.collection(COLLECTION_NAME).document(documentId).get().get().toObject(PetResponse.class)).orElseThrow(()->new PetNotFoundException(documentId));
    }

    @Override
    public List<PetResponse> getAllPets() throws ExecutionException, InterruptedException {
        return firestore.collection(COLLECTION_NAME)
                .get()
                .get()
                .toObjects(PetResponse.class);
    }

    @Override
    public PetResponse updatePetById(String documentId, Pet pet) throws ExecutionException, InterruptedException {
        final DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(documentId);
        if (!docRef.get().get().exists()) {
            throw new PetNotFoundException(documentId);
        }
        docRef.set(pet).get();
        return docRef.get().get().toObject(PetResponse.class);
    }

    @Override
    public PetResponse deletePetById(String documentId) throws ExecutionException, InterruptedException {
        final DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(documentId);
        final PetResponse petResponse = Optional.ofNullable(docRef.get().get().toObject(PetResponse.class)).orElseThrow(()->new PetNotFoundException(documentId));
        docRef.delete().get();
        return petResponse;
    }
}
