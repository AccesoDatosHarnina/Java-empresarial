package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.AlumnoRepository;
import com.example.demo.modelo.Profesor;
import com.example.demo.modelo.ProfesorRepository;

@SpringBootTest
class Jpah200AnotacionesApplicationTests {
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	ProfesorRepository profesorRepository;
	
	@Test
	void contextLoads() {
		Alumno alumno=new Alumno("Luis", "Forera", "primero");
		alumnoRepository.save(alumno);
		Profesor profesor=new Profesor("Antonio","DiTomaso","jefazo");
		profesorRepository.save(profesor);
	}

}
