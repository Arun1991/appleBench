package java8.javastreams_terminal;

import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamsSumAvgExample {

	static int sum(){
		return StudentDatabase.getAllStudents().stream().collect(Collectors.summingInt(Student::getNoteBooks));
	}
	
	static double avg(){
		return StudentDatabase.getAllStudents().stream().collect(Collectors.averagingInt(Student::getNoteBooks));
	}
	public static void main(String[] args) {
		System.out.println(sum());
		System.out.println(avg());
	}

}
