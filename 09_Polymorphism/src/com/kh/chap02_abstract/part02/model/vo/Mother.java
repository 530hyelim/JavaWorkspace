package com.kh.chap02_abstract.part02.model.vo;

public class Mother extends Person implements Basic{
	
	public Mother() {
		super();
	}

	public Mother(String name, double weight, int health) {
		super(name, weight, health);
	}

	@Override
	public void eat() {
		//엄마가 밥을 먹으면 몸무게가 10증가, 건강도는 10감소
		setWeight(getWeight()+10);
		setHealth(getHealth()-10);
	}
	
	@Override
	public void sleep() {
		//엄마가 잠을 자면 건강도가 10증가
		setHealth(getHealth()+10);
	}
}
