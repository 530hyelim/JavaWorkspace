package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {
		
	}
	
//	public String afterToken(String str) {
//		String[] arr = str.split(" ");
//		String result = "";
//		
//		for(String s : arr) {
//			result = result.concat(s);
//		}
//		return result;
//	}
	
//	public String afterToken(String str) {
//		String[] arr = str.split(" ");
//		//System.out.println(arr.toString()); //주소값
//		
//		char[] c = new char[arr.length];
//		for(int i = 0; i < arr.length; i++) {
//			c[i] = arr[i].charAt(0);
//		}
//		//String 클래스에 valueOf(String[]) 메서드가 따로 없기때문에
//		//valueOf(Object x) 함수가 실행돼서 자꾸 주소값이 반환됨
//		//따라서 String[]를 char[]로 변경해서 valueOf(char[])함수를 사용
//		return String.valueOf(c);
//	}
	
	public String afterToken(String str) {
		StringTokenizer stn = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		while(stn.hasMoreTokens()) {
			sb.append(stn.nextToken());
		}
		return sb.toString();
	}
	
	public String firstCap(String input) {
		// 'a' --> 알바뱃의 개수만큼 더해주기 'A'
		// 'A' --> 첫글자가 이미 대문자인지 확인 후 변환
		//return input.toUpperCase().charAt(0)+input.substring(1);
		String result = input //메서드 체이닝 이용
				.substring(0,1)
				.toUpperCase()
				.concat(input.substring(1));
		return result;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		for(char c : input.toCharArray()) {
			if (c == one) count++;
		}
		return count;
	}
}
