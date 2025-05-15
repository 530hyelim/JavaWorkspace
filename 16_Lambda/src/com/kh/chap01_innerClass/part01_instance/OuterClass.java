package com.kh.chap01_innerClass.part01_instance;

public class OuterClass {
	private String str = "외부클래스 필드";
	private static String staticStr = "외부클래스 스태틱 필드";
	private InnerClass inner;
	
	public OuterClass() {
		inner = new InnerClass(); // setter함수를 이용할 수도 있음
	}
	
	// 인스턴스(익명)클래스 == 인스턴스 변수와 같은 위치에 선언한 클래스
	/*
	 * 외부 클래스에서만 생성하여 사용하는 객체를 선언할 때 보통 사용
	 * 외부클래스의 보조적인 역할의 클래스를 정의한다.
	 * ex) HashMap 내부의 Node, keySet, EntrySet
	 * 		컬렉션 클래스들의 보조적인 역할을 하는 클래스들
	 * 인스턴스 내부 클래스들은 반드시 "외부 클래스"에 의해 생성됨
	 */
	/*public*/private class InnerClass {
		// private 접근제한자는 내부클래스에스만 사용가능
		// 외부클래스는 다른곳에서 사용하기 위해 만들어졌기 때문에 앞뒤가안맞음
		int num = 100; // 필드
		static int sNum = 100; // 정적변수 선언 가능 but 자주 사용하지 않음
		
		/*public*/private void privateMethod() {
			System.out.println(num);
			System.out.println(sNum);
			System.out.println(str); // 외부클래스의 private 필드 접근 가능
			System.out.println(staticStr); // 외부클래스의 정적 필드 접근 가능
			
		}
	}
	
	public void method() {
		//num = 100;
		inner.num = 100;
		inner.privateMethod();
	}
	
}
