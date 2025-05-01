package com.kh.practice.leap.view;

import java.util.Calendar;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {
	public LeapView() {
		LeapController lc = new LeapController();
		int year = 2019;
		
		String result = lc.isLeapYear(year) ? "윤년":"평년";
		System.out.println(year+"년은 "+result+"입니다.");
		
		Calendar today = Calendar.getInstance();
		System.out.println("총 날짜 수 : "+lc.leapDate(today));
	}
}
