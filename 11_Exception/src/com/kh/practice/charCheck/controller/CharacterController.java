package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {
	public CharacterController() {
		
	}
	
	public int countAlpha(String s) throws CharCheckException {
		int count = 0;
		char[] arr = s.toCharArray();
		
		for(char c : arr) {
			if(c == ' ') {
				throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
			}
			boolean isUpperAlpha = c >= 'A' && c <= 'Z';
			boolean isLowerAlpha = c >= 'a' && c <= 'z';
			
			if(isUpperAlpha || isLowerAlpha) {
				count++;
			}
		}
		return count;
	}
}
