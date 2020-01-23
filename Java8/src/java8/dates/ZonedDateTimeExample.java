package java8.dates;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {

	public static void main(String[] args) {
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		System.out.println("ZonedOffset "+zonedDateTime.getOffset());
		System.out.println("Zone Id "+zonedDateTime.getZone());
		System.out.println("AvailabelZone"+ZoneId.getAvailableZoneIds());
		//ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
		System.out.println("no of zones "+ZoneId.getAvailableZoneIds().size());
		System.out.println("India Time Zone"+ZonedDateTime.now(ZoneId.of("Asia/Calcutta")));
		
		System.out.println("Zone date and time using clock"+ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Calcutta"))));
	}

}
