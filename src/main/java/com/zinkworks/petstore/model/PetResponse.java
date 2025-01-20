package com.zinkworks.petstore.model;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PetResponse extends Pet{
    @DocumentId
    private String documentId;
}
