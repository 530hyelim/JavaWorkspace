package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice1 {
	public void method() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 : ");
		char c = sc.nextLine().charAt(0);
		System.out.printf("%c unicode : %d", c, (int)c);
		// int unicode = c;
		// System.out.println(c + " unicode : " + unicode);
	}
}
