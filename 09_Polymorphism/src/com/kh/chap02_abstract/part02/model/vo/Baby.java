package com.kh.chap02_abstract.part02.model.vo;

public class Baby extends Person implements Basic{
	
	public Baby() {
		super();
	}

	public Baby(String name, double weight, int health) {
		super(name, weight, health);
	}

	@Override
	public void eat() {
		// 아기는 밥을 먹으면 몸무게 3증가, 건강도 1증가
		setWeight(getWeight()+3);
		setHealth(getHealth()+1);
	}
	
	@Override
	public void sleep() {
		// 아기는 잠을 자면 건강도 3증가
		setHealth(getHealth()+3);
	}
}
