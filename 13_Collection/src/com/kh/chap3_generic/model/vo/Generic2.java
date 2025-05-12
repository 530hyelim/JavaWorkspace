package com.kh.chap3_generic.model.vo;

public class Generic2<T extends Parent> { // 제네릭으로 Parent와 Parent를 상속받은 클래스만 올 수 있다는 뜻
	private T t;
	
	public void printing() {
		//t.doPrint(); // 제네릭으로 타입을 확정시켰기 때문에 사용가능
	}
	
	public T getT() {
		return t;
	}
	
	public /*<? extends Parent>*/void setT(T t) {
		this.t = t;
	}
}
