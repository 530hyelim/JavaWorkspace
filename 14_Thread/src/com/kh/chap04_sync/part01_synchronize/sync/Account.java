package com.kh.chap04_sync.part01_synchronize.sync;

// 공유자원
// 2개의 스레드가 동시에 Account(계좌)에 접근하는 상황을 가정
public class Account {
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	/*
	 * 출금메서드 : atm기(스레드)에서 사용하는 메서드
	 * 
	 * 동기화처리 방법
	 * 1. 메서드 동기화 : 메스드의 예약어로 synchronized를 추가
	 * 	 - 메서드를 호출하는 순간, 호출한 스레드에게 key가 전달되고, 메서드 종료시 스레드는 key를 반납
	 * 	 - 메서드 전체에 lock을 걸면 성능이 매우 떨어짐
	 * 	 => 따라서 동기화가 필요한 코드영역에만 동기화블럭을 사용
	 * 
	 * 2. synchronized block사용하기 (추천)
	 * 	 - 동기화가 필요한 메서드의 일부 코드 블락에 Lock을 거는 방법
	 * 	 - 임계영역이 아닌 지역까지는 모든 스레드가 접근 가능하기 때문에,
	 * 		메서드 전체에 Lock을 거는 1번 방법보다 효율이 좋다
	 * 
	 */
	public /*synchronized*/ void withdraw(int money) {
		String thName = Thread.currentThread().getName();
		synchronized(this) { // 임계영역은 최소한으로만 지정하는게 좋음
			System.out.println("현재 계좌의 잔액 : "+balance);
			if(money <= balance) {
				balance -= money;
				System.out.printf("[%s] %d원 출금시도 >>> 잔액 : %d원\n", thName, money, balance);
			} else {
				System.out.printf("[%s] %d원 출금시도 >>> 잔액이 부족합니다.\n", thName, money);
			}
		}
	}
}
