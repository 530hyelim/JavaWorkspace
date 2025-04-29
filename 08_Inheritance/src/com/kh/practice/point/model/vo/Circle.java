package com.kh.practice.point.model.vo;

public class Circle extends Point{
	private int radius;
	
	public Circle() {
		super();
	}
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + radius;
		//super 객체가 변수에 담겨있으면 toString() 생략가능하지만
		//super 그 자체로는 식별자이기 때문에 생략이 불가능하다
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
}
