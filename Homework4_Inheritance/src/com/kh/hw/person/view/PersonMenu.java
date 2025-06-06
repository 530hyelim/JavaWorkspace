package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {
		while(true) {
			int[] count = pc.personCount();
			System.out.println();
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 "+count[0]+"명입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 "+count[1]+"명입니다.");
			System.out.println();

			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				studentMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void studentMenu() {
		while(true) {
			System.out.println();
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");

			boolean full = false;
			if(pc.personCount()[0] == 3) {
				full = true;
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에"
						+ "학생 추가 메뉴는 더 이상 활성화되지 않습니다.");
			}
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 2:
				printStudent();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			case 1:
				if(!full) {
					insertStudent();
					break;
				}
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void employeeMenu() {
		while(true) {
			System.out.println();
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			
			boolean full = false;
			if(pc.personCount()[1] == 10) {
				full = true;
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에"
						+ "사원 추가 메뉴는 더 이상 활성화되지 않습니다.");
			}
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				if(full) {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				} else {
					insertEmployee();
				}
				break;
			case 2:
				printEmployee();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insertStudent() {
		while(true) {
			System.out.println();
			System.out.print("학생 이름 : ");
			String name = sc.nextLine();
			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			sc.nextLine();
			System.out.print("학생 전공 : ");
			String major = sc.nextLine();
			
			pc.insertStudent(name, age, grade, major);
			
			if(pc.personCount()[0] == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에"
						+ "학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				break; //return;
			}
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무키나 누르세요 :");
			char ans = sc.nextLine().toLowerCase().charAt(0);
			if(ans == 'n') break; //return;
		}
	}
	
	public void printStudent() {
		for(Student s : pc.printStudent()) {
			if(s != null) System.out.println(s);
		}
	}
	
	public void insertEmployee() {
		while(true) {
			System.out.print("사원 이름 : ");
			String name = sc.nextLine();
			System.out.print("사원 나이 : ");
			int age = sc.nextInt();
			System.out.print("사원 급여 : ");
			int salary = sc.nextInt();
			sc.nextLine();
			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();
			
			pc.insertEmployee(name, age, salary, dept);
			
			if(pc.personCount()[1] == 10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에"
						+ "사원 추가를 종료하고 사원 메뉴로 돌아갑니다.");
				return;
			}
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무키나 누르세요 :");
			char ans = sc.nextLine().toLowerCase().charAt(0);
			if(ans == 'n') return;
		}
	}
	
	public void printEmployee() {
		int[] count = pc.personCount();
		Employee[] eArr = pc.printEmployee();
		
		System.out.println();
		for(int i = 0; i < count[1]; i++) {
			System.out.println(eArr[i]);
		}
	}
}
