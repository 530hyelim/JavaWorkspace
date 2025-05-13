package com.kh.chap01_thread.thread;

public class Thread2 implements Runnable{
	@Override
	public void run() {
		//람다식 활용 권장
		for(int i = 1; i <= 100; i++) {
			System.out.println("Thread2 ["+i+"]");
		}
	}
}
