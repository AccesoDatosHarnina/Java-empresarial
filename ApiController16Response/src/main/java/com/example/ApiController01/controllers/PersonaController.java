package com.example.ApiController01.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiController01.RequestUpdatePersona;
import com.example.ApiController01.model.Persona;
import com.example.ApiController01.model.Response;
import com.example.ApiController01.services.PersonaService;

@RestController
@RequestMapping("personal")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	@GetMapping("personas")
	public ResponseEntity<Response> personas() {	
		return ResponseEntity.ok(
				Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("personas recuperados")
				.Status(HttpStatus.OK)
				.Data(Map.of("personas",personaService.getPersonas()))
				.build()
				);
	}
	
	@GetMapping("peticion/{inicial}")
	public List<Persona> busca(@PathVariable("inicial") String inicial){
		return personaService.getPersonas().stream().filter(
				(Persona per)->per.getNombre().startsWith(inicial))
				.collect(Collectors.toList());
	}
	
	@GetMapping("personasIN")
	public List<Persona> buscaIN(@RequestParam String inicial){
		return personaService.getPersonas().stream().filter(
				(Persona per)->per.getNombre().startsWith(inicial))
				.collect(Collectors.toList());
	}
	
	//Una operacion de POST se entiende que es para llevar nueva informacion al servidor
	@PostMapping("PersonaNew")
	public boolean addNewPerson(@RequestBody Persona persona) {
		return personaService.addPersona(persona);
	}
	//Una operacion PUT y que se suele utilizar para actualizar datos existentes
	@PutMapping("actualizar")
	public boolean updatePerson(@RequestParam int id,@RequestBody RequestUpdatePersona persona) {
		return personaService.update(id,persona);
	}
	//Operacion de borrado DELETE
	@DeleteMapping("delete")
	public boolean deletePerson(@RequestParam int id) {
		return personaService.delete(id);
	}
	
}
