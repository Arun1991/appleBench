package java8.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateExample {

	public static void parseLocalDate(){

		//string to localdate
		String date = "2018-04-28";
		LocalDate localDate = LocalDate.parse(date);
		System.out.println(localDate);
		LocalDate localDate1 = LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(localDate1);
		
		String date1 = "20210428";//yyyyMMdd
		LocalDate localDate2 = LocalDate.parse(date1,DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(localDate2);
		
		
		/*
		 * custom defined date format
		 */
		String date2 = "2018|04|28";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
		LocalDate localDate3 = LocalDate.parse(date2,dateTimeFormatter);
		System.out.println(localDate3);
		

		String date3 = "2018*04*28";
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy*MM*dd");
		LocalDate localDate4 = LocalDate.parse(date3,dateTimeFormatter2);
		System.out.println(localDate4);
		
	}
	
	public static void formatLocalDate(){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
		LocalDate localDate = LocalDate.now();
		String formattedDate = localDate.format(dateTimeFormatter);
		System.out.println(formattedDate);
	}
	public static void main(String[] args) {
		parseLocalDate();
		System.out.println("----------------");
		formatLocalDate();
	}

}
