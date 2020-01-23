package com.Apple.Assignment.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.Apple.Assignment.Dao.StudentDao;
import com.Apple.Assignment.Exceptions.ErrorMessages;
import com.Apple.Assignment.Exceptions.StudentServiceException;
import com.Apple.Assignment.model.Student;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Component
public class StudentDaoImpl implements StudentDao {

	Logger logger = Logger.getLogger("Db Log");
	@Autowired
	MongoTemplate mongoTemp;

	@Override
	public Student addNewStudent(Student student) {
		// Checking whether student already exist with the given id
		String studId = student.getId();
		if (studId != null) {
			logger.info("Student Already Present with id: " + student.getId() + " and Name :" + student.getName()
					+ ". Hence Duplicate Entry Not Allowed");
			throw new StudentServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());

		}
		// creating query document to insert the record
		else {
			mongoTemp.save(student);// Save All document to collections
			logger.info("Data has been inserted succesfully ! for id : " + student.getId() + " and Name :"
					+ student.getName());
		}
		return student;
	}

	@Override
	public DeleteResult DeleteStudent(String id) {
		Query query = new Query();
		DeleteResult delete = null;
		String StdId = null;
		String StdName = null;
		query.addCriteria(Criteria.where("id").is(id));
		List<Student> std = mongoTemp.find(query, Student.class);//search query

		for (Student student : std) {
			StdId = student.getId();
			StdName = student.getName();
		}
		if (StdId != null) {
			System.out.println("student id " + StdId);
			logger.info("Deleteing  Student ID: " + id);
			delete = mongoTemp.remove(query, Student.class);//delete query
			logger.info("Data has been Deleted succesfully ! for id : " + StdId + " and Name " + StdName);
		} else {
			logger.info("Student not Present with id: " + id);
			throw new StudentServiceException(ErrorMessages.NOT_FOUND_WITH_GIVEN_ID_DELETE.getErrorMessage());
		}
		return delete;

	}

	@Override
	public List<Student> searchStudentByAge(int age) {

		Query query = new Query();
		query.addCriteria(Criteria.where("age").is(age));
		List<Student> studSearchAge = mongoTemp.find(query, Student.class);//search query by age 
		List<Student> stdList = new ArrayList<Student>();
		int flag = 0;
		Iterator<Student> iterator = studSearchAge.iterator();
		while (iterator.hasNext()) {
			Student stdObj = new Student();
			Student student = iterator.next();
			stdObj.setAge(student.getAge());
			stdObj.setName(student.getName());
			stdObj.setGrade(student.getGrade());
			stdObj.setId(student.getId());
			stdObj.setGender(student.getGender());
			stdList.add(stdObj);
			flag = 1;
		}
		if (flag == 1) {
			logger.info("Student Successfully fetched for age : " + age);
		} else {
			logger.info("Student Not Found for the age : " + age);
			throw new StudentServiceException(ErrorMessages.NOT_FOUND_WITH_GIVEN_AGE.getErrorMessage());
		}

		return studSearchAge;
	}

	@Override
	public List<Student> searchStudentByGrade(String grade) {
		Query query = new Query();
		query.addCriteria(Criteria.where("grade").is(grade));
		List<Student> studSearchGrade = mongoTemp.find(query, Student.class);//search query by grade
		List<Student> stdList = new ArrayList<Student>();
		int flag = 0;
		Iterator<Student> iterator = studSearchGrade.iterator();
		while (iterator.hasNext()) {
			Student stdObj = new Student();
			Student student = iterator.next();
			stdObj.setAge(student.getAge());
			stdObj.setName(student.getName());
			stdObj.setGrade(student.getGrade());
			stdObj.setId(student.getId());
			stdObj.setGender(student.getGender());
			stdList.add(stdObj);
			flag = 1;
		}
		if (flag == 1) {
			logger.info("Student Successfully fetched for grade : " + grade);
		} else {
			logger.info("Student Not Found for the grade : " + grade);
			throw new StudentServiceException(ErrorMessages.NOT_FOUND_WITH_GIVEN_GRADE.getErrorMessage());
		}

		return studSearchGrade;
	}

	@Override
	public List<Student> searchStudentByAgeAndGrade(int age, String grade) {
		Query query = new Query();
		query.addCriteria(new Criteria().andOperator(Criteria.where("grade").is(grade), Criteria.where("age").is(age)));

		List<Student> studSearchGradeAndAge = mongoTemp.find(query, Student.class);//search query by age and grade
		List<Student> stdList = new ArrayList<Student>();
		int flag = 0;
		Iterator<Student> iterator = studSearchGradeAndAge.iterator();
		while (iterator.hasNext()) {
			Student stdObj = new Student();
			Student student = iterator.next();
			stdObj.setAge(student.getAge());
			stdObj.setName(student.getName());
			stdObj.setGrade(student.getGrade());
			stdObj.setId(student.getId());
			stdObj.setGender(student.getGender());
			stdList.add(stdObj);
			flag = 1;
		}
		if (flag == 1) {
			logger.info("Student Successfully fetched for age : " + age + " and grade : " + grade);
		} else {
			logger.info("Student Not Found for the age : " + age + " and grade : " + grade);
			throw new StudentServiceException(ErrorMessages.NOT_FOUND_WITH_GIVEN_AGE_AND_GRADE.getErrorMessage());
		}

		return studSearchGradeAndAge;
	}

	@Override
	public UpdateResult updateStudent(Student student) {
		UpdateResult updateResult = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(student.getId()));
		Student student1 = mongoTemp.findOne(query, Student.class);

		if (student1==null) {
			logger.info("Student not found for id : " + student.getId() + " and name : " + student.getName()
					+ " Hence update not possible for non existing data");
			throw new StudentServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		} else {
			Update update = new Update();
			update.set("age", student.getAge());
			update.set("gender", student.getGender());
			update.set("name", student.getName());
			update.set("grade", student.getGrade());
			logger.info("update student by id " + student1.getId());

			updateResult = mongoTemp.updateFirst(query, update, Student.class);//update query 
			logger.info("Data has been Updated succesfully ! for id : " + student.getId() + " and Name : "
					+ student.getName());
		}
		return updateResult;

	}

	public Student searchStudentById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));

		Student student = mongoTemp.findOne(query, Student.class);//search query by id 
		if (student==null) {
			throw new StudentServiceException(ErrorMessages.NOT_FOUND_WITH_GIVEN_ID.getErrorMessage());
		}
		return student;
	}

	public List<Student> findAllStudent() {
		logger.info("All Student details.");
		return mongoTemp.findAll(Student.class);//search all student query
	}

}
