package com.example.ApiController01;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PersonaService {
	// Esto hace de repo
	ArrayList<Persona> personas;
	private boolean resultado = false;

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

	public boolean addPersona(Persona persona) {
		return this.personas.add(persona);
	}

	public boolean update(int id, Persona persona) {
		findById(id).ifPresentOrElse((per) -> {
			per.update(persona);
			resultado = true;
		}, () -> {
			resultado = false;
		});
		return resultado;
	}

	private Optional<Persona> findById(int id) {
		return personas.stream().filter((per) -> per.getId() == id).findFirst();
	}
}
