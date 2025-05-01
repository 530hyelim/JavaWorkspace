package com.kh.practice.leap.controller;

import java.util.Calendar;

public class LeapController {
	
	public boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}
	
	public long leapDate(Calendar c) {
		long days = 0;
		for(int year = 1; year <= c.get(Calendar.YEAR); year++) {
			if(isLeapYear(year)) {
				days += 365;
			} else {
				days += 366;
			}
		}
		return days;
	}
	
}
