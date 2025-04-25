package com.kh.chap01_abstraction.run;

import com.kh.chap01_abstraction.model.vo.Student;

public class Run {
	// main + ctrl + spacebar + enter
	public static void main(String[] args) {
		/*
		 * 1.객체지향언어: 객체를 중심으로 객체간의 상호작용을 통해 작동하는 프로그래밍 방식
		 * 2.객체: 클래스를 통해 heap 메모리에 저장공간이 할당된 데이터
		 * 3.구현하고자 하는 프로그램상의 목적에 맞는 객체를 만드는 방법
		 * 4.클래스는 객체의 속성(변수/필드)과 기능(메서드)을 담아내는 그릇
		 * 5.추상화 & 캡슐화 과정이 필요
		 *   - 추상화: 내가 구현하고자 하는 프로그램의 목적에 맞는 객체를 선정 후, 그 객체들이
		 *     가지고 있을 핵심적인 역할의 속성과 기능만 남기는 행위
		 */
		
		// 추상화

		// 홍길동 학생 객체 만들기
		Student hong = new Student(); // new + 생성자 => new Student객체는 힙메모리에 저장
		// hong변수는 new Student객체의 주소값을 보관
		hong.name = "홍길동";
		hong.age = 20;
		hong.height = 180.5; //구조체의 약점 (다른위치에서 객체의 정보를 마음대로 조작 가능)
		
		Student tae = new Student();
		tae.name = "안태형";
		tae.age = 26;
		tae.height = 175.0;
		
		tae.fight(hong);
		
		System.out.println(hong); //풀 클래스명 + 주소값
		System.out.println(tae.name); //지금같은 경우에는 필드가 public이라서 가능
	}
}
