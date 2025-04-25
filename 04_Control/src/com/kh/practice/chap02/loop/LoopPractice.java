package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	
	int num = -3;
	public int incDec(int i) {
		if (num > 0) i++;
		else i--;
		return i;
	}
//	public void practice() {
//		for(int i = 0; i < 5; (num > 0 ? i++ : i--)) { => 컴파일 에러
//			System.out.println(i);
//		}
//	}
//	public void practice() {
//		for(int i = 0; i < 5; incDec(i)) { => 증감 안되고 무한루프
//			System.out.println(i);
//		}
//	}
	public void practice() {
		for(int i = 0; (num > 0 ? (i < 5):(i > -5));) {
			System.out.println(i);
			if(num > 0) i++;
			else i--;
		}
	}
	
	public void practice1() {
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
			return;
		}
		for(int i = 1; i <= num; i++) {
			System.out.print(i + " ");
		}
	}
	
	public void practice2() {
//		System.out.print("1이상의 숫자를 입력하세요 : ");
//		int num = sc.nextInt();
//		
//		if (num < 1) {
//			System.out.println("1 이상의 숫자를 입력해주세요");
//			practice2();
//			return; // 이게 없으면 한번 더 호출된 practice2()함수가 실행 완료되었을 때
//				다시 이 자리로 돌아오는데, 그러면 아래 작성된 코드가 실행되므로 무조건 필요함
//		}
//		for(int i = 1; i <= num; i++) {
//			System.out.print(i + " ");
//		}
		while(true) {
			System.out.print("1이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();
			
			if (!(num < 1)) {
				for(int i = 1; i <= num; i++) {
					System.out.print(i + " ");
				}
				break;
			} else {
				System.out.println("1 이상의 숫자를 입력해주세요");				
			}
		}		
//		while(true) {
//			System.out.print("1이상의 숫자를 입력하세요 : ");
//			int num = sc.nextInt();
//			
//			if (num < 1) {
//				System.out.println("1 이상의 숫자를 입력해주세요");
//				continue;
//			} else {
//				for(int i = 1; i <= num; i++) {
//					System.out.print(i + " ");
//				}			
//			}
//		}	
	}
	
	public void practice3() {
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
			return;
		}
		while(num > 0) {
			System.out.print(num-- + " ");
		}
//		for(int i = num ; i > 0 ; i--) {
//			System.out.print(i + " ");
//		}
	}
	
	public void practice4() {
		while(true) {
			System.out.print("1이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();
			
			if (!(num < 1)) {
				while(num > 0) {
					System.out.print(num-- + " ");
				}
				break;
			} else {
				System.out.println("1 이상의 숫자를 입력해주세요");				
			}
		}
	}
	
	public void practice5() {
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		int num = 1;
		
		/*
		//sum 구하기
		int sum = input;
		while(num != input) {
			sum += num++;
		}
		//결과 출력하기
		for(int i = 1; i < input; i++) {
			System.out.print(i + " + ");
		}
		System.out.print(num + " = " + sum);
		*/
		int sum = 0;
		for(int i = 1 ; i <= input ; i++) {
			sum += i;
			System.out.print(i + (i == input ? " = ":" + "));
		}
		System.out.print(sum);
	}
	/*
	public void practice5() {
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		// 예외 처리
		if(input == 1) {
			System.out.println(input);
			return;
		}
		
		int sum = input;
		if(input > 1) {
			for(int i = 1; i < input; i++) {
				System.out.print(i + " + ");
				sum += i;
			}
			System.out.print(input + " = " + sum);
		} else {
			for(int i = 1; i > input; i--) {
				System.out.print(i + " + ");
				sum += i;
			}
			System.out.print(input + " = " + sum);
		}
	}
	*/
	public void practice6() {
		System.out.print("첫 번째 숫자 : ");
		int a = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int b = sc.nextInt();
		
		if (a < 1 || b < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}	
		int big = (a > b ? a : b);
		int small = (a < b ? a : b);
		for(int i = small; i <= big; i++) {
			System.out.print(i + " ");
		}
		
//		if (a > b) {
//			for(int i = b; i <= a; i++) {
//				System.out.print(i + " ");
//			}
//		} else { // a <= b
//			for(int i = a; i <= b; i++) {
//				System.out.print(i + " ");				
//			}
//		}
	}
	
	public void practice7() {
		while(true) {
			System.out.print("첫 번째 숫자 : ");
			int a = sc.nextInt();
			System.out.print("두 번째 숫자 : ");
			int b = sc.nextInt();
			
			if (a < 1 || b < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
				continue;
			}	
			for(int i = (a < b ? a:b); i <= (a > b ? a:b); i++) {
				System.out.print(i + " ");
			}
			break;
		}
	}
	
	public void practice8() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		System.out.printf("===== %d단 =====", num);
		System.out.println();
		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d", num, i, num*i);
			System.out.println();
		}
	}
	
	public void practice9() {
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if (num > 9) {
			System.out.println("9 이하의 숫자만 입력해주세요.");
			return;
		}
		for (; num <= 9; num++) {
			System.out.printf("===== %d단 =====", num);
			System.out.println();
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d", num, i, num * i);
				System.out.println();
			}
		}
	}
	
	public void practice10() {
		while(true) {
			System.out.print("숫자 : ");
			int num = sc.nextInt();
			
			if (num > 9) {
				System.out.println("9 이하의 숫자만 입력해주세요.");
				continue;
			}
			for (int j = num; j < 10; j++) {
				System.out.printf("===== %d단 =====", j);
				System.out.println();
				for (int i = 1; i < 10; i++) {
					System.out.printf("%d * %d = %d", j, i, j * i);
					System.out.println();
				}
			}
			break;
		}
	}
	
	public void practice11() {
		System.out.print("시작 숫자 : ");
		int num = sc.nextInt();
		System.out.print("공차 : ");
		int n = sc.nextInt();
		/*
		for(int i = 0; i < 10; i++) {
			System.out.printf(num + " ");
			num += n;
			//System.out.print((num + n * i)+" ");
		}
		int count = 0;
		for(int i = num; count < 10; num += n) {
			System.out.print(i + " ");
			count++;
		}
		*/
		int i = 1;
		while (i <= 10) {
			System.out.print(num+" ");
			num += n;
			i++;
		}
	}
	
	public void practice12() {
		while(true) {
			System.out.print("연산자(+, -, *, /, %) : ");
			String str = sc.nextLine();
			
			if (str.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				//return;
				break;
			}
			
			System.out.print("정수1 : ");
			int a = sc.nextInt();
			System.out.print("정수2 : ");
			int b = sc.nextInt();
			
			if (b == 0 && str.equals("/") || b == 0 && str.equals("%")) {
				System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
				System.out.println();
				sc.nextLine();
				continue;
			}
			
			int result = 0;
			switch(str) {
			case "+" :
				result = a + b;
				break;
			case "-" :
				result = a - b;
				break;
			case "*" :
				result = a * b;
				break;
			case "/" :
				result = a / b;
				break;
			case "%" :
				result = a % b;
				break;
			default :
				System.out.println("없는 연산자입니다. 다시 입력해주세요.");
				System.out.println();
				sc.nextLine();
				continue;
			}
			System.out.printf("%d %s %d = %d", a, str, b, result);			
			System.out.println();
			sc.nextLine();
		}
	}
	
	public void practice13() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice14() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
//		for(int i = num; i > 0; i--) {
//			for(int j = 0; j < i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		while(num > 0) {
			for(int i = 0; i < num; i++) {
				System.out.print("*");
			}
			System.out.println();
			num--;
		}
	}	
}
