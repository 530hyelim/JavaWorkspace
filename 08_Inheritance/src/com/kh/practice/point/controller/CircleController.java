package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x , int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		double result = Math.PI * c.getRadius() * c.getRadius();
		return "면적 : " + c/*.toString()*/ + " / " + result;
	}
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		double result = Math.PI * c.getRadius() * 2;
		return "둘레 : " + c/*.toString()*/ + " / " + result;
	}
}
