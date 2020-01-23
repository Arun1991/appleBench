package java8.javastreams_terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamsPartioningByExample {

	public static void partioningBy_1(){
		
		Predicate<Student> gpaPredicate = student->student.getGpa()>=3.8;
		Map<Boolean,List<Student>>partioningMap = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.partitioningBy(gpaPredicate));
		System.out.println(partioningMap);
	}
	public static void partioningBy_2(){
		
		Predicate<Student> gpaPredicate = student->student.getGpa()>=3.8;
		Map<Boolean,Set<Student>>partioningMap = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.partitioningBy(gpaPredicate,Collectors.toSet()));
		System.out.println(partioningMap);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		partioningBy_1();
	}

}
