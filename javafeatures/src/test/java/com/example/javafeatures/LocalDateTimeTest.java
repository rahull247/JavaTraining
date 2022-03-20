package com.example.javafeatures;

import java.time.LocalDate;
import java.util.TimeZone;
import java.time.*;

import org.assertj.core.api.InstantAssert;
import org.junit.jupiter.api.Test;

public class LocalDateTimeTest {

	/*Three classes of java.time:
	*	LocalDate
	*	LocalTime
	*	LocalDateTime
	*/
	@Test
	void localDateTimeNow() {
		System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
		System.out.println(LocalDate.now());
	}
	
	@Test
	void localDate() {
		System.out.println("---------Local DAte------------");
		LocalDate date=LocalDate.of(2022, Month.JANUARY, 28);
		System.out.println("Day Of Month:"+date.getDayOfMonth());
		System.out.println("Month:"+date.getMonth());
		System.out.println("Year:"+date.getYear());
		System.out.println("Day Of Week:"+date.getDayOfWeek());
		System.out.println("Day Of Year:"+date.getDayOfYear());
		System.out.println("Length Of Month:"+date.lengthOfMonth());
		System.out.println("Length Of Year:"+date.lengthOfYear());
		System.out.println("Is leap Year:"+date.isLeapYear());
	}
	
	@Test
	void localTime() {
		System.out.println("---------Local Time------------");
		LocalTime time=LocalTime.of(22,52,34);
		System.out.println("Hour:"+time.getHour());
        System.out.println("Minute:"+time.getMinute());
        System.out.println("Second:"+time.getSecond());
        System.out.println("Nano:"+time.getNano());
	}

	@Test
	void localDateTime() {
		System.out.println("---------Local Date Time------------");
		LocalDateTime dateTime=LocalDateTime.of(2022, Month.JANUARY, 28, 22, 52, 34);
		System.out.println("Get dateTime Hour:"+dateTime.getHour());
        System.out.println("Get dateTime Minute:"+dateTime.getMinute());
        System.out.println("Get dateTime Second:"+""+dateTime.getSecond());
        System.out.println("Get dateTime NanoSecond:"+dateTime.getNano());
        System.out.println("Get dateTime:"+dateTime);
        System.out.println("Get dateTime LocalDate:"+dateTime.toLocalDate());
        System.out.println("Get dateTime LocalTime:"+dateTime.toLocalTime());
	}
	
	
	@Test
	void instant() {
		System.out.println(Instant.now());
		System.out.println(Instant.ofEpochSecond(4));
		System.out.println(Clock.fixed(Instant.now(), ZoneId.of("Asia/Calcutta")));
	}
	
	@Test
	void durationTime() {
		LocalDateTime localDateTime=LocalDateTime.of(2022, Month.FEBRUARY, 28, 17,56, 00);
		LocalDateTime currentDateTime=LocalDateTime.now();
		Duration duration=Duration.between(localDateTime, currentDateTime);
		System.out.println(duration);
		System.out.println(Duration.between(LocalTime.of(28, 17,56, 00),LocalTime.of(29, 17,56, 00) ));
	}
	
	@Test
	void periodDate() {
		LocalDate localDateTime=LocalDate.of(2022, Month.FEBRUARY, 28);
		LocalDate currentDateTime=LocalDate.now();
		Period period=Period.between(localDateTime, currentDateTime);
		System.out.println(period);
		System.out.println(Period.between(LocalDate.of(2022, Month.FEBRUARY, 28), LocalDate.of(2022, Month.MARCH, 29)));
	}
	
	
	@Test
	void zoneDateTime() {
	    ZoneId romeZone = ZoneId.of("Asia/Calcutta"); 
	    ZoneId zoneId = TimeZone.getDefault().toZoneId();
	    System.out.println(romeZone);
	    System.out.println(zoneId);
	}
	
	@Test
	void zonedDateTime() {
	    ZoneId romeZone = ZoneId.of("Asia/Calcutta");
	    LocalDate date = LocalDate.of(2022, Month.JANUARY, 28);
	    LocalDateTime dateTime = LocalDateTime.of(2022, Month.JANUARY, 28, 18, 13, 45);
	    System.out.println(date.atStartOfDay(romeZone));
	    System.out.println(dateTime.atZone(romeZone));
	}
}
