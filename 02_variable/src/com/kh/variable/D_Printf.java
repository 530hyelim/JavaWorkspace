package com.kh.variable;

public class D_Printf {
	public void printfTest() {
		/*
		 * println() => 값 출력 후 자동 개행(\n)이 이루어진다
		 * print() => 값 만 출력한 후 종료
		 * printf("출력할 형식", 형식에 맞는 값들 ...)
		 *   => f는 format을 의미한다
		 *   => 형식에 맞춰서 값들을 출력한 후 종료 (줄바꿈 X)
		 *   문자열에 추가 가능한 형식
		 *   %d : decimal 정수
		 *   %f : float 실수
		 *   %c : character 문자
		 *   %s : string 문자열 
		 */
		// 정수 테스트
		int iNum1 = 10;
		int iNum2 = 20;
		System.out.println("iNum1 : "+iNum1+", iNum2 : "+iNum2);
		System.out.printf("iNum1 : %d, iNum2 : %d\n", iNum1, iNum2);
		// %와 d 사이에 양/음의 정수 추가 => ___10 이런식으로 자리 고정됨
		// 양수일때 우측정렬, 음수일때 좌측정렬
		
		// 실수 테스트
		double dNum = 4.27546789;
		System.out.printf("dNum : %f\n", dNum);
		// %f => 소수점 아리 6번째까지만 출력 (반올림 O)
		System.out.printf("dNum : %.10f", dNum);
		// 소수점 아래 첫번째 자리까지만 출력하고 싶다면? %.1f %.2f
	}
}
