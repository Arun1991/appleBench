package java8.javastreams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamsComparatorExample {

	public static List<Student> sortStudentByName(){
		return StudentDatabase.getAllStudents().stream()
		.sorted(Comparator.comparing(Student::getName))
		.collect(Collectors.toList());
	}
	public static List<Student> sortStudentByGpa(){
		return StudentDatabase.getAllStudents().stream()
		.sorted(Comparator.comparing(Student::getGpa))
		.collect(Collectors.toList());
	}
	
	public static List<Student> sortStudentByGpaDescending(){
		return StudentDatabase.getAllStudents().stream()
		.sorted(Comparator.comparing(Student::getGpa).reversed())
		.collect(Collectors.toList());
	}
	public static void main(String[] args) {
		System.out.println("sorted by name");
		sortStudentByName().forEach(System.out::println);
		System.out.println();System.out.println("sorted by gpa");
		sortStudentByGpa().forEach(System.out::println);
		System.out.println();
		System.out.println("sorted by gpa desc");;
		sortStudentByGpaDescending().forEach(System.out::println);
	}

}
