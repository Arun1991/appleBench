package java8.functionalInterface;

import java.util.function.Function;

public class FunctionExample {
	/*public interface Function<T, R> {}
	 * Functional interface has following methods
	 * 1. R apply(T t);
	 * 2. default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
	 * 3. default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
	 * 4. static <T> Function<T, T> identity() {
   
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(f.apply("java"));
		System.out.println(f.andThen(addSomething).apply("java"));
		System.out.println(f.compose(addSomething).apply("java"));
	}

	static Function<String,String>f = (s1)-> s1.toUpperCase(); 
	
	static Function<String,String>addSomething = (s1)-> s1.concat("default"); 
}
