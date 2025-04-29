package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int[] count = new int[2];
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) {
				count[0] = i;
				break;
			}
			count[0] = ++i;
		}
		for(int i = 0; i < e.length; i++) {
			if(e[i] == null) {
				count[1] = i;
				break;
			}
			count[1] = ++i;
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
