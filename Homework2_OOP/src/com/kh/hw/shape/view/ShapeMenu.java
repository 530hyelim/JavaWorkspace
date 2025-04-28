package com.kh.hw.shape.view;

import java.util.Scanner;

import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TriangleController;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();

	public void inputMenu() {
		System.out.println("===== 도형 프로그램 =====");
		System.out.println("3. 삼각형");
		System.out.println("4. 사각형");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호 : ");
		int ans = sc.nextInt();
		sc.nextLine();
		
		switch(ans) {
		case 3:
			triangleMenu();
			return;
		case 4:
			squareMenu();
			return;
		case 9:
			System.out.println("프로그램 종료");
			return;
		default:
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			inputMenu();
		}
	}
	
	public void triangleMenu() {
		System.out.println("===== 삼각형 =====");
		System.out.println("1. 삼각형 면적");
		System.out.println("2. 삼각형 색칠");
		System.out.println("3. 삼각형 정보");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int ans = sc.nextInt();
		sc.nextLine();
		
		switch(ans) {
		case 1:
			inputSize(3, 1);
			break;
		case 2:
			inputSize(3, 2);
			break;
		case 3:
			printInformation(3);
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			inputMenu();
			return;
		default:
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
		}
		triangleMenu();
	}
	
	public void squareMenu() {
		System.out.println("===== 사각형 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 면적");
		System.out.println("3. 사각형 색칠");
		System.out.println("4. 사각형 정보");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int ans = sc.nextInt();
		sc.nextLine();
		
		switch(ans) {
		case 1:
			inputSize(4, 1);
			break;
		case 2:
			inputSize(4, 2);
			break;
		case 3:
			inputSize(4, 3);
			break;
		case 4:
			printInformation(4);
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			inputMenu();
			return;
		default:
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
		}
		squareMenu();
	}
	
	public void inputSize(int type, int menuNum) {
		//삼각형
		if (type ==3) {
			if (menuNum == 1) {
				System.out.print("높이 : ");
				int height = sc.nextInt();
				System.out.print("너비 : ");
				int width = sc.nextInt();
				sc.nextLine();
				System.out.printf("삼각형 면적 : %.1f", tc.calcArea(height, width));
			} else {
				System.out.print("색깔을 입력하세요 : ");
				tc.paintColor(sc.nextLine());
				System.out.print("색이 수정되었습니다");
			}
			System.out.println();
		} else {
		//사각형
			if (menuNum == 3) {
				System.out.print("색깔을 입력하세요 : ");
				scr.paintColor(sc.nextLine());
				System.out.println("색이 수정되었습니다");
				return;
			}
			System.out.print("높이 : ");
			int height = sc.nextInt();
			System.out.print("너비 : ");
			int width = sc.nextInt();
			sc.nextLine();
			if (menuNum == 1) {
				System.out.printf("사각형 둘레 : %.1f", scr.calcPerimeter(height, width));
			} else {
				System.out.printf("사각형 면적 : %.1f", scr.calcArea(height, width));
			}
			System.out.println();
		}
	}
	
	public void printInformation(int type) {
		if (type == 3) System.out.println(tc.print());
		else System.out.println(scr.print());
	}
}