package java8.javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMimMacExample {

	static Optional<Integer> findMaxValue(List<Integer> list){
		return list.stream()
		.reduce((x,y)-> x>y ?x: y);
	}
	
	static Optional<Integer> findMinValue(List<Integer> list){
		return list.stream()
		.reduce((x,y)-> x<y ?x: y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>integerList = Arrays.asList(6,7,8,9,10);
		System.out.println("max value:"+findMaxValue(integerList).get());
		System.out.println("min value:"+findMinValue(integerList).get());
	}

}
