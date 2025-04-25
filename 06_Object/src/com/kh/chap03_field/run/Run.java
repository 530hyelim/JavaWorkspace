package com.kh.chap03_field.run;

import com.kh.chap03_field.model.vo.FieldTest1;
import com.kh.chap03_field.model.vo.FieldTest2;
import com.kh.chap03_field.model.vo.FieldTest3;

public class Run {
	public static void main(String[] args) {
		FieldTest1 ft1 = new FieldTest1();
		// 객체를 생성과 동시에 heap 메모리에 할당되므로
		// 필드를 초기화하지 않아도 JVM이 디폴트값으로 초기화
		// 따라서 private int global; == private int global = 0;
		//ft1.test(0);
		
		FieldTest2 ft2 = new FieldTest2();
		//ft2.pub = "z";
		
		FieldTest3 ft3 = new FieldTest3();
		System.out.println(ft3.sta); //객체생성 안해도 메모리에 이미 있기때문에
		System.out.println(ft3.PI); // 객체 생성할 필요가 없음
		
		//불필요한 메모리 낭비를 방지하기 위한
		//static 변수 사용 방법
		//저장위치 (클래스.변수명) 으로 접근 가능
		System.out.println(FieldTest3.sta);
		System.out.println(FieldTest3.PI);
		
		//static 메서드 사용 방법
		//클래스명.메세드명()
		FieldTest3.test();
	}
}
