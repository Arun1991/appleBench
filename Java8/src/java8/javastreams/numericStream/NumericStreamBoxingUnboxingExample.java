package java8.javastreams.numericStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {

	static List<Integer> boxing(){
		return IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
	}
	
	static int unboxing(List<Integer> list){
		return list.stream().mapToInt(Integer::intValue).sum();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(boxing());
		System.out.println(unboxing(Arrays.asList(1,2)));
	}

}
