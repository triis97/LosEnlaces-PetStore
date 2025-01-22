package com.zinkworks.petstore.utils;

import com.zinkworks.petstore.model.AnimalTypes;
import com.zinkworks.petstore.model.PetResponse;

import java.util.List;

public class TestUtils {

    private static final List<PetResponse> petResponses = List.of(
            PetResponse.builder().documentId("documentId_1").name("testPet_1").description("descriptionPet_1").type(AnimalTypes.BIRD).build(),
                PetResponse.builder().documentId("documentId_2").name("testPet_2").description("descriptionPet_2").type(AnimalTypes.DOG).build());

    public static List<PetResponse> getPetResponses(){
        return petResponses;
    }
    public static PetResponse getPetSingleResponses(){
        return petResponses.get(0);
    }
}
