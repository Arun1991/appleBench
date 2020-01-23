package java8.javastreams_terminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamsMappingExample {

	public static void main(String[] args) {
		List<String>list = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toList()));
		System.out.println(list);
		
		
		Set<String>list2 = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toSet()));
		System.out.println(list2);

	}

}
