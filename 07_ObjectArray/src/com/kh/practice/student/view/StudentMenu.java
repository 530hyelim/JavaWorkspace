package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("==========  학생  정보  출력  ==========");
		for(int i = 0; i < ssm.printStudent().length; i++) {
			System.out.println(ssm.printStudent()[i].inform());
		}
//		Student[] arr = ssm.printStudent();
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i].inform());
//		}
		System.out.println();
		
		System.out.println("==========  학생  성적  출력  ==========");
		System.out.println("학생 점수 합계 : "+(int)ssm.avgScore()[0]);
		System.out.println("학생 점수 평균 : "+ssm.avgScore()[1]);
//		double[] arr2 = ssm.avgScore();
//		System.out.println("학생 점수 합계 : "+(int)arr2[0]);
//		System.out.println("학생 점수 평균 : "+arr2[1]);
		System.out.println();
		
		System.out.println("==========  성적  결과  출력  ==========");
		for(int i = 0; i < ssm.printStudent().length; i++) {
			String name = ssm.printStudent()[i].getName();
			int score = ssm.printStudent()[i].getScore();
			String result = score < StudentController.CUT_LINE ? "재시험 대상":"통과";
			System.out.printf("%s학생은 %s입니다", name, result);
			System.out.println();
		}
//		for(Student std : arr) {
//			System.out.print(std.getName()+"학생은 ");
//			if(std.getScore() < StudentController.CUT_LINE) {
//				System.out.println("재시험 대상입니다");
//			} else {
//				System.out.println("통과입니다");
//			}
//		}
	}
}
