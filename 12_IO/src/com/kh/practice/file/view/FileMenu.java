package com.kh.practice.file.view;

import java.io.File;
import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				fileSave();
				break;
			case 2:
				fileOpen();
				break;
			case 3:
				fileEdit();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
//	public void fileSave() {
//		StringBuilder sb = new StringBuilder();
//		while(true) {			
//			System.out.println("파일에 저장할 내용을 입력하세요.");
//			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
//			System.out.print("내용 : ");
//			String s = sc.nextLine();
//			
//			if (s.equals("ex끝it")) {
//				while(true) {					
//					System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
//					String fileName = sc.nextLine();
//					File file = new File(fileName);
//					if(file.exists()) {
//						System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) ");
//						char ans = sc.nextLine().toLowerCase().charAt(0);
//						if (ans == 'n') {
//							continue;
//						}
//					}
//					fc.fileSave(fileName, sb);
//					return;
//				}
//			}
//			sb.append(s);
//			sb.append("\n");
//		}
//	}
	
	public void fileSave() {
		StringBuilder sb = addText();
		while(true) {			
			System.out.println("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
			String file = sc.nextLine();
			
			if(fc.checkName(file)) {
				System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) ");
				char ans = sc.nextLine().toLowerCase().charAt(0);
				
				if(ans == 'n') {
					continue;
				}
			}
			fc.fileSave(file, sb);
			break;
		}
	}
	
	public void fileOpen() {
		System.out.print("열 파일 명 : ");
		String fileName = sc.nextLine();
		if (!fc.checkName(fileName)) {
			System.out.println("없는 파일입니다.");
			return;
		}
		System.out.println(fc.fileOpen(fileName));
	}
	
	public void fileEdit() {
		System.out.print("수정할 파일 명 : ");
		String fileName = sc.nextLine();
		if (!fc.checkName(fileName)) {
			System.out.println("없는 파일입니다.");
			return;
		}
		fc.fileEdit(fileName, addText());
	}
	
	private StringBuilder addText() {
		StringBuilder sb = new StringBuilder();
		while(true) {			
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			String s = sc.nextLine();

			if (s.equals("ex끝it")) {
				break;
			}
			sb.append(s + "\n");
		}
		return sb;
	}
}
