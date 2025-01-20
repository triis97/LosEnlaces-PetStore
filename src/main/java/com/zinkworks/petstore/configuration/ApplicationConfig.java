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

@Configuration
public class ApplicationConfig {

    @Bean
    @Profile("default")
    public Firestore firestore(final ApplicationProperties applicationProperties) throws IOException {
        final FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
                .setProjectId(applicationProperties.getProjectId())
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseId(applicationProperties.getDatabaseId())
                .build();
        return firestoreOptions.getService();
    }

    @Bean
    @Profile("local")
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
