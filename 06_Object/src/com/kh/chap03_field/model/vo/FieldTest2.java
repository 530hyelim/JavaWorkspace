package com.kh.chap03_field.model.vo;

public class FieldTest2 {
	/*
	 * 접근제한자 //클래스 다이어그램 상 표기법
	 * (+)public => 어떤 패키지의 클래스에서든 접근 가능하도록 설정
	 * (#)protected => 같은 패키지 내에서만 사용하도록 설정
	 *    다른 패키지인 경우 상속받은 클래스에서도 추가로 접근가능하도록 할 때 설정
	 * (~)default => 같은 패키지 내에서만 사용하도록 설정
	 *    예약어아님. 걍 안쓰면 디폴트임
	 * (-)private => 같은 클래스에서만 접근 가능하도록 설정
	 */
	public String pub = "public";
	protected String pro = "protected";
	String df = "default";
	private String pri = "private";
}
