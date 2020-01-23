package java8.dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateLocalDateExample {

	public static void main(String[] args) {
		/*
		 * java.util.date into LocalDate vice-versa
		 */
		Date date = new Date();
		System.out.println("date: "+date);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println("local date "+localDate);
		
		Date date1 = new Date();
		date1.from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
		System.out.println("date1 "+date1);
		
		
		/*
		 * java.sql.date into LocalDate vice-versa
		 */
		java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
		System.out.println("sql date "+sqlDate);
		LocalDate localDate2 = sqlDate.toLocalDate();
		System.out.println(localDate2);
	}

}
