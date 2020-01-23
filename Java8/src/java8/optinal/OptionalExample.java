package java8.optinal;

import java.util.Optional;

import java8.model.Student;
import java8.model.StudentDatabase;

public class OptionalExample {

	public static Optional<String> getStudentNameOptinal(){
		Optional<Student>studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		if(studentOptional.isPresent())
			return  studentOptional.map(Student::getName);
		return Optional.empty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<String>optionalStr = getStudentNameOptinal();
		if(optionalStr.isPresent())
			System.out.println(optionalStr.get().length());
	}

}
