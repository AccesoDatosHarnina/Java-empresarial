package com.example.demo;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Partido;
import com.example.demo.modelo.PartidoRepository;
import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaRepository;
import com.jayway.jsonpath.ParseContext;

@SpringBootTest
class Jpah208AnotacionesApplicationTests {
	
	//usando la inyeccion de dependencias este objeto lo crea Spring
	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	PartidoRepository partidoRepository;
	
	@Test
	void contextLoads() {
		Persona persona = new Persona("Julio", "Capacino");
		Persona persona1 = new Persona("Alberto", "Capacino");
		Persona persona2 = new Persona("susana", "Capacino");
		Persona persona3 = new Persona("Emilio", "Capacino");
		Partido partido=new Partido("tudelano","arroyoclarete");
		//creando una lista inmutable
		List personas=new LinkedList<Persona>();
		personas.add(persona);
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
		partido.setPersonas(personas);
		personaRepository.save(persona);
		personaRepository.save(persona1);
		personaRepository.save(persona2);
		personaRepository.save(persona3);
		partidoRepository.save(partido);
		System.out.println("mostrando los persona");
		partidoRepository.findAll().forEach((par)->{
			par.getPersonas().forEach((per)->{
				System.err.println("persona "+per.toString());
			});
		});
		persona.getPartidos().add(partido);
		System.out.println("mostrando los partidos de persona");
		personaRepository.findAll().forEach((pers)->{
			pers.getPartidos().forEach((pars)->{
				System.err.println("partido "+pars.toString());
			});
		});
		Partido partido2=new Partido("Comelanense","rayo globero");
		List personas1=new LinkedList<Persona>();
		personas1.add(persona);
		personas1.add(persona1);
		personas1.add(persona2);
		personas1.add(persona3);
		partido2.setPersonas(personas1);
		partidoRepository.save(partido2);
	}

	
}
