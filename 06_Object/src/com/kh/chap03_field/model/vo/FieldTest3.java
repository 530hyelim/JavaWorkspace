package com.kh.chap03_field.model.vo;

public class FieldTest3 {
	public static String sta = "static 변수";
	/*
	 * static : 정적인, 고정된 (바뀌지 않는)
	 * 스태틱 키워드는 특정 변수나 메서드를 스태틱 메모리 영역에 고정시켜둔다.
	 * 따라서, 자주 사용하는 변수나 메서드를 스태틱으로 관리하여 메모리 영역에
	 * 고정시켜두고 사용하면 효율이 좋고, 가끔 사용되는 변수를 스태틱 영역에
	 * 보관하게 되면 효율이 좋지 않다.
	 */
	/*
	 * 상수필드
	 * public static final 자료형 변수명 = 값;
	 * 한 번 저장된 값을 고정해서 쓰기 때문에 무조건 초기화를 해줘야 하며,
	 * static변수는 보통 값이 변경돼서는 안되기 때문에 final과 함께 사용한다.
	 * private로 한다면 의미가 없어지기 때문에 public거의 고정 (딴데서 못쓰니까)
	 */
	public static final double PI = 3.14;
	
	public static void test() {
		System.out.println("하이");
	}
}
