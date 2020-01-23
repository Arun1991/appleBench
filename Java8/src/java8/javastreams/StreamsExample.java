package java8.javastreams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamsExample {

	public static void main(String[] args) {
		// student name and their activities in a map
		Map<String,List<String>>studentMap = StudentDatabase.getAllStudents().stream()
				//.peek(st-> System.out.println(st))
				.filter(student->student.getGradeLevel()>=3)
				.peek(st-> System.out.println("after 1st filter "+st))
				.filter(student->student.getGpa()>=3.9)
				.peek(st-> System.out.println("after 2nd filter"+st))
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		
		//System.out.println(studentMap);
	}

}
