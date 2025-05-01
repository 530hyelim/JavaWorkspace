package com.kh.chap02_string.controller;

public class A_StringPool {
	// pool: 해당 자료형이 엄청 많이 모여있는 배열
	// 메모리 영역상의 문자열상수풀(자바버전에 따라서 스태틱 혹은 힙메모리 내에 존재)에 보관됨
	
	// String은 불변클래스(변하지 않는 클래스)
	// String은 기존에 담겨있던 값이 수정되는 순간, 원래 담겨있던 공간(주소값)에서 수정되지 않음
	// String은 새로운 값이 추가되는 순간 새로운 저장공간이 할당된다(new 객체생성과 같은 메커니즘)
	// 메모리 차지하는 비중이 커짐 => 그래서 StringPool이 생김
	
	// 문자열 상수 풀 (String constant pool)
	//   - (리터럴로 선언된)문자열 데이터가 담기는 영역으로, heap메모리 영역상에 고정적으로 할당되어있다(JDK7이상)
	//	 - 가비지 컬렉터가 주기적으로 수거해주지만 그 전에 메모리가 꽉 찰 가능성이 크다
	//   - stringBuilder, stringBuffer와 같은 대체제를 이용해 가변가능하게 할수있따
	
	public void method1() {
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1 == str2); // false(주소값비교)
		// new 키워드(생성자)를 쓰는 순간 객체가 생성돼서 항상 힙메모리 영역에 저장됨
		System.out.println(str1.equals(str2)); // true
		
		// equals()와 hashCode()는 원래 Object클래스의 메서드
		// String 클래스에서 오버라이딩 한 것
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode()); // 같다
		// 해시코드 함수는 원래 주소값을 반환하는 함수인데,
		// 문자열 기준으로 연산을 해서 값을 반환하기 떄문에 String 클래스의 경우 같다
		// 상수풀의 주소값으로 사용하기 위해 오버라이딩 했다
		// 만약 오버라이딩 안했다면 다르게 나왔을 것
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2)); // 다르다
		// 따라서 문자열의 저장 위치를 보고싶다면 System.identityHashCode() 함수를
		// 실행시키면 진짜 주소값을 알 수 있다
	}
	
	public void method2() {
		String str1 = "hello"; //상수풀에 저장된 적이 없으므로 상수풀에 주소값 할당
		String str2 = "hello"; //상수풀에 저장된 데이터이므로 상수풀내의 주소값을 그대로 할당(얕은 복사)
		String str3 = "hello";
		
		str2 += "world"; //"helloworld"문자열이 상수풀에 있나 검사 후, 주소값 할당
		//문자열은 불변크래스이기때문에 "helloworld"라는 문자열을 기준으로 다시 한번 상수풀에 들어감
		//따라서 str1을 얕은복사 했음에도 불구하고 문자열 변경시 기존의 문자열이 바뀌지 않음
		
		//문자열을 리터럴로 선언
		System.out.println(str1 == str2); //true => 동일한 주소에 데이터가 저장
		//문자열은 객체이기 때문에 메서드를 사용할 수 있다
		//따라서 ==은 주소값을 비교하는 것

		/*
		 * 언제 상수풀에 저장되는가?
		 * 자바에서는 문자열 "리터럴"을 사용시 문자열리터럴을 상수풀에 보관한다
		 * 
		 * JVM 문자열상수풀 동작방식
		 * 1. 프로그램 실행 도중 문자열 리터럴을 만나면, 문자열 리터럴 값이 상수풀에 보관되어 있나 검사
		 *   (문자열 내부에 만들어놓은 intern 메서드로 검사를 진행)
		 * 2. 만약 상수풀에 저장된 리터럴이 아니라면, 문자열의 hashcode 값을 주소값으로 상수풀에 저장 => str1
		 *   (hashcode가 곧 상수풀의 주소값)
		 * 3. 만약 이미 상수풀에 저장되어 있던 문자열이라면 저장된 주소값을 반환시킨다 => str2
		 */
		
		System.out.println(str1.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str3));
		//똑같은 주소값을 갖기 때문에 identityHashcode도 같은 값을 가짐
		
		/*
		 * 자바에서 가장 많이 사용되는 객체가 String
		 * String이 메모리영역에서 차지하는 비중이 크기 때문에 메모리부족 이슈가 종종 발생
		 * 이 메모리 부족 이슈를 해결하기 위해 나온것이 문자열 상수풀
		 * 
		 * 단, 문자열 상수풀로도 감당이 불가능할 정도로 문자열 연산이 빈번한 경우,
		 * 문자열(String)보다는 문자열기반 가변클래스인(StringBuilder, StringBuffer)를
		 * 사용하는 것을 권장
		 */
		
	}
}
