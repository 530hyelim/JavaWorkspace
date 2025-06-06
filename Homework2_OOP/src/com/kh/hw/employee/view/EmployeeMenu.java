package com.kh.hw.employee.view;

import java.util.Scanner;

import com.kh.hw.employee.controller.EmployeeController;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();
	
	public EmployeeMenu() {
		while(true) {
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 수정");
			System.out.println("3. 사원 삭제");
			System.out.println("4. 사원 출력");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호를 누르세요 : ");
			int ans = sc.nextInt();
			sc.nextLine();
			
			switch(ans) {
			case 1:
				insertEmp();
				break;
			case 2:
				updateEmp();
				break;
			case 3:
				deleteEmp();
				break;
			case 4:
				printEmp();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 입력했다");
			}
		}
	}
	
	public void insertEmp() {
		System.out.print("사원 번호 : ");
		int empNo = sc.nextInt();
		sc.nextLine();
		System.out.print("사원 이름 : ");
		String name = sc.nextLine();
		System.out.print("사원 성별 : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("전화 번호 : ");
		String phone = sc.nextLine();
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		char ans = sc.nextLine().toLowerCase().charAt(0);
		
		if(ans != 'y') {
			ec.add(empNo, name, gender, phone);
			return;
		}
		System.out.print("사원 부서 : ");
		String dept = sc.nextLine();
		System.out.print("사원 연봉 : ");
		int salary = sc.nextInt();
		System.out.print("보너스 율 : ");
		double bonus = sc.nextDouble();
		sc.nextLine();
		ec.add(empNo, name, gender, phone, dept, salary, bonus);
	}
	public void updateEmp() {
		System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		int ans = sc.nextInt();
		sc.nextLine();
		
		switch(ans) {
		case 1:
			System.out.print("수정할 전화번호 : ");
			ec.modify(sc.nextLine());
			break;
		case 2:
			System.out.print("수정할 사원 연봉 : ");
			ec.modify(sc.nextInt());
			sc.nextLine();
			break;
		case 3:
			System.out.print("수정할 보너스 율 : ");
			ec.modify(sc.nextDouble());
			sc.nextLine();
			break;
		case 9:
			System.out.println("메인메뉴로 돌아갑니다");
			return;
		default :
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
	}
	public void deleteEmp() {
		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
		if (sc.nextLine().toLowerCase().charAt(0) == 'y') {
			ec.remove();
			System.out.println("데이터 삭제에 성공하였습니다.");			
		}
	}
	public void printEmp() {
		String s = ec.inform();
		if (s == null) {
			System.out.println("사원 데이터가 없습니다");
			return;
		}
		System.out.println(ec.inform());
	}
}
