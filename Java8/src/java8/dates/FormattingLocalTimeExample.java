package java8.dates;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalTimeExample {

	public static void parseTime() {
		String time = "13:00";
		LocalTime localTime = LocalTime.parse(time);
		System.out.println(localTime);
		System.out.println(LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME));
		
		/*
		 * custom defined format
		 */
		
		String time1="14*00";
		DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("HH*mm");
		System.out.println(LocalTime.parse(time1,dateTimeFormatter));
		

		String time2="14*00*02";
		DateTimeFormatter dateTimeFormatter2 =DateTimeFormatter.ofPattern("HH*mm*ss");
		System.out.println(LocalTime.parse(time2,dateTimeFormatter2));
	}

	public static void formatTime() {
		DateTimeFormatter dateTimeFormatter2 =DateTimeFormatter.ofPattern("HH|mm|ss");
		LocalTime time = LocalTime.now();
		System.out.println(time);
		String formattedTime = time.format(dateTimeFormatter2);
		System.out.println(formattedTime);
	}
	public static void main(String[] args) {
		parseTime();
		System.out.println("-----------");
		formatTime();
	}

}
