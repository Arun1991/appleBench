package java8.javastreams.numericStream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamExample {

	static int sumOfNumbersrangeClosed(){
		return IntStream.rangeClosed(1, 6).sum();
	}
	
	static int sumOfNumbers(){
		return IntStream.range(1, 6).sum();
	}
	
	static long longsumOfNumbers(){
		return LongStream.range(1, 6).sum();
	}
	
	static long longsumOfNumbersRangeClosed(){
		return LongStream.rangeClosed(1, 6).sum();
	}
	
	static double doubleStream(){
		return IntStream.range(1, 6).asDoubleStream().sum();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List<Integer>integerList = Arrays.asList(1,2,3,4,5,6);
		System.out.println("range()"+sumOfNumbers());
		System.out.println("rangeclosed()"+sumOfNumbersrangeClosed());
		System.out.println("long stream()"+longsumOfNumbers());
		System.out.println("long streamclosed()"+longsumOfNumbersRangeClosed());
		System.out.println("doubleStream()"+doubleStream());
	}

}
