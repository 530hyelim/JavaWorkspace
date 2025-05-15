package com.kh.chap01_innerClass.part01_run;

import com.kh.chap01_innerClass.part01_instance.OuterClass;
import com.kh.chap01_innerClass.part02_static.model.vo.Member;

public class Run {
	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		//OuterClass.InnerClass inner = oc.new InnerClass();
		//inner.privateMethod();
		/* 
		   public으로 inner class를 만들면 이런식으로 생성이 가능하긴 함
		   하지만 목적 자체가 아우터클래스 안에서만 사용하고,
		   캡슐화 기능을 좀 더 강화하기 위해 사용되기 때문에 public 으로 안만듦
		   
		   만약 public으로 inner class를 만들었을 때, inner class 안에있는 public static 
		   변수에도 접근이 가능한가? 외부클래스명.내부클래스명.스태틱변수명 으로 접근 가능
		   구버전 자바에서는 불가능. 왜냐? 컴파일 되는 시각에 보통 static 키워드를 찾아서 메모리에 저장하는데
		   inner class에 static 키워드가 안붙어있으면 안에 안둘러보고 바로 넘어갔기 떄문에 도달 불가
		   => 따라서 통상적으로 이너클래스 안에서는 스태틱변수를 자주 사용하지 않는다.
		*/
		//oc.method();
		
		Member m = new Member
				.Builder() // 빌더 객체 생성
				.setId("alsrudals")
				.setName("민경민") // 세터함수로 빌더객체의 내부값 초기화(메서드 체이닝: 자기자신의 주소값을 반환하기 떄문에 가능)
				.setAge(30)
				.build(); // 빌더 내부의 값을 멤버 내부로 옮겨서 멤버객체를 반환
		/*
		 * 빌더클래스 이용시 장점
		 * 	 - 불필요한 생성자들을 제거
		 * 	 - 필드의 순서에 상관없이 객체 생성 가능
		 * 	 - 명시적인 메서드명으로 가독성 확보
		 * 	 - VO 클래스에 setter 메서드가 존재하지 않음으로써 불변성 유지 가능
		 * 	 - 올바른 값이 초기화 되었는지 build()를 통해 검증이 가능
		 * 	 - @builder 어노테이션도 사용 가능 => 함수명이 곧 변수명 (setX)
		 */
	}
}
