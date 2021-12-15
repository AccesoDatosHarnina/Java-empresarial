package com.example.demo.modelo;

import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "profesor")
public class Profesor extends Persona {
	private String cargo;

	public Profesor() {
		super();
	}

	public Profesor(String nombre, String apellidos, String cargo) {
		super(nombre, apellidos);
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cargo);
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
		Profesor other = (Profesor) obj;
		return Objects.equals(cargo, other.cargo);
	}

	public String getCargo() {
		return cargo;
	}

	@Override
	public String toString() {
		return super.toString()+" Profesor [cargo=" + cargo + "]";
	}

	

}
