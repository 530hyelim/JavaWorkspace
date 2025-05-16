package com.kh.chap01_constant.run;

import java.util.Calendar;

import com.kh.chap01_constant.model.vo.Car;
import com.kh.chap01_constant.model.vo.CarColor;
import com.kh.chap01_constant.model.vo.Color;

public class Run {
	// 특정 상수값들을 좀 더 다루기 편하게 하기 위해 => Enum
	public static void main(String[] args) {
		/*
		 * 상수
		 * 	 - 값이 변하지 않는 변수
		 * 	 - 저장하고 있는 값에 대해서 가독성과 전달력을 높이기 위해 사용
		 * 	 - static final 키워드를 사용하여 static 영역에 데이터를 저장하고 재사용한다.
		 * 	 - 일반적으로 상수값은 변수명을 통해 의미를 부여하고, 실제 값은 정수값을 저장하는 경우가 많다.
		 */
		Car car1 = new Car();
		// 자동차의 색깔은 검은색
		car1.setCarColor(0);
		car1.setCarColor(Car.BLACK);
		car1.setCarColor(CarColor.BLACK);
		
		// 상수의 단점 2: 값에 대한 검증 기능이 없다.(사용자 입장)
		car1.setCarColor(Calendar.YEAR); //이상한 인터페이스의 상수를 이용해도 같은 정수값이기
		// 때문에 컴파일 상에 에러가 나지 않음
		
		// 그 외 상수의 단점
		//	 - 비슷한 상수값을 하나의 변수로 관리할 수 없음
		//	 EX) 다양한 어플리케이션에서 사용되는 상수값이 있을 때, 이를 하나의 변수로 관리하고 싶은 경우
		//		JAVA에서는 boolean으로 관리하는 값을, Oracle과 같은 서버에서는 "true"라는 문자열
		//		로 관리될 때. true와 "true"는 한묶음으로 관리되어야 한다.
		//		(상수가 아니여도 발생할 수 있는 문제 중 하나)
		//	 - 상수마다 고유 메서드를 사용할 수 없다.
		
		// 상수의 단점을 보완한 코딩방식
		//	 - 값 자체에 의미부여, 검증기능 추가, 고유메서드, 비슷한 값들을 하나로 모아서 관리
		//	 - 상수를 "객체"단위로 관리
		
		Car car2 = new Car();
		car2.setCarColor(Calendar.YEAR); // 검증기능X
		//car2.setColor(Calendar.YEAR); // 검증기능O
		car2.setColor(Color.BLACK);
	}
}
