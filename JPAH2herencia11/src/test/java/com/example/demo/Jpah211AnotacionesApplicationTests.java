package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.ConcreteEntity;
import com.example.demo.modelo.ConcreteEntityRepository;
import com.example.demo.modelo.OtherConcreteEntity;
import com.example.demo.modelo.OtherConcreteEntityRepository;

@SpringBootTest
class Jpah211AnotacionesApplicationTests {
	@Autowired
	ConcreteEntityRepository concreteEntityRepository;
	@Autowired
	OtherConcreteEntityRepository otherConcreteEntityRepository;
	
	@Test
	void contextLoads() {
		ConcreteEntity concreteEntity=new ConcreteEntity("joe", "primero", "joze lui");
		concreteEntityRepository.save(concreteEntity);
		OtherConcreteEntity otherConcreteEntity=new OtherConcreteEntity("stan", "segundo", "singleton");
		otherConcreteEntityRepository.save(otherConcreteEntity);
		Iterable<ConcreteEntity> findAll = concreteEntityRepository.findAll();
		findAll.forEach((a)->{System.out.println(a.toString());});
	}

}
