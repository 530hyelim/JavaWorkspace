package com.kh.chap02_abstract.part01.run;

import com.kh.chap02_abstract.part01.model.vo.*;

public class Run {
	public static void main(String[] args) {
		//Sports s = new Sports();
		//미구현 메서드가 있는 추상클래스의 경우 객체 생성이 불가능하다
		Sports s; //참수변수로는 사용이 가능하다
		s = new Football(); //다형성을 이용해 부모클래스에 넣는다
		
		Sports[] arr = new Sports[2];
		arr[0] = s;
		arr[1] = new Basketball();
		//자식객체 내부에서 super()생성자를 통해 생성되는건 가능하다
		
		for(int i = 0; i < arr.length; i++) {
			arr[i].rule(); //동적바인딩
		}
		/*
		 * 추상클래스 정리
		 *   - 추상클래스란? 미완성된 부분이 존재하는 클래스임을 의미 (abstract class)
		 *   - 미완성된 클래스이기 때문에 "객체 생성 불가"(단, 참조변수로 사용 가능)
		 *   - 추상메서드가 포함된 경우, 클래스는 반드시 추상 클래스로 정의해야 한다
		 *   - 추상클래스는 "일반 필드, 일반 메서드, 생성자, 추상메서드"로 이루어져 있다
		 *   
		 * 추상메서드
		 *   - 미완성된 메서드로 메서드 몸통부({})가 구현되어있지 않은 메서드
		 *   - 추상메서드는 자식클래스에서 오버라이딩을 통해 완성된다
		 *     (자식클래스에서 오버라이딩 하지 않은 경우 에러가 발생한다)
		 *   - 추상메서드를 통해 클래스간의 통일성을 확보할 수 있다
		 */
	}
}
