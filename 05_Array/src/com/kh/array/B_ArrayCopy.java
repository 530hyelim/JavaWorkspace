package com.kh.array;

import java.util.Arrays;

public class B_ArrayCopy {
	//깊은 복사 vs. 얕은 복사 (참조자료형 모두에서 사용됨)
	
	/*
	 * 배열 복사
	 *   - 얕은 복사: 주소값만 복사
	 *   - 깊은 복사: "새로운 배열(객체)"을 생성하여 실제 내부값들도 복사
	 *   			주소값도 새로 생성됨
	 */
	
	//얕은 복사
	public void method1() {
		int[] origin = {1,2,3,4,5};
		
		System.out.println("== 원본 배열 출력 ==");
		System.out.println(Arrays.toString(origin));
		
		//copy본 배열 생성
		int[] copy = origin;
		System.out.println("== 복사본 배열 출력 ==");
		System.out.println(Arrays.toString(copy));
		
		//copy본 배열 수정
		copy[2] = 99;
		System.out.println("== 복사본 배열 수정 후 ==");
		
		System.out.println("== 원본 배열 출력 ==");
		System.out.println(Arrays.toString(origin));
		
		System.out.println("== 복사본 배열 출력 ==");
		System.out.println(Arrays.toString(copy));
	}
	
	//깊은 복사
	public void method2() {
		//1. for문을 활용한 (수동)깊은 복사
		int[] origin = {1,2,3,4,5};
		int[] copy = new int[origin.length];
		
		for(int i = 0; i < copy.length; i++) {
			copy[i] = origin[i];
		}
		copy[2] = 99;
		System.out.println("== 복사본 배열 수정 후 ==");
		
		System.out.println("== 원본 배열 출력 ==");
		System.out.println(Arrays.toString(origin));
		
		System.out.println("== 복사본 배열 출력 ==");
		System.out.println(Arrays.toString(copy));
	}
	
	//함수를 활용한 복사
	public void method3() {
		// System.arraycopy(원본 배열, 원본 배열에서 복사를 시작할 인덱스,
		// 복사본 배열, 복사본 배열에서 복사될 시작 인덱스, 복사할 갯수) => 5개의 매개변수
		int[] origin = {1,2,3,4,5,0,0,0,0,0};
		int[] copy = new int[10];
		
		System.arraycopy(origin, 0, copy, 0, 5); // 1 2 3 4 5 0 0 0 0 0
		System.out.println(Arrays.toString(copy));
		
		// 0 3 4 5 0 0 0 0 0 0
		int[] copy2 = new int[10];
		System.arraycopy(origin, 2, copy2, 1, 3);
		System.out.println(Arrays.toString(copy2));
		
		// 1 2 3 4 5 0 0 0 0 0 => 0 1 2 3 4 5 0 0 0 0
		System.arraycopy(origin, 0, origin, 1, 5);
		origin[0] = 0;
		System.out.println(Arrays.toString(origin));
		// 똑같이 깊은 복사하는거기 때문에 메모리 증가되는거 똑같음
		// native: 자바가 아닌 다른 모든플랫폼에서 작동하는 언어(보통 C언어) => 성능이 좋음
		// 어레이리스트: 크기 제한이 없다 => 원래어레이 크기+1의 어레이를 만들어서 복사하고 그 복사본을
		// 사용하는 메커니즘이기 때문에 가능
		
		/* 깊은 복사처럼 보이지만 방식이 다름
		 * ????????????????
		 */
	}
	
	public void method4() {
		// Arrays.copyOf(원본배열, 복사할 갯수) => 복사본 배열의 주소값 반환 
		// 내부적으로 어레이카피를 이용
		int[] origin = {1,2,3,4,5};
		int[] copy = Arrays.copyOf(origin, 10); // 1 2 3 4 5 0 0 0 0 0
		
		System.out.println(Arrays.toString(copy));
	}
	
	public void method5() {
		// clone 메서드: 원본배열과 똑같은 깊은복사 된 카피본
		int[] origin = {1,2,3,4,5};
		int[] copy = origin.clone();
		
		System.out.println(origin == copy); //false:깊은복사, true:얕은복사
		System.out.println(Arrays.toString(copy));
	}
	
}
