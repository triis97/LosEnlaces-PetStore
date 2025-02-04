package com.zinkworks.petstore.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.zinkworks.petstore.properties.ApplicationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.util.UUID;

@Configuration //Anotacion para que SpringBoot reconozca esta clase como una clase especial de configuracion
public class ApplicationConfig {


    @Bean //Anotacion para indicar que este metodo se debe usar para inyeccion de dependencias
    @Profile("default") // Anotacion para asociar este metodo con el perfil default
    //Metodo utilizado por SpringBoot para instanciar el Objecto de typo Firestore
    public Firestore firestore(final ApplicationProperties applicationProperties) throws IOException {
        final FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
                .setProjectId(applicationProperties.getProjectId())
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseId(applicationProperties.getDatabaseId())
                .build();
        return firestoreOptions.getService();
    }

    @Bean // Anotacion para indicar que este metodo se debe usar para inyeccion de dependencias
    @Profile("local") // Anotacion para asociar este metodo con el perfil local
    // Metodo utilizado por SpringBoot para instanciar el Objecto de typo Firestore en un entorno local
    public Firestore firestoreLocal(final ApplicationProperties applicationProperties) {
        FirestoreOptions options = FirestoreOptions
                .getDefaultInstance()
                .toBuilder()
                .setProjectId(UUID.randomUUID().toString())
                .setCredentials(NoCredentials.getInstance())
                .setHost(applicationProperties.getFirebaseHost())
                .build();
        return options.getService();
    }
}
