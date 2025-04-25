package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {
	public void method() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 : ");
		double width = sc.nextDouble();
		System.out.print("세로 : ");
		double height = sc.nextDouble();
		
		System.out.printf("면적 : %.2f\n둘레 : %.1f", width*height, (width+height)*2);
	}
}
