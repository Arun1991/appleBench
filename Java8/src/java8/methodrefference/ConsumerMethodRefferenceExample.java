package java8.methodrefference;

import java.util.function.Consumer;

import java8.model.Student;
import java8.model.StudentDatabase;

public class ConsumerMethodRefferenceExample {

	static Consumer<Student>stu =System.out::println;
	static Consumer<Student>stude =Student::printActivities;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDatabase.getAllStudents().forEach(stu);
		StudentDatabase.getAllStudents().forEach(stude);
		
	}

}
