package com.Apple.Assignment.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Apple.Assignment.model.Student;
import com.Apple.Assignment.repository.StudentDaoImpl;
import com.Apple.Assignment.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
	
	@InjectMocks
	StudentService studentService;
	
	@Mock
	StudentDaoImpl impl;
	
	@Test
	public void findAllStudents_test(){
		when(impl.findAllStudent())
		.thenReturn(Arrays.asList(new Student("Arun","A",25,"M")));
		
		List<Student> findAllStud = studentService.findAllStud();
		
		assertEquals(1, findAllStud.size());
	}
	
	@Test
	public void createStudent_test(){
		Student student = new Student("Arun","A",25,"M");
		when(impl.addNewStudent(student))
				.thenReturn(student);
		
		Student createStudent = studentService.createStudent(student);
		
		assertEquals(student, createStudent);
		
	}
	
	@Test
	public void searchStudentByAge_test(){
		Student student = new Student("Arun","A",25,"M");
		when(impl.searchStudentByAge(25))
		.thenReturn(Arrays.asList(student));
	
		List<Student> list = studentService.searchStudentByAge(25);
		assertEquals(1, list.size());
		
	}
}







