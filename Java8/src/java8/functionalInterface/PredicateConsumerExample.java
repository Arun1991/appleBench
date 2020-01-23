package java8.functionalInterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java8.model.Student;
import java8.model.StudentDatabase;

public class PredicateConsumerExample {

	Predicate<Student> predicate1 = (student)->student.getGradeLevel()>=3;
	Predicate<Student> predicate2 = (student)->student.getGpa()>=3.9;
	
	BiConsumer<String, List<String>>studentBiconsumer =(s,a)->System.out.println(s+":"+a);
	
	Consumer<Student> studentConsumer = (student)->{
		if(predicate1.and(predicate2).test(student)){
			studentBiconsumer.accept(student.getName(), student.getActivities());
		}
	};
	public void printNameAndActivity(List<Student>list){
		list.forEach(studentConsumer);
	}
	public static void main(String[] args) {
		new PredicateConsumerExample().printNameAndActivity(StudentDatabase.getAllStudents());
	}

}
