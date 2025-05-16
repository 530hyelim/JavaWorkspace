package com.kh.practice;

import java.util.Arrays;

public enum MemberGrade {
	BASIC(5,"BASIC"){
		@Override
		public String getDiscountInfo() {
			return "BASIC등급 할인율 : 5%";
		}
	}, SILVER(10,"SILVER"){
		@Override
		public String getDiscountInfo() {
			return "SILVER등급 할인율 : 10%";
		}
	}, GOLD(20,"GOLD"){
		@Override
		public String getDiscountInfo() {
			return "GOLD등급 할인율 : 20%";
		}
	}, VIP(30,"VIP"){
		@Override
		public String getDiscountInfo() {
			return "VIP등급 할인율 : 30%";
		}
	};
	
	private int dRate;
	private String grade;
	
	private MemberGrade(int dRate, String grade) {
		this.dRate = dRate;
		this.grade = grade;
	}
	
	public static MemberGrade valueOfGrade(String grade) {
		return Arrays.stream(values())
			.filter(mg -> mg.grade.equals(grade))
			.findFirst()
			.get();
	}
	
	public abstract String getDiscountInfo();
}
