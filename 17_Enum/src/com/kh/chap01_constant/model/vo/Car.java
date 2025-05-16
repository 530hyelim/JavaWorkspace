package com.kh.chap01_constant.model.vo;

public class Car {
	private String name;
	private int carColor;
	
	/*
	 * Car 클래스의 carColor의 색깔을 관리할 상수값
	 * 0: Black, 1: Red, 2: Blue, ...
	 */
	public static final int BLACK = 0;
	public static final int RED = 1;
	public static final int BLUE = 2;
	
	// 상수의 단점 1: 의미없는 값으로 상수를 관리
	//	 - 변수명을 통해 의미를 확인할 수 있을 뿐, 값 자체에 의미가 없다.
	//	 - 상수가 많아질 수록 개발자 입장에서 관리가 힘들다.
	public static final int GREEN = 3;
	public static final int YELLOW = 3;
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", carColor=" + carColor + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCarColor() {
		return carColor;
	}
	public void setCarColor(int carColor) {
		this.carColor = carColor;
	}
	
	// 값에 대한 검증
	private Color color;
	public void setColor(Color c) {
		this.color = c;
	}
}
