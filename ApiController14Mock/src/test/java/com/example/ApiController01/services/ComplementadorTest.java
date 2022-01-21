package com.example.ApiController01.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.ApiController01.Complementador;
import com.example.ApiController01.SumadorService;

@SpringBootTest
class ComplementadorTest {

	@MockBean
	SumadorService sumadorService;

	@Autowired
	Complementador complementador;

	@BeforeEach
	void before() {
//		complementador = new Complementador();
	}

	@Test
	void testUsarSumador() {
		when(sumadorService.suma(1, 2)).thenReturn(3);
		assertEquals(6, complementador.duplicador(1, 2));
	}

}
