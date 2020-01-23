package java8.functionalInterface;

import java.util.function.Predicate;

import java8.model.Student;
import java8.model.StudentDatabase;

public class PredicateStudentExample {

	static Predicate<Student> p1 = (student) -> student.getGradeLevel() >= 3;

	static Predicate<Student> p2 = (student) -> student.getGpa() >= 3.9;
	public static void main(String[] args) {
		printStudentUsingCondition();
		printUsingTwoCondition();

	}
	
	static void printUsingTwoCondition(){
		System.out.println();
		System.out.println("printUsingTwoCondition");
		
		StudentDatabase.getAllStudents().forEach(student->{
			if(p1.and(p2).test(student))
				System.out.println(student);
		});
	}
	static void printStudentUsingCondition() {
		StudentDatabase.getAllStudents().forEach(student -> {
			if (p1.test(student)) {
				System.out.println(student);
			}
		});
	}
}
