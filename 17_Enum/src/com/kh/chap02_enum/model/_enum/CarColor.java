package com.kh.chap02_enum.model._enum;

import java.util.Arrays;

// 결국 클래스파일로 컴파일 되긴 함
public enum CarColor {
	/*
	 * Enum -> Enumeration(열거)의 약자. 클래스내부의 상수값들을 열거하여 enum이라는 명칭을 사용
	 * 객체단위 상수값들을 간결하게 다루기 위한 클래스가 enum.
	 */
	BLACK(0){ // 익명구현객체 생성 방식
		@Override
		public void printTest() {
			System.out.println("검은색입니다.");
		}
	}, // public static final CarColor BLACK = new CarColor();
	RED(1){
		@Override
		public void printTest() {
			System.out.println("빨간색입니다.");
		}
	}, 
	WHITE(2) {
		@Override
		public void printTest() {
			System.out.println("흰색입니다.");
		}
	};
	// 묵시적(implied)으로 public static final CarColor가 붙어있다. 객체생성 완료된 상태.
	
	// 객체의 불변성이 손실될 수 있기 때문에 setter 메서드는 사용X
	private int color;
	private CarColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	// values() : enum 내부의 상수값들을 모아서 배열로 반환해주는 메서드
	// 언제쓰냐? BLACK자체에 주소값? ㄴㄴ해서 값을 0이나 "black"이런식으로 갖고있을때 BLACK을 찾을 수 있음
	// enum 내부의 필드값을 통해 enum을 찾을 수 있는 메서드
	public static CarColor valueOf(int color) {
		return Arrays.stream(values()) // values() : CarColor[]반환
			.filter(_enum -> _enum.color == color)
			.findFirst()
			.orElseThrow(() -> new RuntimeException("일치하는 컬러가 없습니다."));
	}
	
	// 필드값 기준으로 내가 원하는 상수를 찾는 방법
	// enum 안쓰고 Car 클래스에서 enum 방식으로 객체를 구현했다면? (옛날방식)
	public static CarColor valueOf2(int color) {
		switch(color) {
		case 0: return BLACK;
		case 1: return RED;
		case 2: return WHITE;
		default : throw new RuntimeException("일치하는 색이 없습니다.");
		}
	}
	
	public abstract void printTest();
}
