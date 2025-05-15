package com.kh.chap02_lambda.part01_basic;

import com.kh.chap02_lambda.model.functional.LambdaTest1;

public class Lambda { // 클래스 X 표현식 O
	/*
	 * 함수형 프로그래밍과 람다식은 밀접한 관련이 있다.
	 * 자바: 객체지향 방식으로 개발 (class로만 작동. 항상 클래스 내부에 메서드가 작성돼있어야 함)
	 * 람다: 클래스 내부의 메서드가 클래스 밖으로 빠져나오는 형태
	 * 함수형 프로그래밍(값 자체로 반환되기도 하고, 함수 자체를 매개변수로 넘길 수도 있음)
	 * 을 지원하기 위해 자바는 람다를 채택
	 * 
	 * 함수형 프로그래밍(FP)
	 * 	 - 함수를 기반으로 코드를 작성하고 함수를 호출하여 동작하는 프로그램을 만드는 방식
	 *	   즉, 클래스 없이 함수만 작성하여 동작하는 프로그램을 만든다.
	 *	 - 객체지향 프로그래밍에 비해서 작성해야하는 코드의 수가 줄어든다.
	 * 
	 * 객체지향 프로그래밍(OOP)
	 * 	 - 객체를 기반으로 객체간의 상호작용을 통해 동작하는 프로그램을 만드는 방식
	 * 	 - OOP에서는 만들어야 하는 기능(함수)이 있는 경우, 반드시 클래스를 먼저 만들고, 클래스 내부에
	 * 	   함수(메서드)를 추가해야 한다.
	 * 
	 * 람다(표현)식: Lambda Expression
	 * 	 - 자바에서 함수형 프로그래밍을 지원하기 위해 JDK8버전부터 추가된 기능
	 * 	 - 함수이지만, 함수 이름이 없는 "익명함수"처럼 사용된다.
	 * 	 - 함수의 작성방식에서 불필요한 부분을 걸러낸 후, 간결하게 표현한 표현식
	 * 
	 * @@@람다식은 익명 내부클래스의 간결한 대체 문법임@@@
	 *  - 코드의 간결성 & 가독성 향상
	 *  - 함수형 인터페이스(e.g. Runnable)
	 *  - 일급함수의 특징: 함수가 값으로써 전달
	 *  - 기본 문법: (매개변수) -> {실행문}
	 *  
	 * 일반메서드 vs. 람다식
	 * 1. 일반메서드(함수)
	 * 		int add(int x, int y) {
	 * 			return x + y;
	 * 		}
	 * 2. 람다식
	 * 		(x, y) -> {
	 * 			return x + y;
	 * 		};
	 * 		(x, y) -> x + y;
	 */
	public static void main(String[] args) {
		LambdaTest1 lambda1 = new LambdaTest1() {
			@Override
			public int add(int x, int y) {
				return x + y;
			}
		}; // 익명내부클래스
		int result = lambda1.add(1, 9);
		System.out.println(result);
		
		/*
		 * LambdaTest1 인터페이스에 들어갈 객체는 반드시 LambdaTest1 인터페이스를
		 * 상속받아, 추상메서드를 구현한 클래스여야 한다.
		 * 익명 내부 클래스의 문법처럼 이름없는 클래스의 형태로 객체를 생성해야 하지만, 불필요한
		 * 코드작성을 줄이는 방식으로 간소화되었다.
		 * 
		 * 함수형 인터페이스는 고정적으로 1개의 추상메서드만 보관하고 있으므로, 구현해야할 함수의 이름,
		 * 반환형, 매개변수의 자료형들은 생략이 가능.
		 * 
		 * 참고: (x, y) -> {return x+y;}; //이거 함수처럼 생겼지만 객체임
		 */
		LambdaTest1 lambda2 = (x, y) -> {return x+y;};
		result = lambda2.add(5, 5);
		System.out.println(result);
	}
}
