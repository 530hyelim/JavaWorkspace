package com.kh.practice1.func;

import java.util.Scanner;
//ctrl+shift+O 눌러서 자동으로 class import

public class VariablePractice4 {
	public void method() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		System.out.printf("첫 번째 문자 : %c\n두 번째 문자 : %c\n세 번째 문자 : %c", 
				str.charAt(0), str.charAt(1), str.charAt(2));
	}
}
