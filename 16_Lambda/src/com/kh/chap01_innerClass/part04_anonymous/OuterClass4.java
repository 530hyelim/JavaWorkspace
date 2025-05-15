package com.kh.chap01_innerClass.part04_anonymous;

public class OuterClass4 {
	/*
	 * 익명 내부 클래스
	 * 	 - 이름이 없는 내부 클래스
	 * 	 - 지역 내부클래스에서 불필요해 보이는 코드를 없애고, 간결화 시킨 방법
	 */
	public Runnable getRunnable() {
		// 클래스 선언 X
		// 클래스 선언(메서드 작성 영역) + 객체생성을 합쳐서 표현
		// 람다식 이전에 자주 사용
		return new Runnable() { // 인터페이스로는 객체 생성 불가
			private int num = 1;
			// Runnable 인터페이스의 추상메서드를 구현하는 영역
			@Override
			public void run() {
				System.out.println("스레드 실행중..");
			}
		};
	}
}
