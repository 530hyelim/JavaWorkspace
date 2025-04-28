package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("==========  학생  정보  출력  ==========");
		for(int i = 0; i < ssm.printStudent().length; i++) {
			System.out.println(ssm.printStudent()[i].inform());
		}
		System.out.println();
		System.out.println("==========  학생  성적  출력  ==========");
		System.out.println("학생 점수 합계 : "+(int)ssm.avgScore()[0]);
		System.out.println("학생 점수 평균 : "+ssm.avgScore()[1]);
		System.out.println();
		System.out.println("==========  성적  결과  출력  ==========");
		for(int i = 0; i < ssm.printStudent().length; i++) {
			String name = ssm.printStudent()[i].getName();
			int score = ssm.printStudent()[i].getScore();
			String result = score < StudentController.CUT_LINE ? "재시험 대상":"통과";
			System.out.printf("%s학생은 %s입니다", name, result);
			System.out.println();
		}
	}
}
