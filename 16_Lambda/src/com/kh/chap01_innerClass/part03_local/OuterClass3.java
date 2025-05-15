package com.kh.chap01_innerClass.part03_local;

public class OuterClass3 {
	private String str = "필드";
	private static String staticStr = "정적필드";
	
	// LocalInnerClass를 바로 반환하지 못하는 이유
	// 지역내부클래스는 메서드가 호출 되어야지 참조가 가능하기 때문ㅇ
	// 어차피 반환 못하니까 익명내부클래스로 만들어야징~ (part04)
	public Runnable getRunnable(int num) {
		// 지역 내부 클래스(에 대한 참조는 메서드가 끝나면 사라짐)
		// 지역변수와 동일한 라이프사이클을 가지고있음.
		// 메서드가 시작될 때 스택 메모리에 쌓였다가 그 블럭 안에서만 생성주기가 돌아가고
		// 메서드가 끝나서 스택 메모리에서 제거되면 함께 사라짐.
		/*
		 * 지역 내부 클래스
		 * 	 - 지역 변수처럼 메서드 내부에서 클래스를 정의하여 사용하는 것
		 * 	 - 메서드 안에서만 사용가능하며, 메서드가 호출될 때 생성된다.
		 * 	 - 지역내부클래스 안에서 사용되는 지역변수는 "상수"(final)처럼 취급된다.
		 * 		(메모리 효율성)
		 * 
		 * 메모리 복습
		 * 	 - 메서드 호출 시 스택에는 메서드프레임이 쌓인다.
		 * 	 - 메서드 프레임 내부에는 지역변수를 위한 저장공간이 할당
		 * 	 - 메서드 종료시에는 메서드프레임이 제거되면서 지역변수의 저장공간도 함께 소멸된다.
		 * 
		 * Static키워드가 붙은 변수는 static메모리 영역에 저장공간이 할당
		 * 	 - static final(상수) -> static 메모리 내부의 constant pool에 저장공간이 추가
		 * 	 - final 키워드만 붙은 변수 -> " (하지만 사용하지 않으면 수거하게끔 설계되어 있음)
		 */
		int local = 1;
		// 지역변수는 지역내부클래스에서 사용되는 경우, final 예약어가 붙은 것처럼 취급된다.
		// 이유는, stack메모리에서 지역변수의 저장공간이 소멸된 후, 참조를 유지하기 위해
		
		class LocalInnerClass implements Runnable {
			private int innerNum = 10;
			
			@Override
			public void run() {
				System.out.println(local);
				// 메서드 소멸시 지역변수의 저장공간도 함께 소멸
				// local = 2;
				// 지역변수(local)은 final 예약어가 없더라도 지역내부클래스 안에서 
				// 상수처럼 취급되기 때문에 값 변경이 불가능
				System.out.println(num);
				System.out.println(innerNum);
				System.out.println(str);
				System.out.println(staticStr);
			}
		}
		return new LocalInnerClass();
	}
}
