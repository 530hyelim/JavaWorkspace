package com.kh.practice.charCheck.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.kh.practice.charCheck.controller.CharacterController;
//import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterMenu {
	public void menu() {
		CharacterController cc = new CharacterController();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자열 : ");
		try {
			String s = br.readLine();
			System.out.printf("'%s'에 포함된 영문자 개수 : %d\n", s, cc.countAlpha(s));
//		} catch(CharCheckException e) {
//			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
