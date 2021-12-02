package com.example.demo.modelo;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate localDate;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;
	
	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(LocalDate localDate, double aoumnt, Persona persona) {
		super();
		this.localDate = localDate;
		this.amount = aoumnt;
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, localDate, persona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && Objects.equals(id, other.id)
				&& Objects.equals(localDate, other.localDate) && Objects.equals(persona, other.persona);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", localDate=" + localDate + ", amount=" + amount  + "]";
	}



}
