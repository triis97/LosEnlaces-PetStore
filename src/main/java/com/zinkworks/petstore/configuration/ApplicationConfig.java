package com.zinkworks.petstore.configuration;

import com.google.cloud.NoCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.zinkworks.petstore.properties.ApplicationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Anotacion para que SpringBoot reconozca esta clase como una clase especial de configuracion
public class ApplicationConfig {

    @Bean
    public Firestore firestoreLocal(final ApplicationProperties applicationProperties){
        FirestoreOptions options = FirestoreOptions
                .getDefaultInstance()
                .toBuilder()
                .setProjectId(applicationProperties.getProjectId())
                .setCredentials(NoCredentials.getInstance())
                .setHost(applicationProperties.getFirebaseHost())
                .build();
        return options.getService();
    }
}