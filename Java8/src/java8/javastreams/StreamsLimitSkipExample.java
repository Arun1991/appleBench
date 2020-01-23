package java8.javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

	static Optional<Integer> limitSum(List<Integer> integerList){
		return integerList.stream()
				.limit(2)
				.reduce((x,y)->x+y);
	}
	
	static Optional<Integer> skipSum(List<Integer> integerList){
		return integerList.stream()
				.skip(3)
				.reduce((x,y)->x+y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(6,7,8,9,10);
		System.out.println(limitSum(integerList));
		System.out.println(skipSum(integerList));
	}

}
