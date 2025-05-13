package com.kh.chap01_thread.run;

public class practice {
	public static void main(String[] args) {
		Thread UpperAlphabetThread = new Thread(() -> {
			System.out.println("[대문자쓰레드 시작]");
			char c = 'A';
			while(c != 'Z'+1) {
				System.out.println("[대문자쓰레드 : "+c+"]");
				c++;
			}
			System.out.println("[대문자쓰레드 종료]");
		});
		Thread LowerAlphabetThread = new Thread(() -> {
			System.out.println("[소문자쓰레드 시작]");
			char c = 'a';
			while(c != 'z'+1) {
				System.out.println(Thread.currentThread().getName()+" : "+c);
				c++;
			}
			System.out.println("[소문자쓰레드 종료]");
		});
		LowerAlphabetThread.setName("소문자쓰레드");
		UpperAlphabetThread.start();
		LowerAlphabetThread.start();
	}
}
