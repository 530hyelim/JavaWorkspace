package com.kh.chap03_wrapper.run;

public class Run {
	/*
	 * Wrapper 클래스
	 *   -> 기본자료형을 객체로 포장해주는 클래스
	 *   -> 기본자료형을 객체로 만들어서, 필요한 메서드를 호출할 수 있다
	 * 
	 * 기본 자료형 <--------------> Wrapper 클래스
	 * boolean					 Boolean
	 * char						 Character
	 * byte						 Byte
	 * short					 Short
	 * int						 Integer
	 * long						 Long
	 * float					 Float
	 * double					 Double
	 */
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(num1 == num2);
		//System.out.println(num1.equals(num2));
		//일반 자료형에는 메서드가 없으므로, 각 객체자료형의 메서드를 활용하고자 한다면
		//Wrapper클래스로 변환해야 한다
		
		//기본자료형 => Wrapper
		//Boxing (자동형변환)
		//대입연산자 기준으로 자료형이 다른데 상속관계가 아닌데도 불구하고 형변환이 이루어짐
		Integer i1 = num1;
		Integer i2 = num2;
		
		System.out.println(i1.equals(i2)); //오버라이딩 돼있어서 주소값비교X
		System.out.println(i1.hashCode()); //오버라이딩: 자기자신 그대로 반환
		System.out.println(i1.compareTo(i2)); //양수, 음수, 같으면 0 (i1 > i2 ?)
		//모든 래퍼 클래스에 구현되어 있음
		//a.compareTo(b) : a가 b보다 크면 1, b가 a보다 크면 -1, 같으면 0을 반환하는 함수
		//다른 클래스일 경우 메커니즘이 다를 수 있음(문자열간의 비교시 아스키코드표에 등록된 순서대로)
		
		//Wrapper => 기본자료형
		//Unboxing (양방향 자동형변환)
		int num3 = i1;
		int num4 = i2;
		System.out.println("=======================================");
		
		//기본자료형 <---> String
		//문자열을 기본자료형으로 파싱하는 방법들
		String str1 = "10";		// "10" => 10
		String str2 = "15.3";	// "15.3" => 15.3
		
		//변환하고자하는 자료형의 Wrapper 클래스를 이용하여 parse
		int i = Integer.parseInt(str1);
		System.out.println(i);
		//str1이 정수형태의 문자열이 아닌 경우 에러발생
		
		double d = Double.parseDouble(str2);
		System.out.println(i+d);
	}
}
