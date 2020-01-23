package java8.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeExample {

	public static void main(String[] args) {

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("local date-time " + localDateTime);
		
		LocalDateTime localDateTime1 = LocalDateTime.of(2020, 03,20,23,23);
		System.out.println(localDateTime1);
		LocalDateTime localDateTime2 =LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println(localDateTime2);
		/*
		 * getting time and date from LocalDateTime instance
		 */
		
		System.out.println("getHour "+localDateTime.getHour());
		System.out.println("getMinute "+localDateTime.getMinute());
		System.out.println("getDayOfMonth "+localDateTime.getDayOfMonth());
		System.out.println("getDayOfMonth "+localDateTime.get(ChronoField.DAY_OF_MONTH));
		
		/*
		 * Modifying localdateTime
		 */
		System.out.println("plusHours "+localDateTime.plusHours(2));
		
		/*
		 * converting localdate,localtime to localdatetime and vice-versa
		 */
		System.out.println("converting methods");
		LocalDate localDate = LocalDate.of(2018, 01, 01);
		System.out.println("atTime"+localDate.atTime(LocalTime.now()));
		System.out.println("atTime"+localDate.atTime(23, 23));

		
		LocalTime localTime =LocalTime.of(22, 30);
		System.out.println("atDate "+localTime.atDate(localDate));
		
		System.out.println("toLocaldate "+localDateTime.toLocalDate());
		System.out.println("toLocalTime "+localDateTime.toLocalTime());
		
	}

}
