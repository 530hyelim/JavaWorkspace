package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.println("1. 입력\n2. 수정\n3. 조회\n4. 삭제\n7. 종료");
		System.out.print("메뉴 번호를 입력하세요 : ");
		int input = sc.nextInt();
		String result = "";
		
		switch(input) {
		case 1:
			result = "입력";
			break;
		case 2:
			result = "수정";
			break;
		case 3:
			result = "조회";
			break;
		case 4:
			result = "삭제";
			break;
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			return;
		}
		System.out.println(result+" 메뉴입니다.");
	}
	
	public void practice2() {
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input = sc.nextInt();
		
//		if(input <= 0) System.out.println("양수만 입력해주세요.");
//		else if(input % 2 == 0) System.out.println("짝수다");
//		else if(input % 2 == 1) System.out.println("홀수다");
		
		// 단독if문 컨트롤하기 쉽다
		if(input <= 0) {
			System.out.println("양수만 입력해주세요.");
			return;
		}
		if(input % 2 == 0) {
			System.out.println("짝수다");
		} else {
			System.out.println("홀수다");
		}
	}
	
	public void practice3() {
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학점수 : ");
		int mth = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		int total = kor+mth+eng;
		double avg = total/3.0;
		
		boolean pass = kor >= 40 && mth >= 40 && eng >= 40 && avg >= 60;
		
//		if(pass) {
//			System.out.println("국어 : "+kor);
//			System.out.println("수학 : "+mth);
//			System.out.println("영어 : "+eng);
//			System.out.println("합계 : "+total);
//			System.out.println("평균 : "+avg);
//			System.out.println("축하합니다, 합격입니다!");
//		} else {
//			System.out.println("불합격입니다.");
//		}
		
		// 단독if문: 짧은 쪽 코드를 먼저 리턴한다
		if(!pass) {
			System.out.println("불합격");
			return;
		}
		System.out.println("국어 : "+kor);
		System.out.println("수학 : "+mth);
		System.out.println("영어 : "+eng);
		System.out.println("합계 : "+total);
		System.out.println("평균 : "+avg);
		System.out.println("축하합니다, 합격입니다!");
	}
	
	public void practice4() {
		System.out.print("1~12 사이의 정수 입력 : ");
		int input = sc.nextInt();
		String season = "잘못 입력된 달";
		
		switch(input) {
		case 1 : case 2 : case 12 :
			season = "겨어어어어울";
			break;
		case 3 : case 4 : case 5 :
			season = "봄";
			break;
		case 6 , 7 , 8 :
			season = "여어어어어름";
			break;
		case 9 , 10 , 11 :
			season = "가을";
		}
		System.out.printf("%d월은 %s입니다.", input, season);
	}
	
	public void practice5() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
//		if(!id.equals("myId")) System.out.println("아이디가 틀렸습니다.");
//		else if(!pw.equals("myPassword12")) System.out.println("비밀번호가 틀렸습니다.");
//		else System.out.println("로그인 성공");
		
		if(id.equals("myId") && pw.equals("myPassword12")) {
			System.out.println("로그인 성공");
			return;
		}
		if(!id.equals("myId")) {
			System.out.println("아이디가 틀렸습니다.");
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
	
	public void practice6() {
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String access = sc.nextLine();
		//String result = "";
		
		switch(access) {
		case "관리자" :
			//result += "회원관리, 게시글 관리 ";
			System.out.print("회원 관리, 게시글 관리 ");
		case "회원" :
			//result += "게시글 작성, 댓글 작성 ";
			System.out.print("게시글 작성, 댓글 작성 ");
		case "비회원" :
			//result += "게시글 조회";
			System.out.print("게시글 조회");
			break;
		default :
			System.out.print("존재하지 않는 등급입니다.");
		}
		//System.out.println(result);
	}
	
	public void practice7() {
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * height);
		System.out.println("BMI 지수 : "+bmi);
		
		if (bmi < 18.5) {
			System.out.println("저체중");
		} else if (bmi < 23) {
			System.out.println("정상체중");
		} else if (bmi < 25) {
			System.out.println("과체중");
		} else if (bmi < 30) {
			System.out.println("비만");
		} else {
			System.out.println("고도비만");
		}
	}
	
	public void practice8() {
		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		char c = sc.nextLine().charAt(0);
		
		if (num1 < 0 || num2 < 0) return;
		double result = 0.0;
		
		switch(c) {
		case '+' :
			result = num1 + num2;
			break;
		case '-' :
			result = num1 - num2;
			break;
		case '*' :
			result = num1 * num2;
			break;
		case '/' :
			result = (double)num1 / num2;
			break;
		case '%' :
			result = num1 % num2;
			break;
		default :
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			return;
		}
		System.out.printf("%d %c %d = %f", num1, c, num2, result);
	}
	
	public void practice9() {
		System.out.print("중간 고사 점수 : ");
		int mid = sc.nextInt();
		System.out.print("기말 고사 입력 : ");
		int fin = sc.nextInt();
		System.out.print("과제 점수 : ");
		int project = sc.nextInt();
		System.out.print("출석 회수 : ");
		int attendance = sc.nextInt();
		
		System.out.println("============= 결과 ==============");
		
		double midScore = mid * 0.2;
		double finScore = fin * 0.3;
		double projectScore = project * 0.3;
		
		double score = midScore + finScore + projectScore + attendance;
		
		System.out.println("중간 고사 점수(20) : "+midScore);
		System.out.println("기말 고사 점수(30) : "+finScore);
		System.out.println("과제 점수(30) : "+projectScore);
		System.out.println("출석 점수(20) : "+(double)attendance);
		System.out.println("총점 : "+score);
		
		if (attendance <= (20 * 0.7)) {
			System.out.printf("Fail [출석 회수 부족 (%d/20)]", attendance);
			return;
		}
		if (score < 70) {
			System.out.println("Fail [점수 미달]");
		} else {
			System.out.println("PASS");
		}
	}
	
	public void practice10() {
		System.out.println("실행할 기능을 선택하세요.");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");
		
		System.out.print("선택 : ");
		int input = sc.nextInt();
		
		switch(input) {
		case 1:
			practice1();
			break;
		case 2:
			practice2();
			break;
		case 3:
			practice3();
			break;
		case 4:
			practice4();
			break;
		case 5:
			practice5();
			break;
		case 6:
			practice6();
			break;
		case 7:
			practice7();
			break;
		case 8:
			practice8();
			break;
		case 9:
			practice9();
		}
	}
	
	public void practice11() {
		System.out.print("비밀번호 입력(1000~9999) : ");
		int input = sc.nextInt();
		
		if (input < 1000 || input > 9999) {
			System.out.println("자리수 안맞음");
			return;
		}
//		int firstDigit = input/1000;
//		int secondDigit = (input - firstDigit * 1000)/100;
//		int thirdDigit = (input - firstDigit * 1000 - secondDigit * 100)/10;
//		int lastDigit = (input - firstDigit * 1000 - secondDigit * 100 - thirdDigit * 10)/1;

		int firstDigit = input / 1000;		// 1.234 => 1
		int secondDigit = input / 100 % 10;	// 12.34 => 12 % 10 => 2	(몫:1, 나머지:2)
		int thirdDigit = input / 10 % 10;	// 123.4 => 123 % 10 => 3	(몫:12, 나머지:3)
		int lastDigit = input % 10;			// 1234 % 10 => 4			(몫:123, 나머지:4)
		
		
//		System.out.println(firstDigit);
//		System.out.println(secondDigit);
//		System.out.println(thirdDigit);
//		System.out.println(lastDigit);
		
		if(firstDigit == secondDigit || firstDigit == thirdDigit || firstDigit == lastDigit) {
			System.out.println("실패");
			return;
		}
		if(secondDigit == thirdDigit || secondDigit == lastDigit) {
			System.out.println("실패");
			return;
		}
		if(thirdDigit == lastDigit) {
			System.out.println("실패");
			return;
		}
		System.out.println("성공");
	}
}
