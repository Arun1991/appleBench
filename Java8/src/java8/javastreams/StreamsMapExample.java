package java8.javastreams;

import java.util.Set;
import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;
public class StreamsMapExample {

	static Set<String> namesList(){
		//map method will convert from one type to another type
		//in this example map is converting a Stream<Student> to Stream<String>
		return StudentDatabase.getAllStudents().stream() //Stream<Student>
				.map(Student::getName)//Stream<String>
				.map(String::toUpperCase)
				.collect(Collectors.toSet());
	}
	
	public static void main(String[] args) {
		System.out.println(namesList());

	}

}
