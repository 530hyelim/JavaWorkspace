package com.kh.practice.chap02_abstractNInterface.model.vo;

public interface Phone {
	char[] NUMBERPAD = {'1','2','3','4','5','6','7','8','9','*','0','#'};
	
	default String makeCall() {
		return "번호를 누르고 통화버튼을 누름";
	}
	
	default String takeCall() {
		return "전화받기 버튼을 누름";
	}
	
//	String makeCall();
//	String takeCall();
}
