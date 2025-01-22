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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PetstoreApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockitoBean private Firestore firestore;
	@MockitoBean private CollectionReference collectionReference;
	@MockitoBean private DocumentReference documentReference;
	@MockitoBean private QuerySnapshot querySnapshot;
	@MockitoBean private DocumentSnapshot documentSnapshot;
	@MockitoBean private WriteResult writeResult;

	@BeforeEach
	void setUp(){
		when(firestore.collection(any())).thenReturn(collectionReference);
		when(collectionReference.get()).thenReturn(ApiFutures.immediateFuture(querySnapshot));
		when(collectionReference.document(any())).thenReturn(documentReference);
		when(collectionReference.document()).thenReturn(documentReference);
		when(documentReference.get()).thenReturn(ApiFutures.immediateFuture(documentSnapshot));
		when(documentReference.set(any(Object.class))).thenReturn(ApiFutures.immediateFuture(writeResult));
		when(documentReference.delete()).thenReturn(ApiFutures.immediateFuture(writeResult));
		when(querySnapshot.toObjects(eq(PetResponse.class))).thenReturn(TestUtils.getPetResponses());
		when(documentSnapshot.toObject(eq(PetResponse.class))).thenReturn(TestUtils.getPetSingleResponses());
		when(documentSnapshot.exists()).thenReturn(true);
	}

	@Test
	void getAllPetsTest() {
		final ResponseEntity<List<PetResponse>> response = restTemplate.exchange("/pet-shop/pets", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).hasSize(2);
	}

	@Test
	void getPetByIdTest() {
		final ResponseEntity<PetResponse> response = restTemplate.exchange("/pet-shop/pet/10", HttpMethod.GET, null, PetResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getDocumentId()).isEqualTo("documentId_1");
	}

	@Test
	void getPetByIdNotFoundTest() {
		when(documentSnapshot.toObject(eq(PetResponse.class))).thenReturn(null);
		final ResponseEntity<ProblemDetails> response = restTemplate.exchange("/pet-shop/pet/10", HttpMethod.GET, null, ProblemDetails.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody().getMessage()).isEqualTo("Pet with id 10 was not found");
	}

	@Test
	void savePetTest() {
		final ResponseEntity<PetResponse> response = restTemplate.postForEntity("/pet-shop/pet", TestUtils.getPetSingleResponses(), PetResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody().getDocumentId()).isEqualTo("documentId_1");
	}

	@Test
	void savePetValidationTest() {
		final ResponseEntity<ProblemDetails> response = restTemplate.postForEntity("/pet-shop/pet", Pet.builder().description("description").build(), ProblemDetails.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(response.getBody().getMessage()).isEqualTo("Invalid request content");
	}

	@Test
	void deletePetTest() {
		final ResponseEntity<PetResponse> response = restTemplate.exchange("/pet-shop/pet/10", HttpMethod.DELETE, null, PetResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void updatePetTest() {
		final ResponseEntity<PetResponse> response = restTemplate.exchange("/pet-shop/pet/10", HttpMethod.PUT, new HttpEntity<>(TestUtils.getPetSingleResponses()), PetResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getDocumentId()).isEqualTo("documentId_1");
	}

	@Test
	void updatePetNotFoundTest() {
		when(documentSnapshot.exists()).thenReturn(false);
		final ResponseEntity<ProblemDetails> response = restTemplate.exchange("/pet-shop/pet/10", HttpMethod.PUT, new HttpEntity<>(TestUtils.getPetSingleResponses()), ProblemDetails.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody().getMessage()).isEqualTo("Pet with id 10 was not found");
	}

}
