package com.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class LocalDateTimeDemo {

	/**
	 * LocalDate 日期 LocalTime 时间 LocalDateTime 日期时间
	 */
	@Test
	public void testLocalDate() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime plusDays = ldt.plusDays(2);
		System.out.println(plusDays);
		
		LocalDateTime plusHours = ldt.plusHours(5);
		System.out.println(plusHours);
		System.out.println(ldt.minusMonths(2));
		
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getSecond());
	}
	//Instant 时间戳工具类
	@Test
	public void test2() {
		Instant now = Instant.now();//UTC时间
		System.out.println(now);
		
		System.out.println(now.atOffset(ZoneOffset.ofHours(8)));
		
		System.out.println(now.toEpochMilli());//时间戳
		System.out.println(System.currentTimeMillis());
		
		System.out.println(Instant.ofEpochSecond(60));//1970偏移60秒
	}
	//Period 两个日期之间的间隔
	//Duration 两个时间之间的间隔
	@Test
	public void test3() throws InterruptedException {
		LocalDateTime now = LocalDateTime.now();
		Thread.sleep(1000);
		LocalDateTime now1 = LocalDateTime.now();
		now1 = now1.plusDays(3);
		Duration between = Duration.between(now, now1);
		
		long days = between.toDays();
		System.out.println(days);
		
	}
	//TemporalAdjuster 时间矫正器  
	@Test
	public void test4() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime withDayOfMonth = now.withDayOfMonth(10);
		System.out.println(withDayOfMonth);
//		TemporalAdjuster ad 
		
		LocalDateTime with = now.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(with);
		
		System.out.println(now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		
		System.out.println(now.with(TemporalAdjusters.lastDayOfYear()));
	}
//		DateTimeFormatter 日期格式化
	@Test
	public void test5() {
		
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		DateTimeFormatter ofPattern2 = DateTimeFormatter.ofPattern("yyyyMMdd", Locale.CHINESE);
		System.out.println(LocalDateTime.now().format(ofPattern2));
	}
}
