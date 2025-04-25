package com.kh.operator;

import java.util.Scanner;

public class B_Logical {
	/*
	 * 논리 연산자 : 논리 값 두개를 비교하는 연산자
	 * 
	 * AND && : a && b -> a와 b가 모두 참(true)일 경우에만 true 반환
	 * 			둘 중 하나라도 false값이 들어간 경우 false 반환
	 * OR || : a || b -> a와 b 모두 거짓인 경우에만 false 반환
	 * 			둘 중 하나라도 true값이 들어간 경우 true 반환
	 */
	public void method1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 하나 입력해주세요 : ");
		int num = sc.nextInt();
		
		boolean result = (num > 0) && (num % 2 == 0); // 괄호는 필요없지만 가독성 확보용
		System.out.println("num의 값이 0보다 크면서, 짝수입니까? " + result);
	}
	
	public void method2() {
		// 입력한 값이 1이상 100이하의 숫자인지 확인
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력 : ");
		int num = sc.nextInt();
		
		// 1 <= x <= 100
		boolean result = (1 <= num) && (num <= 100);
		System.out.println("num의 값은 1이상 100이하의 값입니까? " + result);		
	}
	
	public void method3() {
		// 사용자가 입력한 값이 'y' 혹은 'Y'인 경우 true, 아니면 false
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계속 진행하시려면 y를 입력해주세요: ");
		char ch = sc.nextLine().charAt(0);
		
		boolean result = ch == 'y' || ch == 'Y';
		System.out.println(result);
	}
	
	public void method4() {
		// shortcut expression (지름길 표현식)
		int num1 = 10;
		// and 연산자의 경우 A && B의 조건중 A의 값이 false인 경우
		// 뒤 쪽 조건들은 "무조건" false이기 때문에 뒤쪽 조건식은 실행되지도 않는다
		boolean result1 = (num1 < 5) && (num1++ > 0); //전위증감연산자
		System.out.println("result1 : " + result1); // (false && true) ==> false
		System.out.println("num1 : " + num1); // 10
		// (num1 > 5)로 부등호 기호를 바꾸면 결과값이 11이 된다
		// 첫번째 조건이 참이라면 두번째 조건도 실행되기 때문에 ++이 된다
		
		int num2 = 10;
		// or 연산자의 경우 A || B중 A가 참일경우 뒤 쪽 조건식은 검사하지 않고 참을 반환
		boolean result2 = (num2 < 20) || (++num2 > 0); //후위증감연산자. 차이는 있지만 둘다 +1 하는점은 같다
		// result2 ==> true
		// num2 => 10
	}
}
