package com.kh.chap02_string.run;

import com.kh.chap02_string.controller.A_StringPool;
import com.kh.chap02_string.controller.B_StringBuilderAndBuffer;
import com.kh.chap02_string.controller.C_StringTokenizer;
import com.kh.chap02_string.controller.D_StringMethods;

public class Run {
	public static void main(String[] args) {
		A_StringPool asp = new A_StringPool();
		//asp.method1();
		
		B_StringBuilderAndBuffer b = new B_StringBuilderAndBuffer();
		//b.method();
		
		C_StringTokenizer c = new C_StringTokenizer();
		//c.method();
		
		D_StringMethods d = new D_StringMethods();
		d.method();
	}
}
