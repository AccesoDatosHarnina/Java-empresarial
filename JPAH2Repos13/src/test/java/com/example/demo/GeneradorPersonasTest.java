package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaRepository;

@SpringBootTest
class GeneradorPersonasTest {

	@Autowired
	PersonaRepository personaRepository;
	
	@Test
	void test() {
		List<String> nombres = List.of("Rodrigo", "Romualdo", "Alejandro", "Antonio", "Eduardo");
		List<String> apellidoUno = List.of("Gomez", "Hernandez", "Garcia", "Lalanda", "Tyson");
		List<String> apellidoDos = List.of("Carvajal", "Nunez", "Gonzalez", "Cuellar", "Diaz");
		LinkedList<Persona> personas = new LinkedList<>();
		final int edadMaxima = 70;
		nombres.forEach((nombre) -> {
			apellidoUno.forEach((apellidoElemento) -> {
				apellidoDos.forEach((apellidosDosElenento) -> {
					personas.add(new Persona(nombre, apellidoElemento +" "+ apellidosDosElenento,
							new Random().nextInt(edadMaxima)));
				});
			});
		});
		assertEquals(125, personas.size());
		personaRepository.saveAll(personas);
		System.out.println("parece que si");
	}

}
