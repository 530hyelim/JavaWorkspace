package com.kh.chap02_lambda.part02_practice;

import com.kh.chap02_lambda.model.functional.LambdaTest1;
import com.kh.chap02_lambda.model.functional.LambdaTest2;

public class LambdaPractice {
	// 람다식 문법 종류
	
	public static void main(String[] args) {
		// 1. 기본 형태
		LambdaTest1 lambda1 = (int x, int y) -> {
			return x + y;
		};
		
		// 2. 매개변수의 자료형 생략 가능
		// LambdaTest1 안에 함수 하나있고, 그 안에 자료형이 둘 다 int니까
		LambdaTest1 lambda2 = (x, y) -> {
			return x + y;
		};
		
		// 3. 매개변수의 ()생략 가능. 단, 매개변수가 딱 "1개" 있을 경우
		LambdaTest2 lambda3 = str -> {
			System.out.println(str);
		};
		
		// 4. 중괄호{} 생략 가능. 단, 실행할 코드가 한문장인 경우
		LambdaTest1 lambda4 = (x, y) -> x + y; // return도 함께 생략해줘야 함
		LambdaTest2 lambda5 = str -> System.out.println(str);
		
		// - 실습문제 -
        // 각 람다식을 가장 간결한 형태로 표현하기
        // 1. x -> x * x; 
        // 2. str -> str.length();
        // 3. x -> {System.out.println(x); return x;};
        // 4. str -> str.toUpperCase(); 
        // 5. (x, y) -> x * y;
        // 6. (x, y) -> x % y == 0;
        // 7. (x, str1) -> str1 + x; 
        // 8. (x, str1) -> System.out.println(x + str1);
        // 9. arr -> Math.max(Math.max(arr[0], arr[1]), arr[2]);
        // 10. (str1, str2) -> str1.concat(str2);
	}
}
