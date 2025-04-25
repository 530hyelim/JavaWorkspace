package com.kh.chap01_abstraction.model.vo;

class Student2 {
	//가능
	//public은 하나의 파일에 하나만 존재할 수 있음. import도 public 클래스만 됨
}

public class Student {
	// 1. 속성 / 필드부 (필드, 멤버변수, 인스턴스 변수)
	public String name;
	public int age;
	public double height;
	
	// 2. 생성자 / 생성자부 (생략가능)
	
	// 3. 기능 / 메서드부
	// 클래스의 메서드들은 className.메서드명 상태로 static 영역의 method area에 저장됨
	// 실제 heap메모리에는 각 필드들과 메서드의 주소값(참조값)이 저장됨
	// 객체마다 계속 생기면 메모리 낭비가 심해져서
	public void study() {
		System.out.println("공부를 합시다");
	}
	
	public void fight(Student s) { //매개변수???로 주소값 얕은복사
		//현재 생성된 객체: this(항상 주소값을 보관). 메서드를 호출한 객체의 주소값
		String str = this.name + "학생과 " + s.name + "학생이 싸웁니다";
		System.out.println(str);
	}
	
}
