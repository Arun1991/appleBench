package java8.functionalInterface;

import java.util.List;
import java.util.function.Consumer;

import java8.model.Student;
import java8.model.StudentDatabase;

public class ConsumerExample {

	/*
	 * Consumer functional interface has following methods
	 * 1. void accept(T t);
	 * 2. default Consumer<T> andThen(Consumer<? super T> after) {
    
	 */
	public static void main(String[] args) {
		//Consumer<String>strConsumer = (s)->System.out.print(s.toUpperCase());
		//strConsumer.accept("java8");
		printName();
		System.out.println();
		printNameAndActivities();
	}

	public static void printName(){
		List<Student>studentList = StudentDatabase.getAllStudents();
		studentList.forEach((s)->System.out.println(s));
	}
	
	public static void printNameAndActivities(){
		Consumer<Student> c1 = (s)->System.out.print(s.getName());
		Consumer<Student> c2 =(s)->System.out.println(s.getActivities());
		List<Student>studentList = StudentDatabase.getAllStudents();
		studentList.forEach(c1.andThen(c2));
	}
}
