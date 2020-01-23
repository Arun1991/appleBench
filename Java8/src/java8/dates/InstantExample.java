package java8.dates;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {

	public static void main(String[] args) {
		Instant instant = Instant.now();
		System.out.println("instant "+instant);
		System.out.println("getEpochSecond "+instant.getEpochSecond());
		System.out.println(instant.ofEpochSecond(0));
		
		Duration duration = Duration.between(instant, instant.now());
		System.out.println(duration.getNano());
	}

}
