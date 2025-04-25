package com.kh.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	public void practice1() {
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice2() {
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int length = sc.nextInt();
		
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice4() {
		String[] arr = new String[5];
		arr[0] = "사과";
		arr[1] = "귤";
		arr[2] = "포도";
		arr[3] = "복숭아";
		arr[4] = "참외";
		System.out.println(arr[1]);
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		System.out.print("문자 : ");
		char c = sc.nextLine().charAt(0);
		
		char[] arr = str.toCharArray();
		int count = 0;
		System.out.print(str+"에 "+c+"가 존재하는 위치(인덱스) : ");
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == c) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println(c+" 개수 : "+count);
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();
		
		String[] day = {"월요일","화요일","수요일","목요일","금요일","토요일","일요일"};
		
		if(num < 0 || num > day.length - 1) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		System.out.println(day[num]);
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int length = sc.nextInt();
		
		int[] arr = new int[length];
		int sum = 0;
		
		for(int i = 0; i < length; i++) {
			System.out.print("배열 "+i+"번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			
//			int value = sc.nextInt();
//			arr[i] = value;
//			sum += value;
		}
		for(int i : arr) {
			System.out.print(i+" ");
			sum += i;
		}
		System.out.println();
		System.out.println("총 합 : "+sum);
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num % 2 == 0 || num < 3) {
			System.out.println("다시 입력하세요.");
			practice8();
			return;
		}
		int[] arr = new int[num];
		int value = 1;
		
		for(int i = 0; i < num; i++) {
//			arr[i] = value;
//			if(i < num/2) value++;
//			else value--;
			
			if(i < num/2) arr[i] = value++;
			else arr[i] = value--;
		}
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("치킨 이름을 입력하세요 : ");
		String chk = sc.nextLine();
		
		String[] menu = {"양념","후라이드","반반"};
		
		//boolean hasMenu = false;
		for(String s : menu) {
			if (s.equals(chk)) {
				//hasMenu = true;
				System.out.println(chk+"치킨 배달 가능");
				//break; 효율 증가
				return;
			}
		}
		//if (!hasMenu) 
			System.out.println(chk+"치킨은 없는 메뉴입니다.");
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String id = sc.nextLine();
		
		char[] idArr = id.toCharArray();
		char[] copy = new char[idArr.length];
		
		for(int i = 0; i < idArr.length; i++) {
			copy[i] = (i < 8 ? idArr[i]:'*');
			//System.out.print(i < 8 ? idArr[i]:'*');
		}
		for(char c : copy) {
			System.out.print(c);
		}
	}
	
	public void practice11() {
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice12() {
		int[] arr = new int[10];
		
		//난수 생성 후 어레이에 대입
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		//최대,최소값 구하기
		int min = arr[0];
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
	}
	/*
	public void practice13() {
		int[] arr = new int[10];
		
		int index = 0;
		boolean isin = false;
		
		while(arr[arr.length-1] == 0) {
			int value = (int)(Math.random() * 10 + 1);
			
			for(int i : arr) {
				if (value == i) {
					isin = true;
					break;
				} else {
					isin = false;
				}
			}
			if(!isin) {
				arr[index++] = value;
			}
		}
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}*/
	public void practice13() {
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			// 5 0 0 0 0 0 0 0 0 0 1회 반복(인덱스:0)
			// 5 x 0 0 0 0 0 0 0 0 (인덱스:1) 2회 반복시에는 0번 인덱스의 값이 중복인지 검사
			// 5 6 x 0 0 0 0 0 0 0 (인덱스:2) 3회 반복시에는 0번,1번 인덱스의 값들과 검사
			// 5 6 7 x 0 0 0 0 0 0 (인덱스:3) 4회 반복시에는 0,1,2번 인덱스의 값들과 검사
			// x번째 인덱스에 랜덤값 추가시 0부터 x-1번째 인덱스의 값들과 중복 검사
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					// 중복랜덤값 존재
					i--; // i값 감소
					break;
				}
			}
		}
		System.out.print(Arrays.toString(arr));
	}
	
	public void practice14() {
		int[] lotto = new int[6];
		
		int index = 0;
		boolean isin = false;
		
		while(lotto[lotto.length-1] == 0) {
			int value = (int)(Math.random() * 45 + 1);
			
			for(int i : lotto) {
				if (value == i) {
					isin = true;
					break;
				} else {
					isin = false;
				}
			}
			if(!isin) {
				lotto[index++] = value;
			}
		}
		System.out.println(Arrays.toString(lotto));
		
		//중첩반복문 
		//외부반복문 반복횟수 ?
		//내부반복문 반복구조 ?
		//버브소트 -> 가까운 두 값을 비교하여 가장 큰 값을 마지막으로 옮기는 정렬방식
		
		//첫번째 검사(i=0): 0, 1 | 1, 2 | 2, 3 | 3, 4 | 4, 5 (5-0=5번 검사)
		//두번째 검사(i=1): 0, 1 | 1, 2 | 2, 3 | 3, 4		  (5-1=4번 검사)
		//세번째 검사(i=2): 0, 1 | 1, 2 | 2, 3				  (5-i=3번 검사)
		//=> 반복 안해도되는부분 제거해서 효율증대
		
		for(int i = 0; i < lotto.length - 1; i++) {
			for(int j = 0; j < lotto.length - 1 - i; j++) {
				if(lotto[j] > lotto[j+1]) {
					// ex) 45 > 30
					int temp = lotto[j+1]; //템프 변수에 30를 저장
					lotto[j+1] = lotto[j]; //30자리에 45를 저장 (뒤쪽 인덱스에 앞쪽 인덱스의 값을 저장)
					lotto[j] = temp; //45자리에 30(템프)를 저장 (앞쪽 인덱스에 뒤쪽 인덱스의 값을 저장)
				}
			}
		}
		
		/* 
		//총 6번동안 1번2번 비교하고 자리바꿈, 2번3번 비교하고 자리바꿈...
		//결국 한 번 반복할때마다 가장 큰 수가 맨 뒤로 가게 됨
		int count = 0;
		while(count < lotto.length) {
			for(int i = 0; i < lotto.length - 1; i++) {
				int left = lotto[i];
				int right = lotto[i+1];
				
				if(right < left) {
					int num = right;
					lotto[i+1] = left;
					lotto[i] = num;
				}
			}
			count++;
		}
		
		//총 5번동안, 1번째~6번째 중에 최소값 구해서 1번째랑 자리바꿈,
		//2번째에는, 2번째~6번째 중에 최소값 구해서 2번째랑 자리바꿈,
		//마지막 5번째에는, 5번째~6번째 중에 최소값 구해서 5번째랑 자리바꿈
		int idx = 0;
		for(int i = 0; i < lotto.length - 1; i++) {
			int min = lotto[i];
			for(int j = i + 1; j < lotto.length; j++) {
				if(min > lotto[j]) {
					idx = j;
					min = lotto[j];
				}
			}
			lotto[idx] = lotto[i];
			lotto[i] = min;
		}
		*/
		for(int i : lotto) {
			System.out.print(i+" ");
		}
	}
	
	
	public void practice15() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		char[] chArr = new char[str.length()];
		
		int index = 0;
		int count = 0;
		boolean isEqual = false;
		for(int i = 0; i < str.length(); i++) {
			for(char c : chArr) {
				if(str.charAt(i) == c) {
					isEqual = true;
					break;
				} else {
					isEqual = false;
				}
			}
			if(!isEqual) {
				chArr[index++] = str.charAt(i);
				count++;
			}
		}
		
		System.out.print("문자열에 있는 문자 : ");
//		for(char c : chArr) {
//			System.out.print(c+" ");
//		}
		for(int i = 0; i < count; i++) {
			System.out.print(chArr[i] + (i != count-1 ? ", ":""));
		}
		System.out.println();
		System.out.print("문자 개수 : "+count);
	}
	
	/*
	public void practice15() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		char[] origin = str.toCharArray();
		char[] arr = new char[str.length()];
		
		int index = 0;
		System.out.print("문자열에 있는 문자 : ");
		
		for(int i = 0; i < origin.length; i++) {
			char ch = origin[i];
			boolean result = false;
			for(int j = 0; j < index; j++) {
				if(arr[j] == ch) {
					//arr에 이미 추가된 데이터
					result = true;
					break;
				}
			}
			if(!result) {
				arr[index++] = ch;
			}
		}
		char [] arr2 = new char[index]; //뒤쪽에 비어있는 공간 정리
		System.arraycopy(arr, 0, arr2, 0, index);
		
		//맨뒤는 콤마없이 출력하기 위해
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + (i != index-1 ? ", ":""));
		}
		System.out.println("\n문자 개수 : "+index);
	}
	*/
	
	/*
	public void practice16() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int length = sc.nextInt();
		char ans = 'Y';
		sc.nextLine();
		
		String[] arr = new String[length];
		int i = 1;
		
		do {
			if(i != 1) {
				arr = Arrays.copyOf(arr, length);
			}
			for( ; i <= length; i++) {
				System.out.print(i+"번째 문자열 : ");
				arr[i-1] = sc.nextLine();
			}
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			ans = sc.nextLine().charAt(0);
			
			if(ans == 'y' || ans == 'Y') {
				System.out.print("더 입력하고 싶은 개수 : ");
				length += sc.nextInt();
				sc.nextLine();
			}
		} while(ans == 'Y' || ans == 'y');
		System.out.println(Arrays.toString(arr));
	}*/
	
	public void practice16() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		sc.nextLine();
		
		String[] str = new String[size];
		for(int i = 0; i < size; i++) {
			System.out.printf("%d번째 문자열 : ", i+1);
			str[i] = sc.nextLine();
		}
		while(true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char ch = sc.nextLine().toLowerCase().charAt(0);
			
			if(ch == 'n') {
				System.out.println(Arrays.toString(str));
				return;
			}
			System.out.print("더 입력하고 싶은 개수 : ");
			int moreSize = sc.nextInt();
			sc.nextLine();
			// 저장공간 부족(크기 못늘림!) => 깊은 복사를 해서 새롭게 만들기
			
			String[] copy = new String[str.length + moreSize];
			System.arraycopy(str, 0, copy, 0, str.length); //깊은 복사 완료
			
			for(int i = str.length; i < copy.length; i++) {
				System.out.printf("%d번째 문자열 : ", i+1);
				copy[i] = sc.nextLine();
			}
			str = copy; // n입력했을때 str을 출력하니까 얕은복사를 통해 반복할때마다 업데이트
		}
	}
	
}
