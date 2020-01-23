package java8.javastreams_terminal;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamsGroupingByExample {

	public static void groupByGender(){
		Map<String,List<Student>>studentMap = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGender));
		System.out.println(studentMap);
	}
	
	public static void customizedgroupBy(){
		Map<String,List<Student>>studentMap = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student->Student.getGpa()>=3.8? "OUTSTANDING":"AVERAGE"));
		System.out.println(studentMap);
	}
	
	public static void twoLevelGrouping_1(){
		Map<Integer,Map<String,List<Student>>> studentMap = StudentDatabase.getAllStudents().stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.groupingBy(Student->Student.getGpa()>=3.8? "OUTSTANDING":"AVERAGE") ));
		System.out.println(studentMap);
	}
	public static void twoLevelGrouping_2(){
		Map<Integer,Integer> studentMap = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.summingInt(Student::getNoteBooks)));
		
		System.out.println(studentMap);
	}
	
	public static void threeArgumentGroupBy(){
		LinkedHashMap<String, Set<Student>>studentMap = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));
		
		System.out.println(studentMap);
	}
	
	public static void calculateTopGpa(){
		Map<Integer,Optional<Student>>studentMapOptional = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println(studentMapOptional);
	}
	
	public static void calculateleastGpa(){
		Map<Integer,Student>studentMapOptional = StudentDatabase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		System.out.println(studentMapOptional);
	}
	public static void main(String[] args) {
		
		groupByGender();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		customizedgroupBy();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		twoLevelGrouping_1();

		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		
		
		twoLevelGrouping_2();
		

		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		threeArgumentGroupBy();
		

		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		calculateTopGpa();
		

		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		calculateleastGpa();
	}

}
