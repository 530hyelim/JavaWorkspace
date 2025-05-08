package com.kh.practice.score.view;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.kh.practice.score.controller.ScoreController;

public class ScoreMenu {
	private Scanner sc = new Scanner(System.in);
	private ScoreController scr = new ScoreController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("1. 성적 저장");
			System.out.println("2. 성적 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				saveScore();
				break;
			case 2:
				readScore();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void saveScore() {		
		int num = 0;
		while(true) {
			System.out.println(++num + "번 째 학생 정보 기록");
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("국어 점수 : ");
			int kor = sc.nextInt();
			System.out.print("영어 점수 : ");
			int eng = sc.nextInt();
			System.out.print("수학 점수 : ");
			int math = sc.nextInt();
			sc.nextLine();
			
			int sum = kor + eng + math;
			double avg = sum / 3.0;
			scr.saveScore(name, kor, eng, math, sum, avg);
			
			System.out.print("그만 입력하시려면 N 또는 n 입력, 계속하시려면 아무 키나 입력하세요 : ");
			char ans = sc.nextLine().toLowerCase().charAt(0);
			if(ans == 'n') break;
		}
	}
	
	public void readScore() {
		int count = 0;
		int sumAll = 0;
		double avgAll = 0.0;
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		try(DataInputStream ds = scr.readScore();) {
			while(true) {			
				System.out.print(ds.readUTF()+"\t"); //이름
				System.out.print(ds.readInt()+"\t"); //국어
				System.out.print(ds.readInt()+"\t"); //영어
				System.out.print(ds.readInt()+"\t"); //수학
				int sum = ds.readInt();
				System.out.print(sum+"\t"); //총점
				double avg = ds.readDouble();
				System.out.println(avg); //평균
				count++;
				sumAll += sum;
				avgAll += avg;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("읽은 횟수\t전체 합계\t전체 평균");
			System.out.printf("%d\t%d\t%f\n", count, sumAll, avgAll/count);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
