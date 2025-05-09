package com.kh.chap_list.arrayList.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.kh.chap_list.arrayList.model.vo.Music;
import com.kh.chap_list.arrayList.model.vo.MusicArtistDescending;

public class Run {
	/*
	 * 컬렉션(Collection) 인터페이스
	 * 	 - 자료구조가 내장되어 있는 클래스로, 자바에서 제공하는 "자료구조"담당 프레임워크
	 * 
	 * 자료구조
	 * 	 - 메모리상에서 데이터들을 효율적으로 다루기 위해 필요한 개념
	 * 
	 * 프레임워크
	 * 	 - 효율적인 기능들이 정의되어 있는 틀
	 * 
	 * 배열과 List(선형구조의 데이터)인터페이스의 차이점
	 * 1. 배열의 특징
	 * 	 - 동일한 자료형의 데이터를 관리
	 * 	 - 한 번 선언한 후 크기가 고정
	 * 	 - 데이터 저장 외 기능이 존재하지 않음
	 * 2. List의 특징
	 * 	 - 여러타입의 데이터를 동시에 보관할 수 있음(내부적으로 Object 클래스 배열 사용하기 때문)
	 * 		컬렉션을 다룰때 힘들다. 꺼낼 값이 어떤 객체인지 알 수 없기 때문에 => 제네릭
	 * 	 - 크기에 제약이 없음(자동으로 깊은복사해서 수정하기 때문)
	 * 		=> 수정불가능하게 하려면 다른종류의 리스트 클래스를 사용해야 함
	 * 	 - 다양한 기능들이 정의되어 있음
	 * 
	 * 컬렉션의 3가지 분류
	 * 1. List계열
	 * 	 - 담고자하는 값만을 관리하는 클래스
	 * 	 - 값을 저장할 때 인덱스를 활용하여 저장 순서를 유지
	 * 	 - 중복된 값이 들어와도 문제 없다
	 * 	 - 대표클래스 : "ArrayList"(동기화X), Vector(동기화 지원O), LinkedList, ...
	 * 
	 * 매우 큰 배열데이터의 중간에서 수정/삽입/삭제가 빈번하게 일어나는 경우
	 * head와 tail로 앞/뒤 데이터의 주소값을 보관하는 LinkedList를 통해
	 * 특정 상황에서 효율성을 증대시킬 수 이씀
	 * 하지만 추가적인 메모리 공간이 더 필요하기 때문에 일반적인 상황에서는 어레이리스트가 효율적
	 * 
	 * 2. Set계열
	 * 	 - 담고자하는 값만을 관리하는 클래스
	 * 	 - 값을 저장할 때 인덱스를 사용하지 않기 때문에 저장순서가 유지되지 않는다
	 * 	 - 중복값을 허용하지 않는다(Set계열만의 독특한 특징)
	 * 	 - 저장된 값이 곧 저장위치가 된다
	 * 	 - 대표클래스 : HashSet(Hash~ 저장속도가 빠름), TreeSet(저장순서를 유지 가능) 
	 * 
	 * 3. Map계열
	 * 	 - 담고자하는 값과 그 "값"을 꺼낼수 있는 "키"를 함께 저장하는 클래스
	 * 	 - 값을 저장할 때 인덱스를 사용하지 않기 때문에 저장순서가 유지되지 않는다
	 * 	 - key값은 중복을 허용하지 않으나, value값은 중복을 허용한다
	 * 	 - 대표클래스 : HashMap, Properties(key, value값을 무조건 문자열로만 저장함)
	 */
	public static void main(String[] args) throws Exception {
		ArrayList list = new ArrayList(); //Object객체배열
		ArrayList<String> list2 = new ArrayList</*생략가능*/>(3); //String객체배열
		// 제네릭<E>
		// 컬렉션에 저장할 객체의 타입을 고정하기 위해 사용하는 타입변수(E:자료형을 저장할 수 있는 변수)
		
		ArrayList<Music> list3 = new ArrayList<Music>(3);
		System.out.println(list3); // [] 실제로는 null이 3개 들어있지만 출력되지 않고있음
		// capacity(저장용량):3, size:몇개의 데이터가 초기화되어 있는가
		
		/*
		 * 1. add(E e) : 리스트(사이즈)의 끝에 e를 저장하는 메서드
		 * 2. add(int index, E e) : 인덱스 위치에 e값을 추가하는 메서드
		 * 3. set(int index, E e) : 리스트의 인덱스 위치의 값을 e로 "변경"시켜주는 메서드
		 * 4. remove(int index) : 인덱스 위치에 저장된 데이터를 삭제시켜주는 메서드
		 * 5. size() : 리스트에 초기화된 데이터의 수를 반환해주는 메서드
		 * 6. get(int index) : 인덱스 위치의 데이터를 반환해주는 메서드
		 * 7. contains(E e) : boolean -> e요소를 컬렉션이 포함하고 있는지 확인
		 * 		포함한다면 true, 포함하지 않는다면 false 값 반환
		 * 8. indexOf(E e) : e요소가 컬렉션의 몇 번 index에 있는지 확인하는 메서드
		 * 9. subList(int index1, int index2) : 리스트의 index1부터 index2전까지의 데이터를
		 * 		추출하여 새로운 List를 반환해주는 메서드
		 * 10. addAll(Collection c) : 현재 리스트에 컬렉션에 들어간 모든 데이터를 추가하는 메서드
		 * 11. isEmpty() : 컬렉션이 비어있으면 true 아니라면 false
		 * 12. clear() : 리스트를 비워주는 메서드
		 * 13. Collections.sort() : 정렬 메서드
		 * 14. Collections.shuffle() : 내부 데이터를 섞는 메서드
		 */
		list3.add(new Music("someone like you", "Adele"));
		list3.add(new Music("너의 번호를 누르고", "박명수"));
		list3.add(new Music("벚꽃엔딩", "장범준"));
		
		list3.add(1,new Music("바다의 왕자", "박명수"));
		// 배열의 용량(capacity)보다 더 많은 데이터를 저장하는 경우,
		// 기존 배열보다 크기가 1.5배 더 큰 배열을 생성한 후 깊은 복사를 한다(System.arraycopy(C언어))
		// index자리에 바로 다음칸 index까지 추가 가능(맨뒷자리에 저장) 넘어서면 outofbound exception
		
		list3.set(0,new Music("불장난","에스파"));
		list3.remove(0);
		System.out.println("리스트에 담긴 데이터의 수 : "+list3.size());
		System.out.println(list3);
		
		Music m = list3.get(0);
		System.out.println(m.getTitle());
		System.out.println(list3.get(1).getArtist());
		
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(1);
		list4.add(9);
		list4.add(900);
		System.out.println(list4.contains(900));
		System.out.println(list4.indexOf(9));
		
		System.out.println(list3.contains(new Music("벚꽃엔딩", "장범준")));
		// Music 클래스에서 equals()메서드를 재정의한다면 true값 반환시킬 수 있음
		// 원래대로라면 object 클래스의 equals()메서드를 이용해 주소값을 비교하기 때문에 false가 반환됨
		
		System.out.println(new Music("벚꽃엔딩", "장범준").hashCode());
		System.out.println(new Music("벚꽃엔딩", "장범준").hashCode());
		// equals()메서드를 재정의 한다면 항상 hashCode() 메서드도 재정의 해야함
		// arraylist에서는 괜찮지만 set/map 계열에서는 hashcode() 메서드를 활용해 비교하기 때문에
		// => 논리적, 물리적으로 같은 객체가 됨
		
		// 컬렉션의 장점! /////////////////////////////////////////////////////////////////////
		// 반복문을 활용하여 데이터 출력 
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i));
		}
		System.out.println("==============================");
		for (Music m2 : list3) { // 컬렉션계열(list, set)은 사용가능(map 사용불가)
			System.out.println(m2);
		}
		System.out.println("==============================");
		// Iterator 반복자
		// 컬렉션 내부 인자들을 Iterator로 토큰단위로 관리 (스트링토크나이저랑 비슷한 메커니즘)
		Iterator<Music> iter = list3.iterator();
		while(iter.hasNext()) {
			Music m2 = iter.next();
			System.out.println(m2);
		}
		//////////////////////////////////////////////////////////////////////////////////
		
		List<Music> sub = list3.subList(0, 2);
		System.out.println(sub);
		
		sub.set(0,new Music("불장난","에스파")); // 내용 바꾸고 addAll 하면 똑같이 내용바뀜
		// subList()메서드와 addAll()메서드 둘 다 얕은복사 중이기 때문
		
		list3.addAll(sub);
		System.out.println(list3);
		
		System.out.println(list3.isEmpty());
//		list3.clear();
		System.out.println(list3);
		System.out.println(list3.isEmpty());
		
		List<String> list5 = new ArrayList<>();
		list5.add("가경민");
		list5.add("다경민");
		list5.add("라경민");
		list5.add("나경민");
		System.out.println(list5);
		
		Collections.sort(list5); // 기본정렬조건에 따라 정렬시켜주는 메서드(오름차순 정렬)
		System.out.println(list5);
		
		// 역순으로 정렬하고자 하는 경우
		Collections.reverseOrder(); // 역순정렬조건을 가진 객체
		Collections.sort(list5, Collections.reverseOrder());
		System.out.println(list5);
		
		/*
		 * VO 클래스를 정렬하기 위한 방법
		 * 1. Comparable 인터페이스 상속
		 * 	 - VO클래스에 직접 상속시켜서 사용
		 * 	 - 해당 클래스의 기본정렬조건으로 적용(오버로딩 불가)
		 * 2. Comparator 인터페이스 상속
		 * 	 - 기본정렬조건 외의 추가 정렬조건을 만들고자 할 때 사용
		 * 	 - VO클래스 이외 별도의 클래스에 Comparator를 상속시켜서 구현
		 */
		
		System.out.println("================================");
		// 기본정렬조건 적용 전 -> 컴파일 에러
		Collections.sort(list3);
		// 두번째 매개변수에 comparator가 없을 경우 String의 기본정렬조건을 사용했지만
		// 이 경우 Music에 comparable 인터페이스 상속받지 않았기 때문에 안됨
		System.out.println(list3);
		
		// 가수이름 오름차순 정렬
		//	 - 기본정렬조건과 다르므로, Comparator를 사용
		Comparator<Music> comp = new MusicArtistDescending();
		Collections.sort(list3, comp);
		
		Collections.shuffle(list3);
		System.out.println(list3);
	}
}
