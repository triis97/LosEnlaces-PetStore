package com.zinkworks.petstore;

import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.*;
import com.zinkworks.petstore.model.Pet;
import com.zinkworks.petstore.model.PetResponse;
import com.zinkworks.petstore.model.ProblemDetails;
import com.zinkworks.petstore.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Anotación de Spring Boot para indicar que se debe iniciar un servidor web en un puerto aleatorio para las pruebas
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // Anotación para indicar que el contexto de la aplicación debe ser ensuciado después de cada método de prueba
class PetstoreApplicationTests {
}
