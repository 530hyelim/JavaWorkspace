package com.kh.chap4_map.part02_clone.run;

import com.kh.chap4_map.part01_hashMap.model.vo.Snack;

public class HashMapRun <K, V> {
	private Entry<K, V>[] table;
	private int capacity; // 배열의 크기
	private int size; // 초기화된 수
	
	class Entry <K, V> { // Inner클래스: 현재 클래스(패키지)내부에서만 사용 가능한 클래스
		// 해시맵런 클래스에 존속이 되면서 해시맵런 클래스만을 위한 클래스가 된다
		K key;
		V value;
		Entry<K, V> next;
		
		public Entry(K key, V value, Entry<K,V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public HashMapRun(int capacity) {
		this.capacity = capacity;
		table = new Entry[capacity];
	}
	
	public static void main(String[] args) {
		HashMapRun<String,Snack> hm = new HashMapRun<>(10);
		hm.put("다이제", new Snack("초코맛", 1500));
		hm.put("칸초", new Snack("단맛", 600));
		hm.put("새우깡", new Snack("짠맛", 500));
		hm.put("포테이토칩", new Snack("짠맛", 500));
		System.out.println(hm.get("새우깡"));

		hm.put("새우깡", new Snack("매운맛", 700));
		System.out.println(hm.get("새우깡"));
		
		hm.remove("포테이토칩");
		System.out.println(hm.get("포테이토칩"));
	}
	
	public int getIndex(K key) {
		// 매개변수로 전달받은 key값을 활용하여 table에 저장할 인덱스 위치를 구하는 함수
		// key값에 hashcode()를 적용
		// index를 increment하면서 값을 저장하지 않는 이유 => 빨라서
		return Math.abs(key.hashCode()) % capacity;
		// hashCode값이 음수일 수 있으므로, 절대값으로 변환
		// 배열의 크기만큼 나머지 연산 수행
		// 113355 % 10 => 5번인덱스
		// 12345678 % 10 => 8번인덱스
		// 77778888 => 해시충돌!
	}
	
	public void put(K key, V value) {
		int index = getIndex(key);
		Entry<K, V> newEntry = new Entry<>(key, value, null);
		
		// table의 index위치에 값이 초기화 되어있는지 확인하기
		if(table[index] == null) {
			table[index] = newEntry;
		} else {
			// index위치에 이미 초기화된 데이터가 들어가 있다면?
			// 1) 중복 키 값 => 덮어쓰기
			if(table[index].key.equals(newEntry.key)) {
				table[index].value = newEntry.value;
				// 혹시라도 next가 초기화되어있을수도 있기 때문에 value값만 바꿈
				return; // size가 추가되지 않도록 종료
			} else {
				// 2) 우연히 hashcode중복으로 충돌이 발생한 경우
				//	 => key값에 저장된 entry의 next에 newEntry를 저장
				
				// 이론상 무한으로 해시값이 충돌할 수 있기 때문에 반복문을 통해 next를 검사
				// ("다이제", "칸초", "새우깡" 모두 같은 인덱스를 공유하는 경우)
				Entry<K, V> next = table[index];
				while(true) {
					if(next.key.equals(newEntry.key)) {
						next.value = newEntry.value;
						return;
					}
					if(next.next == null) {
						next.next = newEntry;
						break;
					}
					next = table[index].next;
				}
			}			
		}
		size++;
	}
	
	public V get(K key) {
		int index = getIndex(key);
		Entry<K, V> e = table[index];
		// 바로 뽑아쓸수 없는 이유: 몇번째 next에 내가 원하는 데이터가 있는지 모르니까 => next 반복하면서 key값 비교
		if(e == null) return null;
		else {
			do {
				if(e.key.equals(key)) return e.value;
				e = e.next;
			} while(e != null);
		}
		return null;
	}
	
	public void remove(K key) { //실제로는 void가 아님
		int index = getIndex(key);
		Entry<K, V> e = table[index];
		
		if(e == null) return;
		
		// next값이 존재할 수도 있어서 그냥 null대입할 수가 없음. 왜냐? next에있는 데이터도 다 날아가니까
		Entry<K, V> prev = null;
		// 두번째 entry부터 삭제가 이루어질 경우, 삭제된 엔트리 이전의 next값에 삭제된 엔트리의 next를 넣어줘야함
		do {
			if (e.key.equals(key)) {			
				// 첫번째 entry인지 확인
				if(e == table[index]) {
					// e.next값이 null이 아니라면 e.next값을 대입
					table[index] = (e.next != null ? e.next : null);
				} else {
					prev.next = e.next;
				}
				size--;
				return;
			}
			prev = e;
			e = e.next;
		} while(e != null);
	}
	
	public int size() {
		return size;
	}
	
	public boolean containsKey(K key) {
		int index = getIndex(key);
		Entry<K, V> e = table[index];
		
		if(e == null) return false;
		do {
			if(e.key.equals(key)) {
				return true;
			}
			e = e.next;
		} while(e != null);
		return false;
	}
}
