package com.kh.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,6,2,3,3,4,4,11,9,10);
		List<String> strlist = Arrays.asList("a","a","b","b","c","c","d","e","f","g");
		List<Student> slist = List.of(new Student("홍길동",15, 100), 
                new Student("강감찬",16, 80), 
                new Student("이순신",25, 80), 
                new Student("김말똥",29, 90), 
                new Student("아무개",23, 70)); 
		String[] wordArr = { "a b c d", "홍  길동", "h el lo wor ld" }; 
		 
		
		System.out.println("1번 문제 결과 : ");
		list.stream()
			.distinct()
			.filter(i -> i % 2 == 0)
			.forEach(System.out::println);
		
		System.out.println("2번 문제 결과 : ");
		list.stream()
			.distinct()
			.filter(i -> i >= 5 && i % 2 != 0)
			.sorted()
			.forEach(System.out::println);
		
		System.out.print("3번 문제 결과 : ");
		list.stream()
			.map(i -> i * 3)
			.sorted()
			.forEach(i-> System.out.print(i + " "));
		
		System.out.print("\n4번 문제 결과 : ");
		List<String> result4 = strlist.stream()
			//.map(s -> s.toUpperCase())
			.map(String::toUpperCase)
			.collect(Collectors.toList());
		System.out.println(result4);
		
		System.out.print("5번 문제 결과 : ");
		String result5 = strlist.stream()
			.distinct()
			.reduce("",(str, s) -> str += s);
		System.out.println(result5);
		// 초기값이 없을 경우 첫번째 요소가 str에 들어가는데, 
		// 요소 값이 없을 경우가 있으므로 .get() 사용해야함
		
		System.out.print("6번 문제 결과 : ");
		slist.stream()
			.sorted((s1, s2) -> {
				return s1.getName().compareTo(s2.getName());
			})
			/*.sorted(new Comparator<Student>() {
				@Override
				public int compare(Student s1, Student s2) {
					return s1.getName().compareTo(s2.getName());
				}
			})*/
			.forEach(std -> System.out.print(std.getName()
					+ " : " + std.getAge() + " "));
		
		System.out.print("\n7번 문제 결과 : ");
		Double avg = slist.stream()
			.filter(std -> std.getAge() >= 20)
			.mapToDouble(std -> std.getScore())
			.average()
			.getAsDouble();
		System.out.println(avg);
		
		System.out.print("8번 문제 결과 : ");
		List<String> result8 = Arrays.stream(wordArr)
			.map(str -> str.replace(" ",""))
			.collect(Collectors.toList());
		System.out.println(result8);
		
		System.out.println("9번 문제 결과 : ");
		
		IntStream dan = IntStream.range(1, 10);  
		IntStream.range(1, 10).forEach(x ->
			dan.forEach(y -> {
				//if(x != 1)
				System.out.println(x + " * " + y + " = " + x * y);
			}));
		// 내부에 있는 forEach가 한번 반복이 끝나면 스트림이 비워지기 때문에
		// 두번째 반복부터 에러가 나게 됨
		
//		IntStream i = IntStream.range(1, 10);
//		dan.forEach(d -> {
//			i.forEach(num -> {
//				System.out.printf("%d X %d = %d\n", d, num, d * num);
//			});
//		});
//		
//		dan.forEach(d -> {
//			IntStream ii = IntStream.range(1, 10);
//			ii.forEach(num -> {
//				System.out.printf("%d X %d = %d\n", d, num, d * num);
//			});
//		});
		
		System.out.print("10번 문제 결과 : ");
		boolean result10 = Arrays.stream(wordArr)
			.map(str -> str.replace(" ", ""))
			.anyMatch(str -> str.length() >= 8);
		System.out.println(result10);
	}
}
