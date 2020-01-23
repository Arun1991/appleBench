package java8.functionalInterface;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
/*
 * public interface UnaryOperator<T> extends Function<T, T> {


    static <T> UnaryOperator<T> identity() {
        return t -> t;
    }

 */
	
	static UnaryOperator<String>u = (str->str.toUpperCase());
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(u.apply("java"));
	}

}
