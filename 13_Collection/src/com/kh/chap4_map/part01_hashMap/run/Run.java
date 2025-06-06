package com.kh.chap4_map.part01_hashMap.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap4_map.part01_hashMap.model.vo.Snack;

public class Run {
	/*
	 * HashMap ?
	 * 	 - 많은 양의 데이터를 "빠르게 저장하고 관리"하기 위하여 key, value값을 함께 묶어서 관리하는 자료구조
	 *   - 계층구조를 보면 List, Set 계열과 다른 Map계열 인터페이스만 상속한 클래스로, 사용하는 메서드가 다르다
	 *   - 데이터를 저장할 때 key, value를 한 쌍으로 저장하고, key를 통해 value가 저장된 위치에 접근한다
	 *   - key값의 중복을 허용하지 않는다
	 *   - 동일한 key값에 데이터를 저장하면 마지막으로 추가된 value값이 저장된다
	 */
	public static void main(String[] args) {
		HashMap<String, Snack> hm = new HashMap<>();
		// 문자열 key값에 Snack value를 저장(두가지 데이터를 한 쌍으로 객체로 만들어서 보관)
		
		// 1. put(K key, V value) : map공간에 key, value를 세트로 추가하는 메서드
		hm.put("다이제", new Snack("초코맛",1500));
		hm.put("칸초", new Snack("초코맛",600));
		hm.put("새우깡", new Snack("짠맛",500));
		hm.put("포테이토칩", new Snack("짠맛",500));
		System.out.println(hm);
		
		hm.put("새우깡", new Snack("매운맛",700));
		System.out.println(hm);
		// key값이 중복된 경우, 마지막 value로 덮어씌워짐
		
		// 2. get(K key) : V => Hashmap에서 key와 일치하는 value값을 찾는 메서드
		System.out.println(hm.get("다이제"));
		
		// 3. size() => hashMap에 초기화된 데이터 수(해시맵도 결국 Node라는 객체배열임)
		System.out.println(hm.size());
		
		// 4. replace(K key, V value) => hashMap에서 key값과 일치하는 값을 찾아, 새로 전달된 value로 교체하는 메서드
		// put()과의 차이점: key값을 찾지 못할경우 새로 추가되지 않고 아무일도 발생하지 않음(완전히 교체 용도로만 사용)
		hm.replace("포테이토칩", new Snack("피자맛",1000));
		System.out.println(hm);
		
		// 5. remove(K key) => hashMap에서 key값과 일치하는 값을 찾아서 삭제 해주는 메서드(key+value 함께 삭제)
		System.out.println(hm.remove("칸초")); // 삭제 후 삭제한 값을 반환(데이터 이동 시 사용)
		System.out.println(hm);
		
		// hashMap 반복문 돌려보기
		System.out.println("==================================================");
		// hashMap을 반복시키는 방법
		// 1. keySet()을 활용한 반복
		//    - hashMap의 key값들을 따로 Set에 담아서 반환해주는 메서드
		Set<String> keySet = hm.keySet();
		System.out.println(keySet);
		for(String key : keySet) {
			System.out.println(hm.get(key));
		}
		
		// 2. entrySet()을 활용한 반복 (Node의 옛날이름: Entry)
		//	  - hashMap의 key, value값이 담긴 entry를 Set에 담아서 반환해주는 메서드
		Set<Entry<String,Snack>> entrySet = hm.entrySet();
		Iterator<Entry<String,Snack>> iter = entrySet.iterator();
		while(iter.hasNext()) {
			Entry<String,Snack> entry = iter.next();
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
		}
	}
}
