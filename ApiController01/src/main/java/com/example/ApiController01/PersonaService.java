package com.example.ApiController01;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class PersonaService {
	//Esto hace de repo
	ArrayList<Persona> personas;

	public PersonaService() {
		personas = new ArrayList<>();
		personas.add(new Persona(1, "Ramos", 32));
		personas.add(new Persona(2, "Elias", 24));
		personas.add(new Persona(3, "Julian", 24));
		personas.add(new Persona(4, "Roberto", 24));
	}

	public ArrayList<Persona> getPersonas() {
		return this.personas;
	}
}
