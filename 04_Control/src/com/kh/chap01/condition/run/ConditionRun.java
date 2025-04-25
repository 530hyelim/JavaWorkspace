package com.kh.chap01.condition.run;

import com.kh.chap01.condition.A_If;
import com.kh.chap01.condition.B_Switch;

public class ConditionRun {
	public static void main(String[] args) {
		A_If ai = new A_If();
		//ai.method6();
		// 메서드를 하나만 실행하게 되면 버퍼도 함께 비워짐
		String a = "서혜림";
		String b = "서혜림";
		System.out.println(a == b); //true
		System.out.println(a == "서혜림");
		// sc.nextLine()으로 생성되는 문자열 객체가 heap영역에 저장되나???????
		
		B_Switch bs = new B_Switch();
		bs.method2();
	}
}
