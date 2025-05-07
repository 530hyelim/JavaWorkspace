package com.kh.practice.leap.controller;

import java.util.Calendar;

public class LeapController {
	
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
	
	public long leapDate(Calendar c) {
		//1년부터 2024년까지의 일수 구하기
		long days = 0;
		for(int year = 1; year <= c.get(Calendar.YEAR); year++) {
			if(isLeapYear(year)) {
				days += 365;
			} else {
				days += 366;
			}
		}
		//현재년도에서의 일수 구하기
		int month = c.get(Calendar.MONTH)+1;
		for(int i = 1; i < month; i++) {			
			switch(i) {
			case 1, 3, 5, 7, 8, 10, 12:
				days += 31;
				break;
			case 4, 6, 9, 11:
				days += 30;
				break;
			case 2:
				days += (isLeapYear(c.get(Calendar.YEAR))? 29:28);
			}
		}
		//이번 달 일수 더하기
		days += c.get(Calendar.DATE);
		return days;
	}
	
}
