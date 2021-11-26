package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Direccion;
import com.example.demo.modelo.DireccionRepository;
import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaRepository;
import com.example.demo.modelo.Seguro;

@SpringBootTest
class Jpah200AnotacionesApplicationTests {
	
	//usando la inyeccion de dependencias este objeto lo crea Spring
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	DireccionRepository direccionRepository;

	@Test
	void contextLoads() {
		Direccion direccion = new Direccion("Rosa",21);
		direccionRepository.save(direccion);
		Persona persona = new Persona("Julio", "Capacino");
		persona.setDireccion(direccion);
		Seguro seguro=new Seguro(1L,"uno que yo se");
		persona.setSeguro(seguro);
		personaRepository.save(persona);
		Iterable<Persona> findAll = personaRepository.findAll();
		findAll.forEach((a)->{System.err.println(a.toString());});
		System.out.println("ya acabo");
	}

}
