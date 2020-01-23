package java8.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class StudentDatabase {

	public static Supplier<Student> studentSupplier = ()-> {
		Bike bike = new Bike();
		bike.setModel("2020");
		bike.setName("unicorn");
		Student st =  new Student("Ram", 3.6, "male", 2, Arrays.asList("swimming","basketball","volleyball"),11);
		st.setBike(Optional.ofNullable(bike));
		return st;
	};
	public static List<Student> getAllStudents(){
		
		Student stu1 = new Student("Adam",3.6, "male", 2, Arrays.asList("swimming","basketball","volleyball"),11);
		Student stu2 = new Student("Jenny",3.6, "female", 2, Arrays.asList("swimming","gymnastics","soccer"),12);
		//3rd grade students
		Student stu3 = new Student("Emily",4.0, "female", 3, Arrays.asList("swimming","gymnastics","aerobics"),10);
		Student stu4 = new Student("Dave",3.9, "male", 3, Arrays.asList("swimming","gymnastics","soccer"),9);
		//grade 4
		Student stu5 = new Student("Sophia",3.5, "female", 4, Arrays.asList("swimming","dancing","football"),15);
		Student stu6 = new Student("James",3.6, "male", 4, Arrays.asList("swimming","basketball","baseball"),14);
		
		  List<Student> list = Arrays.asList(stu1,stu2,stu3,stu4,stu5,stu6);
		  return list;
	}
	
}
