package com.kh.array;

import java.util.Arrays;

public class A_Array {
	// 배열/컬렉션(베이스가 배열로 이루어져있다)
	
	/*
	 * 변수 : 하나의 공간에 하나의 값을 담을 수 있다
	 * 배열 : 하나의 공간에 여러개의 값을 담을 수 있음
	 * 		단, "같은 자료형"의 값들만 담을 수 있다
	 * 		int[] arr = new int[3]; // 12바이트의 저장공간을 차지하고 있다
	 * 		=> int 자료형값을 저장할 수 있는 메모리 영역이 3칸 할당된다
	 * 
	 * 		자료형[] 배열명 = new 자료형[배열크기];
	 * 		자료형 배열명[] = new 자료형[배열크기];
	 * 
	 * 		[0,0,0]
	 * 		배열에 저장된 데이터를 꺼낼 때는 인덱스를 활용하며 인덱스는 0부터 시작
	 * 		배열이 생성될 때 인덱스도 자동으로 같이 생성/할당됨
	 * 		arr[0], arr[1], arr[2]
	 * 		배열의 크기가 5, 마지막 인덱스 4
	 * 		=> 배열의 크기가 n이라면 그 배열의 마지막 인덱스는 n-1
	 */
	public void method() {
//		int a = 5;
//		System.out.println(a.hashCode()); => 컴파일에러
		String s = "gg";
		String t = "gg";
		System.out.println(s==t); // true
		System.out.println(s.hashCode());
		System.out.println(t.hashCode()); //같음
		
		int[] arr = {'a'};
		System.out.println(Arrays.toString(arr)); //[97]형변환 일어남
	}
	
	public void method1() {
		// 배열 선언
		int a;
		int[] arr;
		int arr2[]; // 배열은 참조자료형(기본자료형이 아니면 다 참조자료형이다)
		
		/*
		 * 배열 할당
		 * 이 배열에 몇 개의 값들을 보관할건지 그 배열의 크기를 지정해주는 과정
		 * 크기를 지정해주면, 지정한 갯수만큼의 인덱스(저장공간)을 가진 배열이 생성
		 */
		arr = new int[5];
		
		// 선언과 동시에 할당
		int[] arr3 = new int[5]; // [ , , , , ] <- 아직 초기화되지 않음
		// 사실은 [0,0,0,0,0] 기본값이 항상 자동으로 들어간다 
		// 모든참조형: null, char:'', boolean: false, 실수: 0.0
		
		// 배열의 각 인덱스에 값을 대입하고, 추출하는 방법
		arr3[0] = 0;
		arr3[1] = 1;
		arr3[2] = 2;
		// [0,1,2, , ] 실제로는 [0,1,2,0,0] -> JVM이 대신 초기화해줌
		
		System.out.println(arr3[0]); // 0
		System.out.println(arr3[1]); // 1
		System.out.println(arr3[3]); // 컴파일 단계에서 에러발생X
		// 초기화 시키지 않았음에도 0이 출력된다
		
		//System.out.println(a); // 초기화 안해서 컴파일 에러발생
		System.out.println(arr3); // [I@626b2d4a heap메모리 주소값
		// @ 기준으로 좌측은 자료형을 의미 I는 int
		// 우측은 메모리 영역상에서 arr3가 저장된 위치를 16진수 형태(주소값)
		
		String str = "11";
		System.out.println(str); // 11
		System.identityHashCode(str); // 10진수 형태로 주소값
		System.out.println(System.identityHashCode(str));	
		// 객체를 heap메모리에 저장하려면 전부 초기화되어 있어야함
		// 그래서 JVM이 배열생성시 기본값 초기화시켜주는거임
		
		//System.out.println(arr2); //컴파일 에러
		// 배열은 초기화할때 주소값(4/8바이트)이 할당되기 때문
		// stack메모리에 선언만 한 상태에서는 주소값X
		// 모든 (초기화 완료된)참조형은 주소값/혹은 null(기본값)을 가지고있다
	}
	
	public void method2() {
		int num = 10;
		int[] iArr = new int[5];
		
		System.out.println("num : "+num); // 10
		System.out.println("iArr : "+iArr); // 주소값
		System.out.println("iArr의 해시코드값 : "+iArr.hashCode());
		// 주소값을 해시코드(10진수)로 변경
		// garbage collector가 주기적으로 heap메모리의 값들을 정리해줌
		
		int[] iArr2 = new int[5]; // new 키워드를 사용하면 다른 주소값이 나온다
		System.out.println("iArr2의 해시코드값 : "+iArr2.hashCode());
		// 주소값이 다르다
		
		int[] iArr3 = iArr2; // 주소값 복사(얕은 복사)
		System.out.println(iArr3 == iArr2); // true(주소값이 같다)
		// 새로운 배열 객체가 생성되지 않았기 때문에
		// iArr3의 데이터를 변경하면 iArr2의 데이터도 함께 변경된다
	}
	
	public void method3() {
		//배열의 장점 중 하나: 반복문을 사용해서 초기화 가능
		int [] iArr = new int[5];
		
		for(int i = 1; i <= iArr.length; i++) {
			//str.length()는 함수지만 배열의 arr.length는 그냥 field라서 ()쓰면안됨
			//전역변수????? 필드?????? 파란글자??????
			iArr[i - 1] = i;
		}
		//[1,2,3,4,5]
		
		System.out.println(iArr[5]); // 컴파일에러X 실행하면 에러발생
		//에러내용: array index out of bound exception
		//charAt(): string index ~
	}
	
	public void method4() {
		int result = 0;
		String str = null; // ""가 기본값이 아님
		// JVM이 대신 초기화해주게 되면 null이 들어간다
		int [] arr = null;
		
		//System.out.println(arr[0]);
		//System.out.println(str.equals(""));
		//System.out.println(arr.length);
		//null 자체로는 에러가 안나지만 주소값이 없는 상태이기 때문에 
		//이런 값들에 접근하려고 하면 null pointer exception 발생
	}
	
	public void method5( ) {
		int[] arr = new int[5];
		
		/*
		 * arr[0] = 2;
		 * arr[1] = 4;
		 * ...
		 * arr[4] = 10;
		 * 대입을 반복문을 활용하여 작성
		 * 
		 * 반목문을 활용하여 배열에 저장된 값을 출력
		 * 10 8 6 4 2
		 */
		int value = 2;
		for (int index = 0; index < arr.length; index++) {
			//arr[index] = 2 * index + 2;
			arr[index] = value;
			value += 2;
		}
		for (int index = arr.length - 1; index >= 0; index--) {
			System.out.print(arr[index] + " ");
		}
		
		arr[5] = 12;
		//System.out.println(Arrays.toString(arr));
		
		/*
		 * 배열은 한 번 지정한 크기를 변경할 수 없음
		 * => 배열의 크기를 변경하고자 한다면 새로운 배열을 생성해서
		 * 같은 데이터를 가져와 복사/대입해야 한다.
		 * 
		 * 불필요한 메모리 차지를 하게된다
		 * 자바는 가비지컬렉터가 주기적으로 heap의 안쓰는 데이터를 지워주지만
		 * 다른 언어의 경우 개발자가 그 자리에서 정리해주는게 좋음(메모리 최적화)
		 */
		arr = null; //참조형 변수에 null값을 대입하면, 가비지컬렉터가
		//해당 메모리를 즉시 삭제시켜준다.
		
		arr = new int[6];
	}
	
	// 배열의 선언, 할당, 초기화
	public void method6() {
		int[] arr = new int[3]; //할당까지 완료
		//이후 직접 값 추가 or 반복문을 사용하여 초기화
		
		//배열 선언 및 할당과 동시에 초기화하는 방법
		//1.
		int[] arr1 = new int[] {1,2,3,4};
		
		//2.
		int[] arrr = {}; // int[] arrr = new int[0] 으로 바로대입됨
		int[] arr2 = {1,2,3,4};
		
		//arr1 == arr2 //false
	}
	
	public void method7() {
		//문자열을 char배열로 변경
		String str = "wombat";
		char[] arr = str.toCharArray(); //['w','o','m','b','a','t']
		
		System.out.println(Arrays.toString(arr));
		System.out.println(arr); //wombat으로 나오는 이유??????
		//자바가 char 어레이를 string으로 생각해서 그런듯
		
		char[] arr2 = new char[str.length()];
		
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = str.charAt(i);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}
}
