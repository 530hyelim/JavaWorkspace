package com.kh.chap01_poly.part01_basic.run;

import com.kh.chap01_poly.part01_basic.model.vo.*;

public class Run {
	public static void main(String[] args) {
		System.out.println("1. 부모타입 참조변수로 부모 객체 다루기");
		//부모타입 참조변수 = reference
		Parent p1 = new Parent();
		p1.printParent();
		
		System.out.println("2. 자식타입 참조변수로 자식 객체 다루기");
		Child1 c1 = new Child1();
		c1.printParent(); //부모클래스 (메서드 상속)
		c1.printChild1(); //자식1
		
		System.out.println("3. 부모타입 참조변수로 자식 객체 다루기");
		Parent p2 = new Child1(); //다형성
		Parent p3 = /*(Parent)*/ new Child2();
		//자식에서 부모클래스로 자동형변환 ==> 업캐스팅
		//상속 관계에서만 적용됨
		//대입연산자 기준으로 왼쪽과 오른쪽의 참조형이 다르다
		//하지만 자동으로 형변환이 일어난다
		
//		p2.printChild1(); //존재하는데도 에러가 발생함
		//컴파일 단계에서 p2는 아직 parent의 객체이기 때문
		//컴파일 에러를 없애려면 다운캐스팅이 필요함
		((Child1)p2).printChild1(); //다운캐스팅
		//p2 참조변수로는 parent에 있는 메서드에만 접근이 가능하므로,
		//child1 클래스로 강제형변환 시켜주어야, child1 내부의 메서드에 접근 가능
		
		//객체 배열을 다룰때 모든 클래스마다 배열을 만들필요없이
		//가장 상위 클래스의 배열을 생성해서 담을 수 있게 하기 위함
		
		/*
		 * 상속구조의 클래스에서는 형변환이 가능하다
		 * => 이로인해 다형성이 발생한다
		 * 
		 * 1. UpCasting
		 *   - 자식타입의 객체가 부모타입으로 형변환 되는경우
		 *   - 형변환 연산자를 생략해도 자동으로 추가된다
		 * 
		 * 2. DownCasting
		 *   - 부모타입의 참조변수가 자식타입의 자료형으로 형변환 되는경우
		 *   - 여러개의 자식타입 중 하나를 직접 기술 해줘야하므로 개발자가
		 *     형변환 연산자를 명시적으로 작성해 주어야 한다
		 */
		
		// 다형성을 사용하는 이유
		//   - 생산성, 유지보수성에 크게 기여를 하기 때문에 사용
		//   - 부모타입으로부터 파생된 여러가지 타입의 자식 객체들을
		//     부모 클래스 하나로 다룰 수 있기 때문에 사용한다
		System.out.println(p1); //println(Object x)에서
		// Parent 클래스가 Object 클래스로 형변환 되기 때문에 사용 가능한 것
		
		//자식 객체들을 부모타입 레퍼런스배열로 다루기
		Parent[] arr = new Parent[4];
		arr[0] = new Child1(1,2,4);
		arr[1] = new Child2(5,7,4);
		arr[2] = new Child2(8,9,10);
		arr[3] = new Child1(7,7,7);
		
		//각 자식클래스 안의 print문 출력하기
		for(int i = 0; i < arr.length; i++) {
			//각 인덱스에 초기화된 자식 객체 내부의 printChild 메서드 호출하기
//			((Child1)arr[i]).printChild1(); //컴파일 단계에서는 에러가없지만
			//실행시 1번인덱스의 child2 객체에서 에러발생 => ClassCastException 형변환에러
			
			//어떻게 해결해야 할까? => instanceof 연산자를 이용
			//현재 참조변수가 어떤 클래스로 생성되었는지 확인할 수 있는 연산자
//			if(arr[i] instanceof Child1) {
//				((Child1)arr[i]).printChild1();
//			}
//			else if (arr[i] instanceof Child2) {
//				((Child2)arr[i]).printChild2();
//			}
			
			//모든 자식클래스에 공통으로 추가된 메서드를 호출할 때
			arr[i].print();
			//컴파일 단계에서는 parent 클래스의 print()함수를 호출
			//실제 실행단계(런타임)에서는 heap메모리 영역상의 객체에 들어가서
			// 그 안에 작성된 print()함수를 호출하기 떄문에
			// 오버라이딩 된 메서드가 실행된다 => 동적 바인딩이라고 불림
			
			/*
			 * 동적바인딩(Dynamic Binding): 프로그램이 실행되기 전에는 컴파일 단계에서
			 * 참조변수의 클래스의 메서드를 실행한다고 나와있지만,
			 * 실제 실행시에는 자식객체 내부의 오버라이딩된 메서드를 찾아가서 실행하는것
			 */
		}
	}
}
