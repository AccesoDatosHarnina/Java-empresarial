package com.example.demo.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Telefono implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private boolean movil;

	public Telefono(String numero, boolean movil) {
		super();
		this.numero = numero;
		this.movil = movil;
	}
	public String getNumero() {
		return numero;
	}
	public boolean isMovil() {
		return movil;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movil, numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		return movil == other.movil && Objects.equals(numero, other.numero);
	}
	@Override
	public String toString() {
		return "Telefono [numero=" + numero + ", movil=" + movil + "]";
	}
	
}
