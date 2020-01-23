package java8.optinal;

import java.util.Optional;

public class OptionalPresentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<String>optional = Optional.ofNullable("hello optional");
		if(optional.isPresent())
			System.out.println(optional.get());
		optional.ifPresent(s->System.out.print(s));

	}

}
