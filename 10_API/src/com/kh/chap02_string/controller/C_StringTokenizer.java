package com.kh.chap02_string.controller;

import java.util.StringTokenizer;

public class C_StringTokenizer {
	
	//StringTokenizer: 문자열을 구분자를 기준으로 토큰단위로 분리시키는 클래스
	//쉬운 방법은 아니지만 메모리적으로 효율적임
	public void method() {
		String str = "Java,Oracle,JDBC,HTML,Server";
		
		//쉬운방법: 구분자를 통해 문자열을 분리시키는 방법
		//1. String의 split()메서드를 이용하는 방법
		//	 문자열.split(구분자): 구분자를 제외한 String[] 형태로 반환
		//	 너무 큰 문자열을 구분할 경우, 메모리 부족 에러가 발생할 수 있다
		String[] arr = str.split(","); //["Java","Oracle","JDBC","HTML","Server"]
		
		//6개의 주소값을 사용. 자를 길이가 적절할 때만 사용
		for (String s : arr) {
			System.out.println(s);
		}
		
		System.out.println("==================================");
		//사용방법이 복잡하지만 효율적으로 메모리 사용하는 방법
		//2. StringTokenizer 클래스를 이용하는 방법
		//	 StringTokenizer stn = new StringTokenizer(문자열,구분자);
		StringTokenizer stn = new StringTokenizer(str, ",");
		System.out.println("분리된 문자열의 갯수: "+stn.countTokens()); //.length()와 같은함수
		
		//stn.countToken(): 현재 남은 토큰의 갯수를 반환하기 때문에 일반 반복문에서 사용 불가
//		for(int i = 0; i < stn.countTokens(); i++) {
//			System.out.println("현재 토큰의 문자열: "+stn.nextToken());
//		}
		//nextToken()으로 꺼내서 사용할 때마다 countToken()값이 업데이트 되기 떄문
		//=>남아있는 토큰의 값이 0보다 클 때까지 데이터를 꺼내서 사용하면 됨 or 새로운 지역변수에 값을 넣고 사용
//		while(stn.countTokens() > 0) {
//			System.out.println("현재 토큰의 문자열: "+stn.nextToken());
//		}
		
		//stn.hasMoreTokens() => 토큰갯수가 0보다 큰지 확인하는 함수
		while(stn.hasMoreTokens()) { //boolean 값을 반환
			System.out.println("현재 토큰의 문자열: "+stn.nextToken());
		}
		//한번 쓰면 재사용이 불가능하기 때문에 소모성 데이터이다
		//문자열 객체를 각각 따로 생성하지 않기 때문에 메모리 효율적인 것
		//한번에 하나씩 String값을 반환하기 때문에 문자열을 미리 생성해두지 않아서 메모리효율 굿
	}
}
