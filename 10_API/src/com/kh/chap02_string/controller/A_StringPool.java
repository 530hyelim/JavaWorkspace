package com.kh.chap02_string.controller;

public class A_StringPool {
	// pool: 자료형이 엄청 많이 모여있는 저장공간
	// 메모리 영역상의 문자열상수풀(자바버전에 따라서 스태틱 혹은 힙메모리 내에 존재)에 보관됨
	
	// String은 불변클래스(변하지 않는 클래스)
	// String은 기존에 담겨있던 값이 수정되는 순간, 원래 담겨있던 공간(주소값)에서 수정되지 않음
	// String은 새로운 값이 추가되는 순간 새로운 저장공간이 할당된다(new 객체생성과 같은 메커니즘)
	// 메모리 차지하는 비중이 커짐 => 그래서 StringPool이 생김
	
	// 문자열 상수 풀 (String constant pool)
	//   - 문자열 데이터가 담기는 영역으로, heap메모리 영역상에 고정적으로 할당되어있다(JDK7이상)
	//	 - 가비지 컬렉터가 주기적으로 수거해주지만 그 전에 메모리가 꽉 찰 가능성이 크다
	//   - stringBuilder, stringBuffer와 같은 대체제를 이용해 가변가능하게 할수있따
	
	public void method1() {
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1 == str2); // false(주소값비교)
		// new 키워드를 쓰는 순간 항상 힙메모리 영역에 저장됨
		System.out.println(str1.equals(str2)); // true
		
		// equals()와 hashCode()는 원래 Object클래스의 메서드
		// String 클래스에서 오버라이딩 한 것
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode()); // 같다
		// 해시코드 함수는 원래 주소값을 반환하는 함수인데,
		// 문자열 기준으로 연산을 해서 값을 반환하기 떄문에 String 클래스의 경우 같다
		// 상수풀의 주소값으로 사용하기 위해 오버라이딩 했다
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2)); // 다르다
		// 따라서 문자열의 저장 위치를 보고싶다면 System.identityHashCode() 함수를
		// 실행시키면 진짜 주소값을 알 수 있다
	}
}
