package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int[] count = new int[2];
		//배열의 인덱스에 들어간 값이 null이라면 저장되지 않은 인덱스
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) {
				count[0] = i;
				break;
			}
			count[0] = ++i;
		}
		for(Employee /* or Person or Object(다형성)*/ emp : e) {
			if(emp != null) {
				count[1] += 1;
			}
		}
		return count;
	}
	
	public void insertStudent(String name, int age, int grade, String major) {
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) {
				s[i] = new Student(name, age, grade, major);
				break;
			}
		}
	}
	
	public Student[] printStudent() {
		return s;
	}
	
	public void insertEmployee(String name, int age, int salary, String dept) {
		for(int i = 0; i < e.length; i++) {
			if(e[i] == null) {
				e[i] = new Employee(name, age, salary, dept);
				break;
			}
		}
	}
	
	public Employee[] printEmployee() {
		return e;
	}
}
