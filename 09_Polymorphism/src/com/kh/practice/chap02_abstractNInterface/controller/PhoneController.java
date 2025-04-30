package com.kh.practice.chap02_abstractNInterface.controller;

import com.kh.practice.chap02_abstractNInterface.model.vo.*;

public class PhoneController {
	private String[] result = new String[2];
	
	public String[] method() {
		Phone[] arr = new Phone[2];
		arr[0] = new GalaxyNote9();
		arr[1] = new V40();
		for(int i = 0; i < result.length; i++) {
			if(arr[i] instanceof GalaxyNote9) {
				result[i] = ((GalaxyNote9)arr[i]).printInformation();
			}
			if(arr[i] instanceof V40) {
				result[i] = ((V40)arr[i]).printInformation();				
			}
			//다운캐스팅(한단계 상위 클래스인 스마트폰으로도 캐스팅 가능 => 동적바인딩 이용)
		}
		return result;
	}
}
