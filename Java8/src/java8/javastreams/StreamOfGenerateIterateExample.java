package java8.javastreams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

	public static void main(String[] args) {
		Stream<String>strStream = Stream.of("A","B");
		strStream.forEach(System.out::println);
		System.out.println("--------------");
		Stream.iterate(1,x->x*2)
		.limit(10)
		.forEach(System.out::println);
		System.out.println("--------------");
		Supplier<Integer> intSupplier = new Random()::nextInt;
		Stream.generate(intSupplier)
		.limit(5).forEach(System.out::println);
	}
}
