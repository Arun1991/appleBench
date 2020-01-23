package com.Apple.Assignment.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Apple.Assignment.model.Student;
import com.Apple.Assignment.repository.StudentDaoImpl;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
@Component

public class StudentService {
	Logger logger = Logger.getLogger("MyLog");

	@Autowired
	StudentDaoImpl studDao;

	public Student createStudent(Student student) {
		Student resObj = studDao.addNewStudent(student);
		return resObj;

	}

	public boolean updateStudent(Student student) {
		UpdateResult resObj = studDao.updateStudent(student);
		return resObj.wasAcknowledged();
	}

	public List<Student> searchStudentByAge(int age) {
		List<Student> stdAge = studDao.searchStudentByAge(age);
		return stdAge;

	}

	public List<Student> searchStudentByGrade(String grade) {
		List<Student> stdGrade = studDao.searchStudentByGrade(grade);
		return stdGrade;
	}

	public List<Student> searchStudentByAgeAndGrade(int age, String grade) {
		List<Student> stdGradeAndAge = studDao.searchStudentByAgeAndGrade(age, grade);
		return stdGradeAndAge;

	}

	public Student searchStudentById(String id) {

		Student stdId = studDao.searchStudentById(id);
		return stdId;
	}

	public DeleteResult deleteStudentById(String id) {
		DeleteResult deleteId = studDao.DeleteStudent(id);
		return deleteId;
	}

	public List<Student> findAllStud() {
		List<Student> findStud = studDao.findAllStudent();
		return findStud;
	}

}
