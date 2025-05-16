package com.kh.chap01_constant.model.vo;

// 자동차의 색에대한 상수값을 관리할 클래스
public class Color {
	public static final Color BLACK = new Color(0, "black");
	public static final Color RED = new Color(1, "red");
	public static final Color WHITE = new Color(2, "white") {
		// 익명 객체 생성 방식
		// 부모클래스(Color)에 있는 메서드 오버라이딩도 가능
		@Override
		public void method() {
			System.out.println("저는 흰색 메서드 입니다.");
		}
	};
	
	private int color; // 0, 1, 2
	private String color2; // black, red, white
	
	private Color(int color, String color2) {
		this.color = color;
		this.color2 = color2;
	}
	
	// 추상메서드로 만들어서 강제구현도 시킬 수 있음
	public void method() {
		System.out.println("상수");
	}
	
	// 단점: 코드중복, 관리해야 할 상수가 많아질수록 관리가 어려워짐
	// => 간결화 시킨 것이 Enum(자바에서 제공하는 클래스)
}
