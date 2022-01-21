package com.example.ApiController01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Complementador {

	@Autowired
	SumadorService sumadorService;
	
	public int duplicador(int uno,int dos) {
		return sumadorService.suma(uno, dos)*2;
	}
}
