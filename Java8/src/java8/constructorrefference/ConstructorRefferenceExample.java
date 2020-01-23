package java8.constructorrefference;

import java.util.function.Function;
import java.util.function.Supplier;

import java8.model.Student;

public class ConstructorRefferenceExample {

	static Supplier<Student> supplier=Student::new;
	static Function<String,Student> function=Student::new;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(supplier.get());
		System.out.println(function.apply("RAM"));
	}

}
