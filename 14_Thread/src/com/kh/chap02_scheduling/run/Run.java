package com.kh.chap02_scheduling.run;

public class Run {
	public static void main(String[] args) {
		/*
		 * 스레드 스케쥴링: 스레드의 작업 순서를 조절하는 방법
		 * 
		 * Round Robin 스케쥴링(순환 할당 방식)
		 * 	 - 각 스레드에게 시간할당량을 정하여 정해진 시간만큼만 스레드를 실행시키는 방식
		 * 	 - 각 스레드에게 동일한 시간만큼 cpu가 할당
		 * 	 - 만약, 스레드간에 우선순위가 부여된 경우 우선순위가 높은 스레드가 더 많은 작업시간을 할당받음
		 * 	 - 스레드의 우선순위가 같은 경우 동일한 시간할당량이 주어짐
		 * 	 - Round Robin은 os가 정하는 스레드 실행 방식으로 소스코드로 제어가 불가능
		 * 
		 * 우선순위 기반 스케쥴링
		 * 	 - 스레드마다 우선순위를 부여하는 방식
		 * 	 - 우선순위가 높은 스레드가 더 많은 작업시간을 할당받는 방식
		 * 	 - 소스코드로 스레드의 우선순위를 부여할 수 있다
		 * 	 - 단, 우선순위가 높다고 해서 무조건 가장 먼저 실행완료된다는 개런티X
		 */
		
		Thread t1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
			for(int i = 0; i < 20; i++) {
				System.out.println("Car Driving...");
				try {
					Thread.sleep(100); // 스레드를 0.1초 일시정지 시키는 메서드
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		});
		t1.setName("Car");
		
		Thread t2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
			for(int i = 0; i < 20; i++) {
				System.out.println("Plane Flying...");
				try {
					Thread.sleep(100); // 스레드를 0.1초 일시정지 시키는 메서드
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		});
		t2.setName("Plane");
		
		Thread t3 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
			for(int i = 0; i < 20; i++) {
				System.out.println("Tank Shooting...");
				try {
					Thread.sleep(100); // 스레드를 0.1초 일시정지 시키는 메서드
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		});
		t3.setName("Tank");
		
		// 우선순위 설정
		//	 - 각 스레드는 기본적으로 5의 우선순위를 가지고 있음
		//	 - 1 ~ 10(가장 높음) 사이의 정수값을 대입하여 우선순위를 추가할 수 있음
		t1.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		// 중요도에 따라서 처리순서가 보장되지는 않음
		
//		t1.start();
//		t2.start();
//		t3.start();
		// 메인스레드가 종료되더라도 실행중인 스레드가 있으면 프로그램이 종료되지 않음
		
		/*
		 * 데몬 스레드(메인스레드의 보조스레드)
		 * 	 - 특정 스레드에 종속적인 스레드를 데몬스레드라고 부름
		 * 	 - 백그라운드 작업용 스레드에 할당
		 * 	 - 메인스레드 종료시, 데몬스레드도 함께 종료된다
		 * 	 - 주의: 모든 스레드를 setDaemon 해주어야 함
		 */
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(1000);
			System.out.println("메인스레드 종료");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
