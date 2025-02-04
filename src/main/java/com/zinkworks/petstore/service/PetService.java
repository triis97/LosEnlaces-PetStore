package com.zinkworks.petstore.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // Anotación de Spring para indicar que esta clase es un servicio
@RequiredArgsConstructor // Anotación de Lombok para generar un constructor con los argumentos necesarios para los campos finales
public class PetService implements IPetService {
}
