package com.example.ApiController01;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personal")
public class PersonaController {

//	private PersonaService personaService;

	@Autowired
	private PersonaService personaService;
//	public PersonaController(PersonaService personaService) {
//		super();
//		this.personaService = personaService;
//	}

	@GetMapping("home")
//	forma mas antigua de poner getmapping
//	@RequestMapping(path = "home")
	public String dame() {
		return "hola mundo";
	}

	@GetMapping("lista")
	public List<String> cosas() {
		return List.of("uno", "dos", "tres");
	}

	@GetMapping("personas")
	public List<Persona> personas() {
		return this.personaService.getPersonas();
	}
	
	@GetMapping("peticion/{inicial}")
	public List<Persona> busca(@PathVariable("inicial") String inicial){
		return personaService.getPersonas().stream().filter(
				(Persona per)->per.getNombre().startsWith(inicial))
				.collect(Collectors.toList());
	}
}
