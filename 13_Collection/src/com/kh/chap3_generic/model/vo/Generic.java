package com.kh.chap3_generic.model.vo;

// 현재 클래스에서 사용할 타입변수를 <타입변수(관례상 한글자)>
public class Generic <T, G> { // class 레벨 제네릭 설정 (전역변수처럼 클래스 모든곳에서 접근 가능)
	/*
	 * 제네릭 설정방법
	 * 	 - 여러 참조자료형으로 대체될 수 있는 부분을 하나의 문자로 표현한다
	 * 		<T>, <G>, <V>, ...
	 * 	 - <> : 다이아몬드 연산자는 참조자료형을 얻어올 수 있는 연산자
	 * 	 - 제네릭은 class, method에 각각 지정할 수 있다
	 */
	T t;
	G g;
	
	public T test(G g) {
		return t;
	}
	
	public T getT() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}

	public G getG() {
		return g;
	}

	public void setG(G g) {
		this.g = g;
	}
	
	// 메서드레벨 제네릭 설정
	public <V> void printTest(V item) {
		System.out.println(item);
	}
}
