package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombreEquipoUno, nombreEquipoDos;
	
//	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@ManyToMany(fetch=FetchType.EAGER)
	//TODO
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "mi_persona_partido", 
	joinColumns = { 
		@JoinColumn(name = "partido") }, 
	inverseJoinColumns = {
		@JoinColumn(name = "persona") }
)
	private List<Persona> personas;

	public Partido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Partido(String nombreEquipoUno, String nombreEquipoDos) {
		super();
		this.nombreEquipoUno = nombreEquipoUno;
		this.nombreEquipoDos = nombreEquipoDos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombreEquipoDos, nombreEquipoUno, personas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return id == other.id && Objects.equals(nombreEquipoDos, other.nombreEquipoDos)
				&& Objects.equals(nombreEquipoUno, other.nombreEquipoUno) && Objects.equals(personas, other.personas);
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", nombreEquipoUno=" + nombreEquipoUno + ", nombreEquipoDos=" + nombreEquipoDos
				+ ", personas=" + personas + "]";
	}

	public String getNombreEquipoUno() {
		return nombreEquipoUno;
	}

	public void setNombreEquipoUno(String nombreEquipoUno) {
		this.nombreEquipoUno = nombreEquipoUno;
	}

	public String getNombreEquipoDos() {
		return nombreEquipoDos;
	}

	public void setNombreEquipoDos(String nombreEquipoDos) {
		this.nombreEquipoDos = nombreEquipoDos;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public int getId() {
		return id;
	}
	
	
	
}
