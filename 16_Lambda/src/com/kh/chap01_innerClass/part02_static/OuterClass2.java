package com.kh.chap01_innerClass.part02_static;

public class OuterClass2 {
	private String str = "필드";
	private static String staticStr = "정적필드";
	
	/*
	 * 정적 내부 클래스
	 * 	 - 외부클래스가 로드되는 시점(생성시점 아님)에서 정적 내부클래스도 함께 static영역으로 저장공간을 할당받는다.
	 *		로드되는 시점: 클래스 임포트 할 때
	 * 	 - 외부클래스와 종속적이지 않다.
	 * 	 - 그럼 왜쓰냐?!?!!?! 하나의 클래스 파일에 다양한 클래스를 설계할 때 사용(DTO)
	 * 		여러개의 파일을 각각 관리하는 것보다 유지보수가 쉽다.
	 * 	 - 외부클래스와 무관하게 다른클래스에서도 이용할 내부클래스는 정적내부클래스로 사용(Builder)
	 */
	public static class staticInnerClass { // OuterClass2.staticInnerClass로 접근
		// 정적 내부 클래스 (보통 public 접근제한자를 사용)
		// 스태틱의 목적이 메모리 영역에 올려두고 재사용하기 위함이기 때문에 반드시 public이 필요함
		// 정적 내부 클래스는 외부 클래스와 서로 종속관계가 아니라서 생성을 외부클래스에서 하는게 아님
		int num = 100;
		static int num2 = 100;
		
		public void test() {
			//System.out.println(str); // 생성시기가 다름
			System.out.println(staticStr);
			System.out.println(num); // 일반메서드이기 때문에 메서드가 사용되는 시점에는 num이 이미 정의됨
			System.out.println(num2);
		}
		
		public static void sTest() {
			//System.out.println(str);
			System.out.println(staticStr);
			//System.out.println(num); // 생성시기가 다름
			System.out.println(num2);
		}
	}
}
