package com.kh.chap_list.arrayList.run;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.kh.chap_list.arrayList.model.vo.Music;

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
		ArrayList list2 = new ArrayList<String>(3); //String객체배열
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
		
		int a = 10;
		System.out.println(a >> 1); // 5
	}
}
