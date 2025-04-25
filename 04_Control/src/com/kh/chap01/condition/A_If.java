package com.kh.chap01.condition;

import java.util.Scanner;

public class A_If {
	/*
	 * 프로그램의 실행 순서
	 * 위 -> 아래, 왼 -> 오
	 * 
	 * 선택적으로 특정 라인을 실행시키고자 할 때 => 제어문 (if / switch)
	 * 반복적으로 실행해야 하는 코드 => 반복문
	 * 반복문 내부 흐름을 제어하는 경우 => 분기문
	 * 
	 * 제어문 내부에는 항상 조건문이 들어간다
	 * if (조건문): 조건식을 활용하여 true/false 값이 나오도록 설정하는 식
	 */
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		/*
		 * 단독 if문
		 * 
		 * [표현법]
		 * if(조건식) 조건식이 참일 때 실행할 코드 하나
		 */
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수다");
			System.out.println("양수다");
			System.out.println("양수다");
		} // {}: 코드 여러줄을 하나로 묶어서 실행하는 복합연산자
		if(num <= 0) System.out.println("양수가 아니다");
	}
	// if vs. 삼항연산자? 삼항연산자가 효율이 더 좋고 간결함
	
	public void method2() {
		/*
		 * if ~ else문
		 * 
		 * [표현법]
		 * if(조건식) {
		 *   조건식의 결과가 참이라면 실행할 코드들;
		 * } else {
		 *   조건식의 결과가 거짓이라면 실행할 코드들;
		 * }
		 */
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수다");
		} else {
			System.out.println("양수가 아니다");
		}
		// 단순히 조건 검사의 갯수로만 따져봤을 때 단순if문보다 효율이 올라간다
		
		// 비교적 간결한 삼항연산자와 구조는 비슷하지만
		// 삼항연산자는 값을 반환하는 용도로만 사용됨 (사용처가 제한적)
		// if ~ else 문은 다른 코드들을 추가적으로 실행할 수 있음
	}
	
	// 중첩삼항연산자와 비슷
	public void method3() {
		/* 
		 * if ~ else if 문
		 * 같은 비교대상으로 여러개의 조건을 제시해야하는 경우 사용
		 * 
		 * [표현법]
		 * if(조건식1) 조건식1이 참이라면 실행할 코드
		 * else if(조건식2) 조건식2가 참이라면 실행할 코드
		 * else if(조건식3) 조건식3이 참이라면 실행할 코드..
		 * ...
		 * [else 위 조건식의 결과들이 모두 거짓이라면 실행할 코드] 생략가능
		 */
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수다");
		} else if(num == 0) {
			System.out.println("0이다");
		} else /* else if(num < 0) */ { // 조건검사 불필요한데 또하니까 비효율적
			System.out.println("음수다");
		} // 위 조건들은 무조건 한번만 실행된다 (조건식이 둘 다 참일경우 위에있는 코드만 실행됨)
	}
	
	public void method4() {
		// 사용자가 입력한 값을 가지고 어린이/청소년/성인/어르신 출력
		// 어린이(13세 이하), 청소년(13세 초과 19세 이하),
		// 성인(19세 초과 60세 이하), 어르신(60세 초과)
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		if(age <= 13) {
			System.out.println("어린이");
		} else {
			if(/* age > 13 && */ age <= 19) {
				System.out.println("청소년");
			} else {
				if(age <= 60) {
					System.out.println("성인");
				} else {
					System.out.println("어르신");
				}
			}
		}
		// 가독성이 너무 떨어짐
		
		// if ~ else if 문으로 변경
		if(age <= 13) {
			System.out.println("어린이");
		} else if(/* age > 13 && */ age <= 19) {
			System.out.println("청소년");
		} else if(age <= 60) {
			System.out.println("성인");
		} else {
			System.out.println("어르신");
		}
		// 복합실행문도 하나의 영역으로 간주된다
		// 따라서 if문 블럭 안에서 선언한 변수는 if문 안에서만 사용 가능
	}
	
	public void method5() {
		// 성별과 이름을 입력받아, 이름과 남자인지 여자인지를 출력
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		String result = "";
		// 특정 상황에서 result값이 초기화되지 않는다면 컴파일 에러가 뜬다
		// 자바는 컴파일 에러를 잘 잡지만 다른 언어는 그러지 않을 수 있다
		// 따라서 변수는 항상 기본값으로 초기화 시키는게 에러 발생률이 낮아진다
		if(gender == 'm' || gender == 'M') {
			result = "남자";
		} else if(gender == 'f' || gender == 'F'){
			result = "여자";
		} else {
			result = "중성";
		}
		System.out.println(name+"님은 "+result);
	}
	
	public void method6() {
		// 사용자에게 이름을 입력받고, 이 이름이 본인 이름과 일치하는지 비교
		System.out.print("본인 이름 : ");
		String name = sc.nextLine();
		
		// 자바에서는 문자열로 동등비교연산자를 못쓴다
		// String은 참조자료형이라서 동등비교시 정상적으로 비교가 안된다
		// name에 담겨있는 값은 서혜림을 저장하고 있는 메모리 주소값도 포함
		
		// 반면, primitivie type의 객체는 constant pool의 특정한 값을 참조하는 변수
		// => 결국 리터럴로 선언시 constant pool내의 동일한 주소를 비교
		if(name == "서혜림") {
			System.out.println("서혜림님 방가방가~");
		} else {
			System.out.println("너 누구얏");
		}
		
		// 문자열 동등비교를 위한 메서드
		// 문자열.equals(비교문자열) => boolean 값을 반환
		if(name.equals("서혜림")) {
		//if("서혜림".equals(name)) {
			System.out.println("서혜림님 방가방가~");
		} else {
			System.out.println("너 누구얏");
		}
	}
}
