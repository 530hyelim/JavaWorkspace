package com.kh.practice.generics.view;

import java.util.Scanner;

import com.kh.practice.generics.controller.FarmController;
import com.kh.practice.generics.model.vo.Farm;

public class FarmMenu {
	Scanner sc = new Scanner(System.in);
	FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========== KH  마트  ==========");
		while(true) {
			System.out.println("*******  메인  메뉴  *******");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 9:
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("*******  직원  메뉴  *******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				addNewKind();
				break;
			case 2:
				removeKind();
				break;
			case 3:
				changeAmount();
				break;
			case 4:
				printFarm();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void customerMenu() {
		System.out.println("현재 KH마트 농산물 수량");
		printFarm();
		
		while(true) {
			System.out.println("*******  고객  메뉴  *******");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				buyFarm();
				break;
			case 2:
				removeFarm();
				break;
			case 3:
				printBuyFarm();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void addNewKind() {
		System.out.println("1.과일 / 2. 채소 / 3. 견과");
		System.out.print("추가할 종류 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		if (num != 1 && num != 2 && num != 3) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			addNewKind();
			return;
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		sc.nextLine();
		
		String kind = "";
		switch(num) {
		case 1:
			kind = "과일";
			break;
		case 2:
			kind = "채소";
			break;
		case 3:
			kind = "견과";
		}
		if(fc.addNewKind(new Farm(kind), amount)) {
			System.out.println("새 농산물이 추가되었습니다.");
		} else {
			System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
			addNewKind();
		}
	}
	
	public void removeKind() {
		System.out.println("1.과일 / 2. 채소 / 3. 견과");
		System.out.print("삭제할 종류 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		if (num != 1 && num != 2 && num != 3) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			removeKind();
			return;
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		Farm f = null;
		switch(num) {
		case 1:
			f = new Farm("과일");
			break;
		case 2:
			f = new Farm("채소");
			break;
		case 3:
			f = new Farm("견과");
		}
		if(fc.removeKind(f)) {
			System.out.println("농산물 삭제에 성공하였습니다.");
		} else {
			System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
			removeKind();
		}
	}
	
	public void changeAmount() {
		
	}
	
	public void printFarm() {
		
	}
	
	public void buyFarm() {
		
	}
	
	public void removeFarm() {
		
	}
	
	public void printBuyFarm() {
		
	}
}
