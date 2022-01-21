package com.example.ApiController01.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Console;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ApiController01.Messenger;
import com.example.ApiController01.SumadorService;

class SumadorServiceTest {
	SumadorService sumador;
	boolean showMessages=false;
	
	@BeforeEach
	void before() {
		System.err.println("before");
		sumador=new SumadorService();
	}

	@Test
	void testSuma() {
		System.out.println("suma");
		//condiciones de la prueba
		int uno[]= {0,1};
		int dos[]= {0,1};
		int expected[]= {0,2};
		//se hace la prueba
		for (int i = 0; i < expected.length; i++) {
			Messenger.show("estamos haciendo la prueba "+i, showMessages);
			int actual=sumador.suma(uno[i], dos[i]);
		//se comprueba el resultado
			assertEquals(expected[i], actual);
		}
	}
	@Test
	void testOtro() {
		System.out.println("otro");
		
	}
	@AfterEach
	void after() {
		System.err.println("after");
		//si ha habido un cambio en objetos que no se construyen aqui
		//por ejemplo ficheros
	}
	

}
