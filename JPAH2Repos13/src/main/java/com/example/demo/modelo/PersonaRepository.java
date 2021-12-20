package com.example.demo.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

	public List<Persona> findByNombre(String nombre);
//	no tiene sentido un retorno de Optional para List porque una lista vacia no es nula
//	public Optional<List<Persona>> findByEdadGreaterThan(int edad);
	public List<Persona> findByEdadGreaterThan(int edad);
	public List<Persona> findByEdadLessThanAndNombreStartingWith(int edad,String name);
	public List<Persona> findByEdadLessThanAndNombreStartingWithIgnoreCase(int edad,String name);
}
