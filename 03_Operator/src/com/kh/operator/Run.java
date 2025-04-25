package com.kh.operator;

public class Run {
	public static void main(String[] args) {
		B_Logical b1 = new B_Logical(); 
		// 메서드를 여러번 활용하기 위해 B_Logical이라는 자료형의 객체를 하나 만들고 있는 것이다
		//b1.method3();
		C_InDecrease ci = new C_InDecrease();
		//ci.method1();
		G_Triple gt = new G_Triple();
		gt.method2();
	}
}
