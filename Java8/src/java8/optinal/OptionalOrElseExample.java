package java8.optinal;

import java.util.Optional;

import java8.model.Student;
import java8.model.StudentDatabase;

public class OptionalOrElseExample {

	public static String optionalOrElse(){
		//Optional<Student>studentOPtional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		Optional<Student>studentOPtional = Optional.ofNullable(null);
		
		return studentOPtional.map(Student::getName).orElse("Default");
	} 
	

	public static String orElseGet(){
		//Optional<Student>studentOPtional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		Optional<Student>studentOPtional = Optional.ofNullable(null);
		return studentOPtional.map(Student::getName).orElseGet(()->"Default");
	}
	
	public static String orElseThrow(){
		//Optional<Student>studentOPtional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		Optional<Student>studentOPtional = Optional.ofNullable(null);
		return studentOPtional.map(Student::getName).orElseThrow(()->new RuntimeException("no data "));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(optionalOrElse());
		System.out.println(orElseGet());
		System.out.println(orElseThrow());
	}

}
