package com.kh.practice.thread;

import java.util.Random;

public class Provider extends Thread{
	private Data data;
	
	public Provider(Data data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			int random = new Random().nextInt(100)+1;
			data.setValue(random);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
