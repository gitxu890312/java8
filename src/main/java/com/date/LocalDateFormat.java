package com.date;

import java.text.SimpleDateFormat;

public class LocalDateFormat {

	private static ThreadLocal<SimpleDateFormat> localFormats = new ThreadLocal<>();
	
	
	public static SimpleDateFormat getFormat() {
		SimpleDateFormat simpleDateFormat = localFormats.get();
		if(simpleDateFormat==null) {
			simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			localFormats.set(simpleDateFormat);
		}
		return simpleDateFormat;
	}
}
