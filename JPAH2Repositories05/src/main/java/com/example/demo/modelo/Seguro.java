package com.example.demo.modelo;

import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Seguro {

	
	private Long id_Seguro;
	private String descripcion;


	public Seguro() {
		super();
	}

	
	
	public Seguro(Long id_Seguro, String descripcion) {
		super();
		this.id_Seguro = id_Seguro;
		this.descripcion = descripcion;
	}



	@Override
	public String toString() {
		return "Seguro [id_Seguro=" + id_Seguro + ", descripcion=" + descripcion + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id_Seguro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seguro other = (Seguro) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id_Seguro, other.id_Seguro);
	}

	public Long getId() {
		return id_Seguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
