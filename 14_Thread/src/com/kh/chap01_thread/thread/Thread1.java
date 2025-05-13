package com.kh.chap01_thread.thread;

public class Thread1 extends Thread{
	@Override
	public void run() {
		// 각 스레드가 실행할 코드를 기술하는 메서드
		for(int i = 1; i <= 100; i++) {
			System.out.println("Tread1 ["+i+"]");
		}
	}
}
