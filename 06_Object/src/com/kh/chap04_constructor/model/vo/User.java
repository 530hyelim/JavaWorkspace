package com.kh.chap04_constructor.model.vo;
//★★★생성자★★★

public class User {
	//필드부
	private String userId;
	private int age;
	private char gender;
	
	//생성자부
	/*
	 * 생성자 작성방법
	 * 접근제한자 클래스명(매개변수) {
	 *   //생성자를 통해 객체 생성시 초기화시킬 필드값들을 나열
	 * }
	 * 항상 생성된 객체의 주소값을 반환한다
	 * 
	 * 작성목적
	 * 1. 객체를 생성하기 위한 목적
	 * 2. 객체 생성과 객체 내부의 필드값을 초기화할 목적
	 * 
	 * 주의사항
	 * 1. 클래스명과 동일하게 작성해야 한다. (case sensitive)
	 * 2. 반환형이 존재하지 않는다.
	 * 3. 여러개 생성이 가능하지만, 매개변수가 중복되면 안된다.
	 * 4. 매개변수 생성자를 명시적으로 작성하게 되면 jvm이 기본생성자를
	 * 	  자동으로 만들어주지 않는다.
	 */
	
	//기본생성자 : 매개변수에 아무것도 없는 경우
	public User() {
		//객체를 생성할 목적으로만 사용
		//이 기본생성자는 작성하지 않아도 오류가 나지 않음
		//JVM이 컴파일 과정에서 User.class에 자동으로 만들어줬기 때문에 문제가 없던 것
		//단, 내가 생성자를 한개 이상 만들어 둔 경우에는 JVM이 자동생성해주지 않는다
		//생성자를 여러개 만들수도 있음
	}
	
	public User(String userId, int age, char gender) {
		//세터는 한번에 한 데이터만 초기화 할 수 있는데
		//매개변수를 여러개 추가해서 한번에 초기화 가능
		this.userId = userId;
		this.age = age;
		this.gender = gender;
	}
	public User(String userId, int age) {
		//세터는 한번에 한 데이터만 초기화 할 수 있는데
		//매개변수를 여러개 추가해서 한번에 초기화 가능
		this.userId = userId;
		this.age = age;
		this.gender = gender;
	}
	
//	public static void main(String[] args) {
//		User u = new User("hh", 15);
//		System.out.println(u.gender);
//	}

	//메서드부(기능담당)
}
