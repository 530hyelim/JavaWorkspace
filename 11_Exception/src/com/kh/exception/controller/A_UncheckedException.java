package com.kh.exception.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A_UncheckedException {
	/*
	 * UnCheckedEsception
	 *   - 예외처리가 필수가 아닌 예외클래스들
	 *   
	 * 대표적인 부모클래스: RuntimeException
	 *   - 프로그램 실행시 발생되는 예외클래스
	 *   - ArrayIndexOutOfBoundsException
	 *   - NullPointerException(널값이라서X, 널 가지고 뭔가 하려고 해서)
	 *   - ClassCastException(다운캐스팅 할 때 잘못된 자료형으로 캐스팅)
	 *   - ArithmeticException(0으로 나눌 때, ...)
	 *   - NegativeArraySizeException(배열의 크기를 음수로 할당했을 때)
	 * 공통점: 소스코드의 수정으로 해결방법이 존재
	 * => RuntimeException 계열들의 예외는 충분히 예측 가능한 에러들이므로,
	 * 	  예외 자체가 발생하지 않게끔 조건문으로 처리하는게 가장 좋다.
	 *    즉, 굳이 예외처리를 할 필요가 없다(Unchecked)
	 */
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		
		// 예외를 발생시키지 않게 코드적으로 처리하는 방법
		// 조건문 사용하기
		if(num2 != 0) {
			System.out.println("나눗셈 연산결과 : " + (num1/num2));
		} else {
			System.out.println("0으로 나누지 마세요..");
		}
		
		// 예외처리 구문으로 해결하기
		/*
		 * try ~ catch문
		 * 
		 * try {
		 * 	 // 예외가 발생될 수 있는 소스코드
		 * } catch(발생될 예외 클래스 변수명) {
		 * 	 // try문 안에서 예외가 발생한 경우 실행할 코드
		 * }
		 */
		try {
			System.out.println("나눗셈 연산 2회차 : " + (num1/num2));
			// 여러개의 에러가 발생하더라도 첫 에러 발생시 try문이 종료됨
		} catch(ArithmeticException e) {
			System.out.println("0으로 나누지 좀 마시죠");
			e.printStackTrace(); // 발생한 오류를 추적할 수 있음
		}
		System.out.println("프로그램 종료..");
	}
	
	public void method2() {
		System.out.print("정수입력(0 빼고) : ");
		// 다중 catch문 (여러개의 예외가 발생할 수 있을 경우)
		try {
			int num = sc.nextInt();
			System.out.println("나누기! " + (10/num));
			
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch(InputMismatchException e) {
			System.out.println("정수를 입력하세요!");
		}
		System.out.println("프로그램 종료");
	}
	
	public void method3() {
		System.out.print("배열의 크기 : ");
		int size = sc.nextInt(); // 정수값으로 잘 입력했다고 가정
		// 다중 catch 블럭
		try {
			int[] arr = new int[size];
			System.out.println("100번 인덱스 " + arr[100]);
			
		}
		catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기는 음수를 제시할 수 없다");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("부적절한 인덱스입니다");
		}
		catch(RuntimeException e) {
			// 2개의 예외클래스를 하나의 예외클래스로 다루고자 할 때?
			// 부모타입 예외클래스 사용
			// 하지만 정확한 원인을 알기 위해 범위를 최소화 하는것이 좋다
			System.out.println("예외가 발생했습니다");
			e.printStackTrace();
		}
		// 부모와 자식클래스를 동시에 사용하기 위해서는
		// 다형성 상 자식클래스의 예외들이 부모클래스로 간주되어 실행되기 때문에,
		// 아랫쪽 코드에 도달하지 못함. 따라서 부모클래스의 예외는 가장 아래에 기술해야 한다
	}
	/*
	 * RuntimeException 계열의 예외는 대부분 "조건문으로 해결"이 가능
	 * 따라서, 애초에 예외가 발생하지 않도록 개발자가 소스코드를 핸들링하는 것이 권장된다
	 * 
	 * RuntimeException 계열은 충분히 예측이 가능하기 때문에 "예외처리가 필수가 아니다(UnCheckedException)"
	 */
}
