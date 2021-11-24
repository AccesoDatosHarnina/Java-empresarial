package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySqlTrasacc01Application {

	public static void main(String[] args) {
		SpringApplication.run(MySqlTrasacc01Application.class, args);
//		casoUno();
		casoDos();
	}

	private static void casoDos() {
		EntityManagerFactory eaFactory = Persistence.createEntityManagerFactory("harnina");
		EntityManager eManager = eaFactory.createEntityManager();
		Persona persona1 = new Persona("Eduardo","Vaifredi");
		System.out.println("comenzando transaccion");
		eManager.getTransaction().begin();
		eManager.persist(persona1);
		eManager.getTransaction().commit();
		System.out.println("terminando transaccion");
		eManager.close();
		persona1.setApellidos("Gutierrez");
		//la persona1 esta detached
		eManager = eaFactory.createEntityManager();
		//con esto conseguimos volver a hacer que el entity manger tenga
		//al objeto controlado
		eManager.getTransaction().begin();
		Persona find=null;
		find= eManager.find(Persona.class, 1);
		eManager.getTransaction().commit();
		System.out.println("el objeto find antes de hacer merge "+find.toString());
		eManager.getTransaction().begin();
		persona1=eManager.merge(persona1);
		System.out.println("persona1 tiene el valor "+persona1.toString());
		find= eManager.find(Persona.class, 1);
		eManager.getTransaction().commit();
		System.out.println("soy el find "+find.toString());
	}
	private static void casoUno() {
		EntityManagerFactory eaFactory = Persistence.createEntityManagerFactory("harnina");
		//Este es el encargado de las transacciones
		EntityManager eManager = eaFactory.createEntityManager();
		List resultList = eManager.createQuery("FROM Persona").getResultList();
		System.out.println("personas en la base "+resultList.size());
		Persona persona1 = new Persona("Eduardo","Vaifredi");
		System.out.println("comenzando transaccion");
		eManager.getTransaction().begin();
		eManager.persist(persona1);
		eManager.getTransaction().commit();
		System.out.println("terminando transaccion");
		resultList = eManager.createQuery("FROM Persona").getResultList();
		System.out.println("personas en la base "+resultList.size());
		resultList.stream().forEach((s)->System.out.println(s.toString()));
//		eManager.close();
		//se supone que el objeto persona1 esta en estado detach
		persona1.setApellidos("Gutierrez");
		System.out.println(persona1.toString());
//		eaFactory.close();
//		eManager = eaFactory.createEntityManager();
		resultList = eManager.createQuery("FROM Persona").getResultList();
		resultList.stream().forEach((s)->System.out.println(s.toString()));
		Persona find=null;
		eManager.getTransaction().begin();
		find= eManager.find(Persona.class, 1);
		eManager.getTransaction().commit();
		System.out.println("soy el find "+find.toString());
	}

}
