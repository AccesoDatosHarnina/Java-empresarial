package com.example.demo.modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String calle;
	
	private int numero=0;

	public Direccion() {
		super();
	}
	
//	@OneToOne(mappedBy="direccion")
//	private Persona persona;
	
	public Direccion(String calle, int numero) {
		super();
		this.calle = calle;
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, id, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(id, other.id) && numero == other.numero;
	}

	

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + "]";
	}
//	@Override
//	public String toString() {
//		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + ", persona=" + persona.toString() + "]";
//	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
