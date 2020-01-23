package java8.functionalInterface;

import java.util.Arrays;
import java.util.function.Supplier;

import java8.model.Student;

public class SupplierExample {

	/*
	 * @FunctionalInterface
	public interface Supplier<T> {

    T get();
	}
	 */
	public static void main(String[] args) {
		Supplier<Student> supply=()->  new Student("Ram", 3.6, "male", 2, Arrays.asList("swimming","basketball","volleyball"),11);
		
		System.out.println(supply.get());
	}
}
