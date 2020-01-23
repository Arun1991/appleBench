package com.Apple.Assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Apple.Assignment.model.Student;
import com.Apple.Assignment.service.StudentService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@RestController
@Repository
@RequestMapping(value = "/Student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping({"/abc","/def"})
	public String testMethod(){
		return "rest is hucch";
	}
	@RequestMapping(value = {"/createStudent","/insertStudent"}, method = RequestMethod.POST, produces = "application/json")
	public Student addNewStudent(@RequestBody Student student) {
		Student newStudent = studentService.createStudent(student);
		return newStudent;
	}


	@RequestMapping(value = "/updateStudent", method = RequestMethod.PUT, produces = "application/json")
	public boolean updateStudent(@RequestBody Student student) {
		boolean updatedStudent = studentService.updateStudent(student);
		return updatedStudent;
	}

	@RequestMapping(value = "/getByAge/{age}", method = RequestMethod.GET, produces = "application/json")
	public List<Student> searchStudentByAge(@PathVariable("age") int age) {
		List<Student> students = studentService.searchStudentByAge(age);
		return students;
	}

	@RequestMapping(value = "/getByGrade/{grade}", method = RequestMethod.GET, produces = "application/json")
	public List<Student> searchStudentByGrade(@PathVariable("grade") String grade) {
		List<Student> students = studentService.searchStudentByGrade(grade);
		return students;
	}

	@RequestMapping(value = "/getByGradeAndAge/{grade}/{age}", method = RequestMethod.GET, produces = "application/json")
	public List<Student> searchStudentByAgeAndGrade(@PathVariable int age, @PathVariable String grade) {
		List<Student> students = studentService.searchStudentByAgeAndGrade(age, grade);
		return students;
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = "application/json")
	public Student getStudentById(@PathVariable("id") String id) {
		Student student = studentService.searchStudentById(id);
		return student;
	}

	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public DeleteResult DeleteStudent(@PathVariable("id") String id) {
		DeleteResult student = studentService.deleteStudentById(id);
		return student;
	}

	@RequestMapping(value = "/findAllStudent", method = RequestMethod.GET)
	public List<Student> findAllStudent() {
		List<Student> student = studentService.findAllStud();
		return student;
	}

}
