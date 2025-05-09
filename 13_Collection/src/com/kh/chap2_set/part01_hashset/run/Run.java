package com.kh.chap2_set.part01_hashset.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

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
	}
}
