package com.kh.chap02_encapsulation.model.vo;
//가장 중심이 되는 클래스는 value object(vo) 패키지에 만든다

public class Student {
	// 필드 == 멤버변수 == 인스턴스변수 == 속성
	private String name;
	private int age;
	private double height;
	
	// 메서드부
	// 각 객체의 기능을 구현
	// [표현법]
	// 접근제한자 반환형 메소드명(매개변수) {실행할코드;}
	// 매개변수: 데이터를 전달받을 변수
	// 접근제한자 public, private, +2개 더 있음
	// 메서드가 끝나면 원래 메서드를 호출한 자리로 돌아가는데 그때 데이터1개를 반환할 수 있음
	// 그 변수의 자료형을 반환형(void, int, ...)
	// void: 아무것도 반환 안할때
	public void study() { //blocking
		System.out.println(name+"이 공부합니다");
		//this.name 가능한데 안쓰는 이유?
		//JVM이 name찾을때 첫번째로 지역변수를 먼저 찾아본다 => (현재객체의)전역변수 찾아본다
		//따라서 this.name이 디폴트기 때문에 필요없음
	}
	
	// setter 메서드
	public void setName(String name) { //변수명 = 필드명, 똑같은 자료형이 관례
		//이 코드를 실행시킬수 있는 보호장치용 소스코드를 작성 가능 (ex:로그인)
		//구현 안하는 경우도 있음, 수정될 필요 없는 필드는 구현안해도됨
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	// getter 메서드
	// 객체 내부의 필드값을 반환해주는 메서드
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getHeight() {
		return height;
	}
	
	// 모든 필드값을 하나의 문자열로 합쳐서 반환하는 메서드
	public String information() {
		return name+"님의 나이는 "+age+"살이고, 키는 "+height+"cm입니다.";
	}
	
}
