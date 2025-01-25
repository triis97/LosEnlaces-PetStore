package com.zinkworks.petstore.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "application-properties")
public class ApplicationProperties {
    private String projectId;
    private String databaseId;
    private String collectionName;
    private String firebaseHost;
}
