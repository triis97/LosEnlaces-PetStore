package com.zinkworks.petstore;

import com.zinkworks.petstore.model.PetResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PetstoreApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getAllPetsTest() {
		final ResponseEntity<List<PetResponse>> response = restTemplate.exchange("/pet-shop/pets", HttpMethod.GET, null, new ParameterizedTypeReference<List<PetResponse>>() {});
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}


}
