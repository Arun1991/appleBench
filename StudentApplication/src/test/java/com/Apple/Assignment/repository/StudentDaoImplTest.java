package com.Apple.Assignment.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Apple.Assignment.model.Student;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class StudentDaoImplTest {
	
	@Autowired
	StudentDaoImpl studentDao;

	@Test
	public void addNewStudent_test() {
		Student addNewStudent = studentDao.addNewStudent(new Student("Ajay", "B+", 22, "M"));
		assertEquals(addNewStudent.getAge(), 22);
	}

	@Test
	public void searchByAge_test(){
		Student addNewStudent = studentDao.addNewStudent(new Student("Ajay", "B+", 22, "M"));	
		List<Student> searchStudentByAge = studentDao.searchStudentByAge(22);
		assertEquals(true, searchStudentByAge.size()>1);
	}
	@Test
	public void updateStudent_test(){
		Student addNewStudent = studentDao.addNewStudent(new Student("Ajay", "B+", 22, "M"));
		addNewStudent.setAge(50);
		UpdateResult updateStudent = studentDao.updateStudent(addNewStudent);
		assertEquals(updateStudent.getModifiedCount(), 1);
	}
	@Test
	public void deleteStudent_test(){
		Student addNewStudent = studentDao.addNewStudent(new Student("Ajay", "B+", 22, "M"));
		DeleteResult deleteStudent = studentDao.DeleteStudent(addNewStudent.getId());
		assertEquals(deleteStudent.getDeletedCount(), 1);
		
	}
	
	
}
