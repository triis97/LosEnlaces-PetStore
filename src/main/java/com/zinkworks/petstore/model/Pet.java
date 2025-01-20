package com.zinkworks.petstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String name;
    private String description;
    private AnimalTypes type;
}
