package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {
	public void method() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 : ");
		double kor = sc.nextDouble();
		System.out.print("영어 : ");
		double eng = sc.nextDouble();
		System.out.print("수학 : ");
		double mth = sc.nextDouble();
		int sum = (int)(kor+eng+mth);
		System.out.printf("총점 : %d\n평균 : %d", sum, sum/3);
	}
}
