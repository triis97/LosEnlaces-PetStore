package com.zinkworks.petstore.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @NotNull private String name;
    @NotNull private String description;
    @NotNull private AnimalTypes type;
}
