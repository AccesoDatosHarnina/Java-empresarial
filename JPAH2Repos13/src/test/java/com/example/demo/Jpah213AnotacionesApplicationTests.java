package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaRepository;

@SpringBootTest
class Jpah213AnotacionesApplicationTests {
	@Autowired
	PersonaRepository personaRepository;
	
	@Test
	void contextLoads() {
		List<Persona> find = personaRepository.findByNombre("Rodrigo");
		find.forEach((resultado)->{System.out.println(resultado);});
	}

}
