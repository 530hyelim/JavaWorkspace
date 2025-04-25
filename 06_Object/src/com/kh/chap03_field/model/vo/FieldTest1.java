package com.kh.chap03_field.model.vo;

public class FieldTest1 {
	/*
	 * 변수 구분
	 *   - 전역변수(global): 클래스 영역 바로 아래에 선언하는 변수들
	 *   				  클래스 내 어디서든 사용 가능
	 *   - 지역변수(local): 클래스 영역 내에서 특정영역({})에 선언한 변수
	 *   				 선언한 지역에서만 사용 가능(메서드, if, ...)
	 *   -> 값을 보관하는 영역 자체가 다르다
	 *   
	 * 1. 전역변수
	 *   - 필드 == 인스턴스 변수 == 멤버변수
	 *     (메모리 영역 내의)
	 *     생성시점 : 객체가 메모리에 할당되면 함께 생성
	 *     소멸시점 : 객체가 소멸할 때 함께 소멸 => 객체와 라이프사이클이 같음
	 *   
	 *   - 클래스변수 == static 변수 
	 *     생성시점 : 프로그램 시작과 동시에 static 영역에 메모리 할당
	 *     소멸시점 : 프로그램 종료 시 => 클래스 변수의 라이프사이클은 프로그램과 함께한다
	 *     (공유해서 사용하는 자원들을 보관할 때 사용)
	 *   
	 * 2. 지역변수
	 * 	  생성시점 : 특정영역({})이 실행될 때 (stack 메모리에 저장공간이)할당
	 * 	  소멸시점 : 특정구역이 종료될 때 소멸 => block과 라이프사이클을 함께한다
	 */
	private int global;
	
	public void test(int num) {
		int local; //지역변수는 전역변수와 다르게 접근제한자를 쓰지않는다
		
		if(true) {
			int a = 0;
		}
		// test 메서드를 사용하기 위해, FieldTest1 객체를 생성하게 되면
		// global 필드에는 항상 값이 초기화된다 (JVM)
		System.out.println(global); 
		// System.out.println(local); 지역변수를 사용할땐 항상 초기화해줘야함 (선언만 하면 컴파일에러)
		// 지역변수는 heap메모리에 할당되는것이 아니기 때문에 JVM이 대신 안해줌
		// System.out.println(a); 컴파일에러: a는 if영역 안에서 선언했기 때문에 그 안에서만 사용가능
		System.out.println(num); //무조건 매개변수 지정했으면 그 자료형에 맞는 값을 넘겨주어야 되기 때문에
		// 초기화해주지 않아도 컴파일에러가 없다 (사실 함수 호출하는 곳에서 초기화 한것과 다름없음)
		
		FieldTest2 ft2 = new FieldTest2();
		System.out.println(ft2.df);
		System.out.println(ft2.pro);
		System.out.println(ft2.pub);
		// 같은패키지에서는 default, protected 접근가능
	}
}
