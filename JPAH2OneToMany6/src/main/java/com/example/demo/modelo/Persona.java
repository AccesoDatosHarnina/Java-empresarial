package com.example.demo.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_persona", unique = true, length = 20)
	private String nombre;
	private String apellidos;

	@Embedded
	private Seguro seguro;

	// satisfacemos la asociacion OneToMany
	@OneToMany(cascade = CascadeType.ALL)
	private List<Pedido> pedidos;

	public Persona(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Persona() {
		super();
	}

	@OneToOne
	@JoinColumn(name = "ID_DIR")
	private Direccion direccion;

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", seguro=" + seguro.toString()
				+ ", direccion=" + direccion.toString() + "]";
	}

}
