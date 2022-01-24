package com.example.cors04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentControler {
    private static final List<Student> STUDENTS= Arrays.asList(
            new Student(1,"Felipe"),
            new Student(2,"Arturo"),
            new Student(3,"julian"),
            new Student(4,"antonio")
    );
    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentID){
        return STUDENTS.stream()
                .filter(stu->
                        studentID.equals(stu.getId()))
                .findFirst()
                .orElseThrow(()->
                         new IllegalStateException("El estudiante no existe"));
    }
    @GetMapping("list")
    public List<Student> getList(){
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return STUDENTS;
    }
}
