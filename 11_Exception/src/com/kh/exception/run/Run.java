package com.kh.exception.run;

import java.io.IOException;

import com.kh.exception.controller.A_UncheckedException;
import com.kh.exception.controller.B_CheckedException;
import com.kh.exception.controller.C_CustomException;

public class Run {
	// 가능하지만 비권장됨 (메인 스레드에서 처리하게됨)
	public static void main(String[] args) throws IOException{
		// NullPointerException
		// IndexOutofBoundException
		
		/*
		 * 에러의 종류
		 * 1. 시스템 에러: 컴퓨터의 오작동으로 발생하는 에러 => 소스코드로는 해결 불가
		 * 2. 컴파일 에러: 문법적인 문제로 발생하는 에러 => 소스코드로 수정 가능
		 * 3. 런타임 에러: 프로그램 실행 중 발생하는 에러 => 소스코드의 수정으로 해결 가능
		 * 4. 논리 에러: 컴파일상에서도 문제없고, 런타임상에서도 문제가 없는데 프로그램이 실행될 때
		 * 	  내 의도와 다른 방식으로 실행되는 경우
		 * 
		 * 컴파일 에러, 런타임 에러와 같은 에러들을 처리하는 방법을 예외처리 라고 부른다
		 * 
		 * 예외처리를 반드시 해야 하는 이유
		 *   - 프로그램의 비 정상적인 종료를 막기 위해
		 *   - 프로그램이 돌아갈 때 예외가 발생하는 상황을 기록하여 이후 유지보수하기 위해 필요
		 * 
		 * 예외처리하는 방법
		 * 1. try ~ catch문 이용
		 * 2. throws를 이용
		 * 3. 예외처리 구문을 아예 사용하지 않는 방법
		 */
		A_UncheckedException a = new A_UncheckedException();
		//a.method3();
		B_CheckedException b = new B_CheckedException();
		b.method2();
		
		// 예외를 강제로 발생시킬 수 있음
		throw new C_CustomException("사용자 정의 에러 발생");
	}
}
