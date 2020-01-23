package java8.functionalInterface;

import java.util.function.Predicate;

public class PredicateExample {

	/*
	 * predicate functional interface has following methods
	 * 1. boolean test(T t)
	 * 2. default Predicate<T> and(Predicate<? super T> other) {
	 * 3.  default Predicate<T> negate() {
	 * 4.  default Predicate<T> or(Predicate<? super T> other) {
	 * 5.   static <T> Predicate<T> isEqual(Object targetRef) {
	 */
	
	static Predicate<Integer>predicate = (a)->{return a%2==0;};
	static Predicate<Integer>predicate1 = (a)->{return a%5==0;};
	
	public static void main(String[] args) {
		
		System.out.println(predicate.test(4));
		System.out.println(predicate.test(5));
		System.out.println();
		predicateAnd(9);
		System.out.println();
		predicateOr(4);
		System.out.println();
		predicateNegate(4);
	}
	
	public static void predicateAnd(int no){
		System.out.println("predicateAnd  "+predicate.and(predicate1).test(no));
	}
	
	public static void predicateOr(int no){
		System.out.println("predicateOr  "+predicate.or(predicate1).test(no));
	}
	
	public static void predicateNegate(int no){
		System.out.println("predicateNegate  "+predicate.or(predicate1).negate().test(no));
	}
}
