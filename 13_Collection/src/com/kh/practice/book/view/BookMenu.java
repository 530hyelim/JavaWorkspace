package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr;
	
	public BookMenu() {
		bc.makeFile();
		bArr = bc.fileRead();
		// 이전에 저장해뒀다가 프로그램 재시작시 불러오기
	}
	
	public void mainMenu() {
		while(true) {
			System.out.println("1. 도서 추가 저장");
			System.out.println("2. 저장 도서 출력");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				fileSave();
				break;
			case 2:
				fileRead();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void fileSave() {
		System.out.print("도서 명 : ");
		String title = sc.nextLine();
		System.out.print("저자 명 : ");
		String author = sc.nextLine();
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("출판 날짜(yyyy-mm-dd) : ");
		String date = sc.nextLine();
		System.out.print("할인율 : ");
		double discount = sc.nextDouble();
		sc.nextLine();
		
		String[] dates = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1])-1;
		int day = Integer.parseInt(dates[2]);
		Calendar c = new GregorianCalendar(year, month, day);
		
		for(int i = 0; i < bArr.length; i++) {
			if(bArr[i] == null) {
				bArr[i] = new Book(title, author, price, c, discount);
				break;
			}
		}
		bc.fileSave(bArr);
	}
	
	public void fileRead() {
		for(Book b : bc.fileRead()) {
			if(b != null) System.out.println(b);
		}
	}
}
