package com.zinkworks.petstore.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data // Anotación de Lombok para generar automáticamente los métodos getter, setter, equals, hashCode y toString
@Configuration // Anotación de Spring para indicar que esta clase es una configuración
@ConfigurationProperties(prefix = "application-properties") // Anotación de Spring para enlazar las propiedades de configuración con esta clase, usando el prefijo especificado
public class ApplicationProperties {
    private String projectId;
    private String firebaseHost;
}
