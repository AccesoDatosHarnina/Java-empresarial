package modelo.abstractDAO;

import modelo.entity.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer> {
	public Persona findByName(String name);
}