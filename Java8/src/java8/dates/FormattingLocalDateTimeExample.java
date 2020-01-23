package java8.dates;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateTimeExample {

	public static void parseLocalDateTime() {
		String dateTime = "2018-04-18T14:33:33";
		LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
		System.out.println(localDateTime);
		
		LocalDateTime localDateTime2 = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println(localDateTime2);
		
		/*
		 * custom datetimeformat
		 */
		String dateTime1 = "2018-04-18T14|33|33";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss");
		System.out.println(LocalDateTime.parse(dateTime1,dateTimeFormatter));
	}

	public static void formatLocalDateTime() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.format(dateTimeFormatter));
	}

	public static void main(String[] args) {
		parseLocalDateTime();
		System.out.println("----");
		formatLocalDateTime();
	}

}
