package com.kh.chap03_stream.part03_optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalMethods {
	/*
	 * Optional
	 * 	 - 스트림에서 null(비어있는)값을 안전하게 다루기 위한 클래스
	 * 	 - 즉, 존재할 수도 있고 안할수도 있는 객체를 다루기 위한 클래스
	 * 	 - Optional로 다루게 될 변수는 변수명에 암묵적으로 Optional임을 나타내는 키워드를 추가해야함
	 * 		ex) maybeXXX, optXXX
	 */
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","신사",null,"");
		list.stream()
			.forEach(str -> {
				System.out.println(str+" : "+getStrLength(str));
			});
		
		Member member = new Member();
		member.setEmail("rudals@naver.com"); // id생략 = null;
		Order order = new Order();
		order.setMember(member); // count생략 = 0;
		
		System.out.println(getEmailOfMember(order));
		System.out.println(getEmailOfMember(null));
		System.out.println(getEmailOfMember(new Order()));
	}
	
	public static String getEmailOfMember(Order order) {
		/*
		// 사용자의 email을 "안전하게" 얻어오기 (defensive coding)
		if(order != null && order.getMember() != null) { // 연산자 주의해야함
			// 왜냐? 앞 조건에 따라서 뒤 조건을 볼수도있고 안볼수도 있어서 잘못하면 널포인터 익셉션 뜰수도있음
			Member m = order.getMember();
			if(m != null) {
				String email = m.getEmail();
				return email;
			}
		}
		return null;
		*/
		// 옵셔널을 통한 null값 처리
		// 객체 안에 객체가 중첩된 경우에 직접 명령형 프로그램을 작성하는 것보다 덜 까다로움
		return Optional
			.ofNullable(order)
			.map(or -> or.getMember()) // Optional 내부에서 처리되기 때문에 널포인터? ㄱㅊㄱㅊ
			.map(mem -> mem.getEmail())
			.orElse("메일이 존재하지 않습니다.");
	}
	
	public static int getStrLength(String str) {
		// Optional을 통해 null 처리
		// Optional 객체 생성
		// 1. Optional.empty() : 비어있는 옵셔널 객체
		// 2. Optional.of(obj) : null이 아닌 객체를 담은 옵셔널 객체(절대 널일리 없다는 보장이 있을때만)
		// 3. Optional.ofNullable(obj) : null일수도 있는 객체를 담은 옵셔널 객체
		Optional<String> maybeStr = Optional.ofNullable(str);
		// 함수형 프로그래밍 방식으로 널 처리
		return maybeStr.map(s -> s.length()) // s가 널이 아닌 경우
						.orElse(0); // s가 널인 경우
						//.orElseGet(() -> 0); // s가 널인경우 사용할 람다식
						//.orElseThrow(() -> new RuntimeException());
						// s가 널일경우 호출할 에러(기본값:noSuchElementException)
	}
	
	static class Order {
        Member member;
        int count;
        public Order() {
        }
        public Member getMember() {
            return member;
        }
        public void setMember(Member member) {
            this.member = member;
        }
        public int getCount() {
            return count;
        }
        public void setCount(int count) {
            this.count = count;
        }
        public Order(Member member, int count) {
            super();
            this.member = member;
            this.count = count;
        }
        @Override
        public String toString() {
            return "Order [member=" + member + ", count=" + count + "]";
        }
    }
	
    static class Member {
        String id;
        String email;
        public Member() {
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public Member(String id, String email) {
            super();
            this.id = id;
            this.email = email;
        }
        @Override
        public String toString() {
            return "Member [id=" + id + ", email=" + email + "]";
        }
    }
}
