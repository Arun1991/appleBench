package java8.javastreams_terminal;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamsMinByMaxByExample {

	static Optional<Student> minBy(){
		return StudentDatabase.getAllStudents().stream()
			.collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
	
	}
	
	static Optional<Student> maxBy(){
		return StudentDatabase.getAllStudents().stream()
			.collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
	}
	public static void main(String[] args) {
		System.out.println(maxBy());
		System.out.println(minBy());
	}

}
