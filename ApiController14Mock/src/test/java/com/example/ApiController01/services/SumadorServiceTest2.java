package com.example.ApiController01.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ApiController01.SumadorService;

@SpringBootTest
class SumadorServiceTest2 {

	@Autowired
	SumadorService sumadorService;
	
	@Test
	void testSuma() {
		assertEquals(3,sumadorService.suma(1, 2));
	}

}
