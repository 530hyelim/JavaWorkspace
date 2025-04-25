package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int ppl = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + candy/ppl);		
		System.out.println("남는 사탕 개수 : " + candy%ppl);
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		
		System.out.print("반(숫자만) : ");
		int group = sc.nextInt();
		
		System.out.print("번호(숫자만) : ");
		int id = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %c학생의 성적은 %.2f이다.", 
				grade, group, id, name, gender == 'M'? '남':'여', score);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		boolean child = age <= 13;
		boolean teen = 13 < age && age <= 19;
		//boolean adult = age > 19;
		
		System.out.println(child? "어린이" : (teen? "청소년":"성인"));
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int mth = sc.nextInt();
		
		int sum = kor+eng+mth;
		double avg = sum / 3;
		
		boolean fortyUp = kor >= 40 && eng >= 40 && mth >= 40;
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);		
		System.out.println(fortyUp && avg >= 60 ? "합격":"불합격");
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호를 입력하세요(- 포함) : ");
		String id = sc.nextLine();
		char gender = id.charAt(7);
		
		System.out.println(gender == '1' || gender == '3' ? "남자":"여자");
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 : ");
		int num = sc.nextInt();
		
		//System.out.println(num <= num1 || num > num2 ? "true":"false");
		
		boolean result = num <= num1 || num > num2;
		System.out.println(result);
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();
		
		//System.out.println(num1 == num2 && num2 == num3 ? "true":"false");
		
		boolean result = num1 == num2 && num2 == num3;
		System.out.println(result);
		/*
		 * num1 == num2 == num3 가 에러나는 이유
		 * 먼저 num1 == num2를 비교하고 boolean값을 반환
		 * true/false와 num3와 비교하게 되기 때문에 안됨!
		 */
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("A사원의 연봉 : ");
		int numA = sc.nextInt();
		System.out.print("B사원의 연봉 : ");
		int numB = sc.nextInt();
		System.out.print("C사원의 연봉 : ");
		int numC = sc.nextInt();
		
		double finalA = numA * 1.4;
		double finalB = numB * 1.0;
		double finalC = numC * 1.15;
		
		System.out.println("A사원 연봉/연봉+a : "+numA+"/"+finalA);
		System.out.println(finalA >= 3000 ? "3000 이상":"3000 미만");
		System.out.println("B사원 연봉/연봉+a : "+numB+"/"+finalB);
		System.out.println(finalB >= 3000 ? "3000 이상":"3000 미만");
		System.out.println("C사원 연봉/연봉+a : "+numC+"/"+finalC);
		System.out.println(finalC >= 3000 ? "3000 이상":"3000 미만");
		/*
		 * 2990이 아닌 2989.999999999995로 표기되는 이유
		 * 실수형 연산을 할 때에는 근사치로 계산이 되기 때문
		 * 
		 * why 근사치?
		 * 컴퓨터는 한정된 메모리에서 최대한 많은 범위를 표현할 수 있는 '부동소수점 표현'방식을 사용
		 * 
		 * 부동소수점이란? 1.xxx * 2^n 형태로 변환 => 무한 소수 => 데이터의 범위를 넘어가면 오차발생
		 * why not 고정소수점? 부동소수점 방식보다 적은 값을 표현하기 때문
		 * 
		 * => BigDecimal 클래스를 이용하여 오차를 예방 (String 타입으로 변함)
		 */
	}
}
