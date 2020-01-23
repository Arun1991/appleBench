package java8.javastreams.numericStream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

	static List<Integer> mapToObj(){
		return IntStream.range(1, 5)
		.mapToObj(i-> new Integer(i)).collect(Collectors.toList());
	}
	
	static long mapToLong(){
		return IntStream.range(1, 5)
		.mapToLong(i-> i).sum();
	}
	
	static double mapToDouble(){
		return IntStream.range(1, 5)
		.mapToDouble(i-> new Integer(i)).sum();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mapToObj());
		System.out.println(mapToLong());
		System.out.println(mapToDouble());
	}

}
