package com.kh.practice;

import java.util.Arrays;

public enum MemberGrade {
	// 익명 구현 객체 생성방식
	// class 클래스명 extends MemberGrade
	// new MemberGrade() {추상메서드}
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
			//.filter(mg -> mg.grade.equals(grade))
			.filter(mg -> mg.name().equals(grade))
			// name() : 현재 상수값의 변수명을 문자열로 반환 => grade 필드를 따로 안써도 됨
			.findAny()
			//.findFirst()
			.orElseThrow(() -> new RuntimeException("일치하는 grade가 없습니다."));
			//.get();
	}
	
	public abstract String getDiscountInfo();
}
