package java8.dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public class LocalDateExample {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println("local date " + localDate);
		System.out.println("month: "+localDate.getMonth());
		System.out.println("day of the week: "+localDate.getDayOfWeek());
		System.out.println("day of the year: "+localDate.getDayOfYear());
		System.out.println("day of the month using get"+localDate.get(ChronoField.DAY_OF_MONTH));
		
		LocalDate localDate1 = LocalDate.of(2018, 01, 01);
		System.out.println(localDate1);
		
		LocalDate localDate2 = LocalDate.ofYearDay(2018, 100);
		System.out.println(localDate2);
		System.out.println("--------------");
		/*
		 * Modifing Local Date
		 */
		System.out.println("current date " + localDate);
		System.out.println("localDate.plusDays(5)"+localDate.plusDays(5));
		System.out.println("localDate.plusMonths(5)"+localDate.plusMonths(5));
		System.out.println("localDate.minusDays(5)"+localDate.minusDays(5));
		System.out.println("with year "+localDate.withYear(2022));
		System.out.println("with chronoFiled"+localDate.with(ChronoField.YEAR,2005));
		System.out.println("firsr day of next month"+localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.println("chronounit minus"+localDate.minus(1, ChronoUnit.YEARS));
		
		/*
		 * Additional support methods
		 */
		System.out.println("is leap year "+localDate.isLeapYear());
		System.out.println("are dates equal "+localDate.isEqual(localDate1));
		System.out.println("isBefore "+localDate.isBefore(localDate1));
		
	}

}
