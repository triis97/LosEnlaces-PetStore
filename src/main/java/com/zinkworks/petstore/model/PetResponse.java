package com.zinkworks.petstore.model;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data // Anotación de Lombok para generar automáticamente los métodos getter, setter, equals, hashCode y toString
@EqualsAndHashCode(callSuper = true) // Anotación de Lombok para generar los métodos equals y hashCode, llamando a los métodos de la superclase
@SuperBuilder // Anotación de Lombok para generar un patrón de diseño Builder que permite herencia
@NoArgsConstructor // Anotación de Lombok para generar un constructor sin argumentos
@AllArgsConstructor // Anotación de Lombok para generar un constructor con todos los argumentos
public class PetResponse extends Pet { // Heredamos la clase Pet extender y anadir el parametro documentId que neceseitamos comunicar al usuario tras crear la mascote pero no queremos que sea capaz de pararlo
    @DocumentId // Anotación para indicar que este campo es el ID del documento en Firestore
    private String documentId;
}
