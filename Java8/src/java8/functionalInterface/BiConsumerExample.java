package java8.functionalInterface;

import java.util.List;
import java.util.function.BiConsumer;

import java8.model.Student;
import java8.model.StudentDatabase;

public class BiConsumerExample {

	public static void main(String[] args) {
		BiConsumer<String, String> biConsumer = (s1,s2)-> System.out.println("s1:"+s1+" s2"+s2);
		biConsumer.accept("java", "8");
		BiConsumer<Integer,Integer>multiply = (a,b)->System.out.println("multiply:a*b "+a*b);
		BiConsumer<Integer,Integer>divide = (a,b)->System.out.println("divide:a/b "+a/b);
		
		multiply.andThen(divide).accept(10, 5);
		
		printNameAndActivities();
	}
	
	public static void printNameAndActivities(){
		BiConsumer<String, List<String>>biconsumer = (name,activities)->System.out.println(name+" "+activities);
		List<Student>students = StudentDatabase.getAllStudents();
		students.forEach(student->{
			biconsumer.accept(student.getName(), student.getActivities());
		});
	}

}
