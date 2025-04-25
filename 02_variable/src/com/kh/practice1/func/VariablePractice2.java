package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice2 {
	public void method() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 : ");
		int iNum1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int iNum2 = sc.nextInt();
		
//		System.out.printf("더하기 결과 : %d\n빼기 결과 : %d\n"+ "곱하기 결과 : %d"
//				+ "\n나누기 몫 결과 : %d", iNum1+iNum2, iNum1-iNum2, iNum1*iNum2, iNum1/iNum2);
		
		System.out.println("더하기 결과 : " + (iNum1+iNum2));
		// 괄호가 없으면 "더하기결과"라는 문자열과 iNum1이라는 값이 먼저 계산되기 때문에 값이 달라지거나 에러발생
		// 뺄셈연산과 다르게 괄호가 없더라도 에러가 안뜨는 이유는 string끼리 +연산자를 이용할 수 있기 때문이다~
		System.out.println("빼기 결과 : " + (iNum1-iNum2));
		// 또는 int result = iNum1-iNum2; 으로 result값을 출력
		System.out.println("곱하기 결과 : " + iNum1*iNum2);
		System.out.println("나누기 몫 결과 : " + iNum1/iNum2);
	}
}
