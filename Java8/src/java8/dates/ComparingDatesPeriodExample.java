package java8.dates;

import java.time.LocalDate;
import java.time.Period;

public class ComparingDatesPeriodExample {

	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.of(2020, 1, 1);
		LocalDate localDate1 = LocalDate.of(2020, 12, 31);
		
		Period period = localDate.until(localDate1);
		System.out.println(period.getDays());//result is 30 rforms 31-1
		System.out.println(period.getMonths());
		
		
		Period period1 = Period.ofDays(10);
		System.out.println("period1.getDays "+period1.getDays());
		
		Period period2 = Period.ofYears(10);
		System.out.println("period1.getYears "+period2.getYears());
		System.out.println("toTotalMonths "+period2.toTotalMonths());
		
		Period period3 = Period.between(localDate, localDate1);
		System.out.println("period3.getDays() "+period3.getDays());
		System.out.println("period3.getMonths() "+period3.getMonths());
		
	}

}
