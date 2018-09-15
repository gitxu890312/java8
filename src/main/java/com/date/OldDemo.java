package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OldDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMdd");
		Callable<Date> calls = new Callable<Date>() {
			public Date call() throws ParseException {
				// return sdf.parse("20161212"); 非线程安全的
//				return LocalDateFormat.getFormat().parse("20161212");//线程安全的
				LocalDate parse = LocalDate.parse("20161212", ofPattern);
				Date date = new Date(parse.toEpochDay());
				return date;
			}
		};
		ExecutorService pools = Executors.newFixedThreadPool(10);

		List<Future<Date>> futures = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<Date> submit = pools.submit(calls);
			futures.add(submit);
		}
		for (int i = 0; i < futures.size(); i++) {
			System.out.println(futures.get(i).get());
		}
		pools.shutdown();
	}
}
