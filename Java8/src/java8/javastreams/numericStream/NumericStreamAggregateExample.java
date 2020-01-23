package java8.javastreams.numericStream;

import java.util.stream.IntStream;

public class NumericStreamAggregateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IntStream.rangeClosed(1, 50).sum());
		System.out.println(IntStream.rangeClosed(1, 50).max());
		System.out.println(IntStream.rangeClosed(1, 50).min());
		System.out.println(IntStream.rangeClosed(1, 50).average());
	}

}
