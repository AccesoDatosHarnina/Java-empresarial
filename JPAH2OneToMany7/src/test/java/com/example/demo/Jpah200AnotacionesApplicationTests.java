package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Direccion;
import com.example.demo.modelo.DireccionRepository;
import com.example.demo.modelo.Pedido;
import com.example.demo.modelo.PedidoRepository;
import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaRepository;
import com.example.demo.modelo.Seguro;

@SpringBootTest
class Jpah200AnotacionesApplicationTests {
	
	//usando la inyeccion de dependencias este objeto lo crea Spring
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	DireccionRepository direccionRepository;
	@Autowired
	PedidoRepository pedidoRepository;

	@Test
	void contextLoads() {
		Persona persona = new Persona("Julio", "Capacino");
		Pedido pedido=new Pedido(LocalDate.now(),150,persona);
		Pedido pedidoaa=new Pedido(LocalDate.now(),150,persona);
		Pedido pedidoab=new Pedido(LocalDate.now(),150,persona);
		
		personaRepository.save(persona);
		pedidoRepository.save(pedido);
		pedidoRepository.save(pedidoaa);
		pedidoRepository.save(pedidoab);
		
		System.out.println("Lista de pedidos");
		List<Pedido> findByPersona = pedidoRepository.findByPersona(persona);
		findByPersona.stream().forEach((a)->{
			System.out.println(a.toString());
		});
	}

}
