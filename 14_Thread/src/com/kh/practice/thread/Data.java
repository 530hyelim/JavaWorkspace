package com.kh.practice.thread;

public class Data {
	private int value;
	private boolean isEmpty = true;
	
	public Data() {
		
	}
	
	public void setValue(int value) {
		synchronized(this) {
			this.value = value;
//			System.out.println("값이 입력되었습니다.");
//			System.out.println("put value : "+value);
			isEmpty = false;
			notify();
			if(isEmpty == false) { // 비어있지 않다면
				try {
					wait(); // 어차피 기다림. 10번 모두 실행
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			this.value = value;
//			System.out.println("값이 입력되었습니다.");
//			System.out.println("put value : "+value);
//			isEmpty = false;
//			notify();
		}
	}
	
	public int getValue() {
		synchronized(this) {
			if(isEmpty == true) { // 비어있다면
				try {
					throw new EmptyException("밸류없음~~~");
				}
				catch (EmptyException e) {
					System.out.println("현재 입력된 값이 없습니다. 기다리십시오...");
					try {
						wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} 
			}
//			System.out.println("get value : "+value);
//			System.out.println("값을 꺼냈습니다. value가 비었습니다.");
			isEmpty = true;
			notify();
			return value;
		}		
	}
}
