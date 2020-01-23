package com.Apple.Assignment.Dao;

import java.util.List;

import com.Apple.Assignment.model.Student;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public interface StudentDao {

	public List<Student> findAllStudent();

	public Student searchStudentById(String id);

	public Student addNewStudent(Student Student);

	public DeleteResult DeleteStudent(String id);

	public List<Student> searchStudentByAge(int age);

	public List<Student> searchStudentByGrade(String grade);

	public List<Student> searchStudentByAgeAndGrade(int age, String grade);

	public UpdateResult updateStudent(Student student);

}
