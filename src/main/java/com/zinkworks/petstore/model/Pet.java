package com.zinkworks.petstore.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data // Anotación de Lombok para generar automáticamente los métodos getter, setter, equals, hashCode y toString
@SuperBuilder // Anotación de Lombok para generar un patrón de diseño Builder que permite herencia
@AllArgsConstructor // Anotación de Lombok para generar un constructor con todos los argumentos
@NoArgsConstructor // Anotación de Lombok para generar un constructor sin argumentos
public class Pet {
    @NotNull private String name; // Anotación para validar que el campo no sea nulo
    @NotNull private String description; // Anotación para validar que el campo no sea nulo
    @NotNull private AnimalTypes type; // Anotación para validar que el campo no sea nulo
}
