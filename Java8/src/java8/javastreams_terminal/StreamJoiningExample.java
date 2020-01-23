package java8.javastreams_terminal;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamJoiningExample {

	static String joining_1(){
		return StudentDatabase.getAllStudents().stream()
			.map(Student::getName)
			.collect(Collectors.joining());
	}
	
	static String joining_2(){
		return StudentDatabase.getAllStudents().stream()
			.map(Student::getName)
			.collect(Collectors.joining("-"));
	}
	static String joining_3(){
		return StudentDatabase.getAllStudents().stream()
			.map(Student::getName)
			.collect(Collectors.joining("-","(",")"));
	}
	public static void main(String[] args) {
		//joining() collector performs the String concatenation of the elements in the stream
		System.out.println(joining_1());
		System.out.println(joining_2());
		System.out.println(joining_3());
	}

}
