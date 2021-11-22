package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaRepository;

@SpringBootTest
class Jpah200AnotacionesApplicationTests {
	
	//usando la inyeccion de dependencias este objeto lo crea Spring
	@Autowired
	PersonaRepository personaRepository;

	@Test
	void contextLoads() {
		//los repositorios son transaccionales
		personaRepository.save(new Persona("Julio", "Capacino"));
		personaRepository.findAll();
		System.out.println("ya acabo");
	}

}
