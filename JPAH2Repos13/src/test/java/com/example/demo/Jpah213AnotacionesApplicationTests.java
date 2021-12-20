package com.example.demo;

import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Jpah213AnotacionesApplicationTests {
    @Autowired
    PersonaRepository personaRepository;

    @Test
    void contextLoads() {
        List<Persona> find = personaRepository.findByNombre("Rodrigo");
        find.forEach((resultado) -> {
            System.out.println(resultado);
        });

    }

    @Test
    void contextLoadss() {
        List<Persona> find = personaRepository.findByEdadGreaterThan(18);
        final int i = 2;
        assertEquals(i, find.size());
    }

    @Test
    void edadynombreTest() {
        int age = 18;
        String startingName = "Ro";
        int expected = 1;
        List<Persona> byEdadLessThanAndNombreStartingWith = personaRepository.findByEdadLessThanAndNombreStartingWith(age, startingName);
        assertEquals(expected, byEdadLessThanAndNombreStartingWith.size());
        expected = 2;
        byEdadLessThanAndNombreStartingWith = personaRepository.findByEdadLessThanAndNombreStartingWithIgnoreCase(age, startingName);
        assertEquals(expected, byEdadLessThanAndNombreStartingWith.size());
    }
}
