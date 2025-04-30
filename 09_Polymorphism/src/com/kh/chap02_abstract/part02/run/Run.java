package com.kh.chap02_abstract.part02.run;

import com.kh.chap02_abstract.part02.model.vo.Baby;
import com.kh.chap02_abstract.part02.model.vo.Basic;
import com.kh.chap02_abstract.part02.model.vo.Mother;
import com.kh.chap02_abstract.part02.model.vo.Person;

public class Run {
	public static void main(String[] args) {
		Basic b; //= new Basic();
		b = new Mother("오애순",50,50); //업캐스팅 되는중~
		Basic b2 = new Baby("양금명",30,50);
		
		b.eat();
		//b.sleep(); 내부적으로는 구현되어 있겠지만 sleep()함수는 Basic이 아닌
		//Person 추상클래스 내에 위치해있기 때문에 접근이 불가능하다
		((Mother)b).sleep();
		b2.eat();
		((Baby)b2).sleep();
		((Person)b2).sleep(); //업캐스팅 되는중~
		
		System.out.println(b);
		System.out.println(b2);
	}
}
