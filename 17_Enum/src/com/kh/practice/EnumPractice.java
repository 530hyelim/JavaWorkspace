package com.kh.practice;

public class EnumPractice {
	public static void main(String[] args) {
		System.out.println(MemberGrade.BASIC.getDiscountInfo());
		System.out.println(MemberGrade.VIP.getDiscountInfo());
		System.out.println(MemberGrade.valueOfGrade("SILVER"));
		System.out.println(MemberGrade.valueOfGrade("GOLD"));
	}
}
