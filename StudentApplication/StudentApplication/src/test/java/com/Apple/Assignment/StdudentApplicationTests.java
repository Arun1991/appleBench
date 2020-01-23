package com.Apple.Assignment;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Apple.Assignment.Exceptions.ErrorMessages;
import com.Apple.Assignment.controller.StudentController;
import com.Apple.Assignment.model.Student;




@RunWith(SpringRunner.class)
@SpringBootTest
public class StdudentApplicationTests {
	@Autowired
	StudentController controller;
	
	Student newStudent = new Student();
	Student existingStudent = new Student();
	Student updatedStudent = new Student();
	Student nonExistingStudent = new Student();
	
	String id,name,newId,gender,grade;
	int age ;
	
	Logger logger = Logger.getLogger("Test Log");
	
	@Before
	public void before() {
		newStudent.setName("Rajendra");
		newStudent.setAge(20);
		newStudent.setGrade("A");
		newStudent.setId("001");

		existingStudent.setName("Rajendra");
		existingStudent.setAge(20);
		existingStudent.setGrade("A");
		existingStudent.setId("001");

		updatedStudent.setName("Rohan");
		updatedStudent.setAge(18);
		updatedStudent.setGrade("B");
		updatedStudent.setId("001");

		nonExistingStudent.setName("Rahul");
		nonExistingStudent.setAge(19);
		nonExistingStudent.setGrade("B");
		nonExistingStudent.setId("002");

		age = 21;
		id = "001";
		newId = "002";
		grade = "B";
		
		age=20;
		//id="002";
		
		
	}
	@Test
	public void createNewStudent() {
		try {
			Student stdObj = controller.addNewStudent(newStudent);
			assertEquals(newStudent.getName(), stdObj.getName());
			assertEquals(newStudent.getAge(), stdObj.getAge());
			assertEquals(newStudent.getGrade(), stdObj.getGrade());
			assertEquals(newStudent.getId(), stdObj.getId());
		} catch (RuntimeException runtimeException) {
			assertEquals(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage(), runtimeException.getMessage());
		}

	}

	@Test
	public void createExistingStudent() {
		try {
			controller.addNewStudent(existingStudent);

		} catch (RuntimeException runtimeException) {
			assertEquals(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage(), runtimeException.getMessage());
		}

	}

/*	@Test
	public void updateExistingStudent() {
		try {
			UpdateResult stdObj = controller.updateStudent(updatedStudent);
			if (stdObj != null) {
				assertEquals(updatedStudent.getName(), ((Student) stdObj).getName());
				assertEquals(updatedStudent.getAge(), stdObj.getAge());
				assertEquals(updatedStudent.getGrade(), stdObj.getGrade());
				assertEquals(updatedStudent.getId(), stdObj.getId());
			} else {
				assertEquals(null, stdObj);
			}
		} catch (RuntimeException runtimeException) {
			assertEquals(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), runtimeException.getMessage());
		}
	}*/

	@Test
	public void updateNonExistingStudent() {
		try {
			controller.updateStudent(nonExistingStudent);
		} catch (RuntimeException runtimeException) {
			assertEquals(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), runtimeException.getMessage());
		}
	}

	@Test
	public void searchStudentByAge() {
		try {
			List<Student> std = controller.searchStudentByAge(age);
			std.forEach(emp -> assertEquals(age, emp.getAge()));
		} catch (RuntimeException runtimeException) {
			assertEquals(ErrorMessages.NOT_FOUND_WITH_GIVEN_AGE.getErrorMessage(), runtimeException.getMessage());
		}
	}

	@Test
	public void searchStudentByGrade() {
		try {
			List<Student> std = controller.searchStudentByGrade(grade);
			std.forEach(emp -> assertEquals(grade, emp.getGrade()));
		} catch (RuntimeException runtimeException) {
			assertEquals(ErrorMessages.NOT_FOUND_WITH_GIVEN_GRADE.getErrorMessage(), runtimeException.getMessage());
		}
	}

	@Test
	public void searchStudentByAgeAndGrade() {
		try {
			List<Student> std = controller.searchStudentByAgeAndGrade(age, grade);
			std.forEach(emp -> {
				assertEquals(age, emp.getAge());
				assertEquals(grade, emp.getGrade());
			});
		} catch (RuntimeException runtimeException) {
			assertEquals(ErrorMessages.NOT_FOUND_WITH_GIVEN_AGE_AND_GRADE.getErrorMessage(),
					runtimeException.getMessage());
		}
	}

	@Test
	public void searchExistingStudentById() {
		try {
			Student std = controller.getStudentById(id);
			assertEquals(id, std.getId());
		} catch (RuntimeException runtimeException) {
			assertEquals(ErrorMessages.NOT_FOUND_WITH_GIVEN_ID.getErrorMessage(), runtimeException.getMessage());
		}
	}

	@Test
	public void searchNonExistingStudentById() {
		try {
			controller.getStudentById(newId);
		} catch (RuntimeException runtimeException) {
			assertEquals(ErrorMessages.NOT_FOUND_WITH_GIVEN_ID.getErrorMessage(), runtimeException.getMessage());
		}
	}
	
}
