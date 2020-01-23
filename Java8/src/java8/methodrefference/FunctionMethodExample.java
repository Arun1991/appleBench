package java8.methodrefference;

import java.util.function.Function;

public class FunctionMethodExample {

	static Function<String,String> toUpperCaseLambda =(s)->s.toUpperCase();
	static Function<String,String> toUpperCaseMethodRefference = String::toUpperCase;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toUpperCaseLambda.apply("java"));
		System.out.println(toUpperCaseMethodRefference.apply("java"));
	}

}
