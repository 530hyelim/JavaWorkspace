package com.kh.chap01_poly.part02_electronic.controller;

import com.kh.chap01_poly.part02_electronic.model.vo.*;

public class ElectronicController {
	private Desktop desk;
	private NoteBook note;
	private Tablet tab;
	
	//다형성 적용 후 사용할 부모객체배열
	private Electronic[] elec = new Electronic[3];
	
	//다형성 적용 전
	//제품 입고 메서드(메서드 오버로딩 적용)
	public void insert(Desktop d) {
		desk = d;
	}
	public void insert(NoteBook n) {
		note = n;
	}
	public void insert(Tablet t) {
		tab = t;
	}
	
	//제품 조회 메서드
	//이름 다르게 하는이유: 오버로딩할때 반환형 다르게 하는걸로는 안되니까
	public Desktop selectDesktop() {
		return desk;
	}
	public NoteBook selectNoteBook() {
		return note;
	}
	public Tablet selectTablet() {
		return tab;
	}
	
	//다형성 추가 후 메서드
	public void insert(Electronic e, int index) {
		elec[index] = e;
	}
	public Electronic select(int index) {
		return elec[index];
	}
}
