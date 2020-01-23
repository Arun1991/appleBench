package java8.javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java8.model.Student;
import java8.model.StudentDatabase;

public class StreamReduceExample {

	/*reduce is a terminal operation. used to reduce the contents of stream into single value
	it takes 2 params
	1st param- default or inintial value
	2nd param-Binaryoperator<T>*/
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,3,5,7);
		System.out.println(performMultiply(list));
		Optional<Integer> result = performMultiplywithoutIdentity(list);
		if(result.isPresent())
			System.out.println(result.get());
		
		System.out.println();
		
		Optional<Student>studentOPtional = getHighestGpaStudent();
		if(studentOPtional.isPresent())
			System.out.println(studentOPtional.get());
	}
	
	static int performMultiply(List<Integer> list){
		return list.stream().reduce(1,(a,b)->a*b);
	}
	static Optional<Integer> performMultiplywithoutIdentity(List<Integer> list){
		return list.stream().reduce((a,b)->a*b);
	}
	
	
	static Optional<Student> getHighestGpaStudent(){
		return StudentDatabase.getAllStudents().stream()
						.reduce((s1,s2)->{
							if(s1.getGpa()>s2.getGpa()){
								return s1;
							}
							else
								return s2;
						});
	}
	

}
