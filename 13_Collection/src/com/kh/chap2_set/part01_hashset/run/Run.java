package com.kh.chap2_set.part01_hashset.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.kh.chap2_set.part01_hashset.model.vo.Student;

public class Run {
	public static void main(String[] args) {
		/*
		 * Set
		 * 	 - 중복을 허용하지 않는 자료구조
		 * 	 - 저장된 순서를 보장하지 않는다
		 * HashSet		 : 중복을 허용하지 않지만, 빠르게 저장이 가능
		 * LinkedHashSet : 중복을 허용하지 않지만, 저장된 순서는 유지
		 * TreeSet		 : 중복을 허용하지 않지만, 오름차순 정렬을 지원
		 */
		HashSet<String> hs1 = new HashSet<>();
		hs1.add("반갑습니다"); // add : 값추가
		hs1.add("반갑습니다");
		hs1.add("여러분");
		hs1.add("여러분");
		hs1.add("안녕하세요");
		System.out.println(hs1); // 중복값X, 순서유지X
		System.out.println(hs1.size());
		
		hs1.remove("여러분"); // 해시코드 사용해서 삭제할 값을 제시
		System.out.println(hs1);
		
		System.out.println("============================");
		// index가 없기 때문에 기본반복문 사용 불가
		for(String s : hs1) { // Iterator 인터페이스 구현되어 있음
			System.out.println(s);
		}
		// set계열을 list계열로 옮겨 담는 방법들
		ArrayList<String> list = new ArrayList<>(hs1); // 컬렉션의 데이터를 배열에 모두 담은 상태로 리스트 생성
		list.addAll(hs1);
		System.out.println(list);
		
		// Iterator 사용이 가능하다 == 향상된 반복문을 사용할 수 있다
		Iterator<String> it = hs1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("==============================");
		
		HashSet<Student> hs2 = new HashSet<>();
		hs2.add(new Student("공유", 40, 100));
		hs2.add(new Student("홍길동", 20, 10));
		hs2.add(new Student("김유신", 20, 30));
		hs2.add(new Student("공유", 40, 100));
		System.out.println(hs2); // 4명 출력. 두 공유가 주소값이 다른 객체이기 때문
		// 논리적으로 같은 데이터를 가졌다면 같은 객체라고 판단하고 싶다 => hashCode() 재정의해서 저장위치 찾아감
		// equals()를 재정의하지 않았기 때문에 우연히 해시코드가 겹친 다른객체라 판단 => 바로 뒤에 데이터 저장
		
		/*
		 * HashSet에 객체를 저장할 때는
		 * 1. 객체의 hashCode()함수로 저장할 위치를 찾아가고
		 * 2. 저장한 위치에 이미 저장된 값이 있다면 equals()를 통해 저장된 값과 새로 추가할 값이 같은지 검사한다
		 * 3. 두 값이 같다면, 데이터를 중복으로 저장하지 않고, 두 값이 다르다면 저장된 값의 다음위치에 새로운 값을 저장한다
		 */
		
		// LinkedHashSet : 저장순서 유지
		Set<Integer> set1 = new LinkedHashSet<>();
		set1.add(34); 	// current : 34, next : null
		set1.add(4545); // current : 34, next : 4545
						// current : 4545, next : null
		set1.add(111);	// current : 34, next : 4545
						// current : 4545, next : 111
						// current : 111, next: null
		set1.add(1);
		System.out.println(set1);
		// 왜 링크드리스트는 next만 사용하지않고 헤드,테일을 같이 보관할까???
		// 삭제시에는 큰 문제 없지만 값을 추가할 때 더 효율적임-
		
		// TreeSet -> 정렬
		// set내부에 데이터가 추가될 때 compare, compareTo 메서드를 자동 실행
		Set<Integer> set2 = new TreeSet<>(set1); // comparator 구현을 하지 않았기 때문에 compareTo 메서드가 실행될 것
		System.out.println(set2);
		// ArrayList, set을 매개변수로 추가시 안에 담긴 데이터의 기본정렬방식대로 정렬
		// Comparator 객체를 추가하면, 이후 set에 데이터를 추가할 때 Comparator에 정의한 정렬조건대로 정렬이 이루어진다
		// 두번째 매개변수가 없기 때문에 이 경우 생성자를 통한 초기화가 불가하다. add또는 addAll을 사용해야함
	}
}
