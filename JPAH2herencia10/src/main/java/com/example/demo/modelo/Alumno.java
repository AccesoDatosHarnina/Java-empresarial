package com.example.demo.modelo;

import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="alumno")
public class Alumno extends Persona {
	private String curso;

	public Alumno() {
		super();
	}

	public Alumno(String nombre, String apellidos, String curso) {
		super(nombre, apellidos);
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(curso);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(curso, other.curso);
	}

	@Override
	public String toString() {
		return "Alumno [curso=" + curso + "]";
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	

}
