package com.kh.chap05_method.controller;

public class MethodTest2 {
	/*
	 * static 메서드
	 * - static 메서드는 사용시 "객체를 생성할 필요가 없음"
	 * - 프로그램 시작시 정적메모리영역(static영역)에 메소드가 저장되어 있기 때문
	 * - 호출방법 : 클래스명.메소드명(전달값);
	 */
	static int count = 1;
	int count2 = 2;
	
	//객체를 생성하지 못하게 막아두는 역할
	private MethodTest2() {
		
	}
	
	public static int method(int num1) {
		System.out.println("매개변수와 반환형이 존재하는 static 메서드");
		/*
		 * static 메서드 안에서는 static이 아닌 일반 field멤버 접근이 불가능하다
		 * why?
		 *   - 변수의 생성시점이 다르기 때문이다
		 *   - static 메서드는 프로그램 시작시 정적메모리 영역에 공간이 할당되는데,
		 *   이 때 static 변수도 함께 할당되기 때문에 static 변수는 static
		 *   메서드가 활용가능 (생성시점이 같다)
		 *   - 하지만, 일반 전역변수는 객체 생성시점에 메모리에 공간이 할당되므로
		 *   static 메서드에서 사용이 불가능하다
		 */
		return num1 * count;
		//스태틱 메서드 내부에서는 스태틱 변수만 이용 가능
	}
	
	public int method1(int num1) {
		return num1 * count;
		//이 코드가 실행될 시점에는 count 변수가 이미 메모리상에 저장되어 있기 떄문에 활용가능
	}
}
