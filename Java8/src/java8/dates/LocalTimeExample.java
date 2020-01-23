package java8.dates;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {

	public static void main(String[] args) {
		LocalTime localTime = LocalTime.now();
		System.out.println("local time " + localTime);

		LocalTime localTime1 =LocalTime.of(23, 23);
		System.out.println("localTime1 "+localTime1);
		

		LocalTime localTime2=LocalTime.of(23, 23,23);
		System.out.println("localTime2 "+localTime2);
	

		LocalTime localTime3 =LocalTime.of(23, 23,23,23);
		System.out.println("localTime3 "+localTime3);
		
		/*
		 *getting the values from local time instance 
		 */
		System.out.println("getHour "+localTime.getHour());
		System.out.println("getMinute "+localTime.getMinute());
		System.out.println("get(Hour_of_Day)"+localTime.get(ChronoField.HOUR_OF_DAY));
		System.out.println("toSecondOfday"+localTime.toSecondOfDay());
		/*
		 * Modify values of LocalTime
		 */
		System.out.println("minusHours "+localTime.minusHours(2));
		System.out.println("minus "+localTime.minus(2,ChronoUnit.HOURS));
		System.out.println("with.chronoUnit "+localTime.with(LocalTime.MIDNIGHT));
		System.out.println("witj.Hour_Of_Day "+localTime.with(ChronoField.HOUR_OF_DAY,22));
		System.out.println("plus minutes "+localTime.plusMinutes(23));
		
		
		
		
	}

}
