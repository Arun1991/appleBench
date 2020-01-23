package java8.dates;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ComparingTimesDurationExample {

	public static void main(String[] args) {
		LocalTime time = LocalTime.of(7, 10);
		LocalTime time1  =LocalTime.of(8, 20);
		
		long diff = time.until(time1, ChronoUnit.MINUTES);
		System.out.println(diff);
		
		Duration duration = Duration.between(time, time1);
		System.out.println(duration.toMinutes());
		
		Duration duration1 = Duration.ofHours(3);
		System.out.println("toMinutes "+duration1.toMinutes());
		
	}

}
