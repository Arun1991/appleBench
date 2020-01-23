package java8.javastreams;

import java.util.List;
import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamsFlatMapExample {

	//flatmap() is similar to map method but it is used in the context of stream where each element the strreams represents
	//multiple elements
	//eg::Stream<List>,Stream<Arrays>
	public static List<String> printActivities(){
		return StudentDatabase.getAllStudents().stream()//Stream<Student>
		.map(Student::getActivities)//Stream<List<String>>
		.flatMap(List::stream)//Stream<String>
		.collect(Collectors.toList());
	}
	
	public static List<String> printUniqueActivities(){
		System.out.println("print uniqueActivities");
		return StudentDatabase.getAllStudents().stream()//Stream<Student>
		.map(Student::getActivities)//Stream<List<String>>
		.flatMap(List::stream)//Stream<String>
		.distinct()
		.collect(Collectors.toList());
	}
	
	public static long getActivitiesCount(){
		System.out.print("no of activities: ");
		return StudentDatabase.getAllStudents().stream()//Stream<Student>
		.map(Student::getActivities)//Stream<List<String>>
		.flatMap(List::stream)//Stream<String>
		.count();
	}
	public static List<String> printSortedActivities(){
		System.out.print("sorted ");
		return StudentDatabase.getAllStudents().stream()//Stream<Student>
		.map(Student::getActivities)//Stream<List<String>>
		.flatMap(List::stream)//Stream<String>
		.sorted()
		.collect(Collectors.toList());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printActivities());
		System.out.println(printUniqueActivities());
		System.out.println(getActivitiesCount());
		System.out.println(printSortedActivities());
	}

}
