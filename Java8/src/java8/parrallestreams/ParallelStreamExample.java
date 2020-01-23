package java8.parrallestreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static long checkPerformanceResult(Supplier<Integer>supplier,int numberOfTimes){
		long starTime = System.currentTimeMillis();
		for(int i=0;i<numberOfTimes;i++){
			supplier.get();
		}
		long endTime = System.currentTimeMillis();
		return endTime-starTime;
	}
	public static int sum_sequential(){
		return IntStream.rangeClosed(1,10000).sum();
	}
	
	static int sum_parallel(){
		return IntStream.rangeClosed(1,10000).parallel().sum();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Runtime.getRuntime().availableProcessors());
		
		System.out.println("sequentialStream result "+checkPerformanceResult(ParallelStreamExample::sum_sequential,20));
		System.out.println("parallel stream result "+checkPerformanceResult(ParallelStreamExample::sum_parallel,20));
		
		
		
	
	}

}
