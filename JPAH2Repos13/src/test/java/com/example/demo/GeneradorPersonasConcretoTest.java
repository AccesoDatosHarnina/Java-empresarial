package com.example.demo;

import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GeneradorPersonasConcretoTest {

	@Autowired
	PersonaRepository personaRepository;
	int numero=1000;

	
	@Test
	void test() {
		List<String> nombres = List.of("Rodrigo", "romualdo", "Alejandro", "Antonio", "Eduardo");
		List<String> apellidoUno = List.of("Gomez", "Hernandez", "Garcia", "Lalanda", "Tyson");
		List<String> apellidoDos = List.of("Carvajal", "Nunez", "Gonzalez", "Cuellar", "Diaz");
		List<Integer> edades = List.of(15, 17, 18, 19, 21);
		LinkedList<Persona> personas = new LinkedList<>();

		for (int i = 0; i < nombres.size();) {
			personas.add(new Persona(nombres.get(i),apellidoUno.get(i),edades.get(i),1000+ i++));
		}
		assertEquals(5, personas.size());
		personaRepository.saveAll(personas);
		System.out.println("parece que si");
	}

}
