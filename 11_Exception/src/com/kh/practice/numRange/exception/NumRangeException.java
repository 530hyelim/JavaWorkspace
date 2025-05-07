package com.kh.practice.numRange.exception;

import java.io.IOException;

// math클래스나 system클래스는 java.lang 패키지 안에있어서 import 안해줬었는데
// runtimeException이나 Exception도 마찬가지로 lang 패키지 안에있어서
// IOException과는 다르게 import가 필요하지 않음
public class NumRangeException extends RuntimeException{
	public NumRangeException() {
		
	}
	
	public NumRangeException(String msg) {
		super(msg);
	}
}
