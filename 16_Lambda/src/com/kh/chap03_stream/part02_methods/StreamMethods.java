package com.kh.chap03_stream.part02_methods;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethods {
	/*
	 * 스트림의 중간연산 메서드들과 최종처리 메서드들
	 * 
	 * 자주 사용되는 중간연산 메서드 (일반적으로 람다식이 들어감)
	 * 1) distinct	: 중복값 제거
	 * 2) filter	: 내부요소 필터링 메서드 => predicate
	 * 3) map		: 데이터 변환 메서드(값과 자료형 모두 변환 가능) => function
	 * 4) peek		: 중간 확인 메서드 => consumer
	 * 5) sort		: 정렬 메서드 => comparator
	 * 		...				...
	 * 
	 * 최종연산 메서드들
	 * 1) Iterating(반복)계열	: forEach
	 * 2) Collecting(요소)계열	: collect(Collector.컬렉션메서드) -> 스트림의 내부 요소를
	 * 		내가 원하는 계열의 컬렉션으로 변환해주는 메서드
	 * 3) Calculating 계열	: min, max, sum, average, ... -> 산술연산 관련 최종처리 메서드
	 * 4) Matching 계열		: anyMatch, allMatch, noneMatch, ... (조건 검사)
	 * 		-> 스트림 내부 요소에서 특정 조건을 만족하는지 검사하기 위해 사용
	 * 		최종적으로 남은 데이터들에 내가 원하는 조건에 일치하는게 있는지 없는지 검사하는 용도로 사용
	 * 5) Reduction 계열		: reduce 메서드를 통해 요소 내부의 값을 다양한 방법으로 연산 후
	 * 		결과값을 반환하는 메서드. Calculating 계열에서 제공하지 않는 기능의 연산을 수행할 때 사용
	 */
	public static void main(String[] args) {
		// 1) distinct, filter, forEach => predicate
		List<Integer> list = Arrays.asList(5,1,2,3,2,4,3,2,1,2,4,5);
		// 배열, 리터럴로 선언과 동시에 초기화 가능
		
		Stream<Integer> stream = list.stream();
		stream
			.distinct() // 내부적으로 자료형에 맞춰서 equals 메서드로 중복값 처리
			.filter((Integer i) -> i % 2 != 0)
			.forEach((Integer i) -> System.out.println(i));
		
		String[] names = {"강감찬","강원래","홍길동","강형욱","초난강"};
		Arrays
			.stream(names)
			.filter(name -> name.startsWith("강"))
			.forEach(System.out::println);
		
		// 2) map : 현재스트림 요소를 다른 요소로 바꾸는 메서드 (데이터,자료형 변환이 핵심)
		//			Function<S,V>의 apply(S) : V
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);
		
		list2.stream() // Stream<Integer>
			.map((i) -> i + "ㅋ") // Stream<String>
			.forEach(System.out::println);
		
		// 3) mapTo(Int/Double/Long) : Stream을 기본자료형 스트림으로 변경해주는 메서드
		//		기본자료형에만 존재하는 메서드를 사용하기 위해 변환
		Arrays
			.stream(names) // Stream<String>
			.mapToInt((String name) -> name.length()) // IntStream으로 변경 완료
			.forEach(System.out::println);
		
		// 4) Collecting 계열
		// 4-1) Collectors.toList() : 스트림 결과를 List로 변환
		List<Integer> newList = list2.stream()
				.map(i -> i * 100)
				.collect(Collectors.toList());
		System.out.println(list2);
		System.out.println(newList); // 배열만 주소값 나옴
		
		// 4-2) Collectors.toSet()	: 스트림 결과를 Set으로 변환
		List<Integer> list4 = Arrays.asList(1,2,3,4,5,4,3,2,1);
		Set<Integer> result = list4.stream()
									.filter(i -> i % 2 == 0)
									.collect(Collectors.toSet());
		System.out.println(result);
		
		// 4-3) Collectors.toMap(Function, Function) : 스트림 결과를 Map으로 변환
							// Key, Value를 넣어줘야 하기 때문에 람다식으로 직접 구현해야함
		Map<Integer, String> result2 = list4
				.stream()
				.distinct()
				.collect(Collectors.toMap(
						n -> n, // key: 1, 2, 3, 4, 5
						//n -> n+""+(n+n)
						//n -> String.valueOf(n)
						String::valueOf
						));
		System.out.println(result2);
		
		// 5) Calculating 계열
		//		- 산술연산시 사용하는 메서드들. 보통 기본자료형 스트림에 존재.
		// 5-1) Sum
		int sum = IntStream.rangeClosed(1, 100).sum();
		System.out.println(sum);
		
		// 5-2) Average
		double avg = IntStream.rangeClosed(1, 100).average().getAsDouble();
		// average()의 반환값: OptionalDouble => 더블 일수도 있고 아닐수도 있는 클래스
		// 스트림에서는 스트림 내부에 널값이 있는 상태에서 애버리지 함수를 할 수도 있어서 에러???
		
		// 5-3) SummaryStatistics : 스트림 요소의 통계값을 가진 객체
		//		(통계값 ? 요소 총 개수, 합, 평균, 최소, 최대)
		IntSummaryStatistics summary = IntStream.of(32,50,80,77,100,28,12)
				.summaryStatistics();
		System.out.println(summary);
		System.out.println(summary.getAverage()); // 특정 통계 결과값도 얻어올 수 있음
		
		// 6) Reduction 계열
		// reduce(초기값, 초기값을 처리하는 람다식)메서드 사용
		int result3 = Arrays
			.asList(1,2,3,4,5,6,7,8,9,10)
			.stream() // binary operator??????
			.reduce(0, (sum2, n) -> { // 첫 번째 매개변수 : 초기값을 저장하는 변수
				// 두 번째 매개변수 : 스트림 내부 요소
				System.out.println("sum2 = " + sum2);
				System.out.println("n = " + n);
				return sum2 + n; // 반환 값 : 초기값으로 다시 전달
			});
		System.out.println(result3);
		
		int result4 = Arrays.asList(1,2,30,4,15,67,7,8,9,10)
			.stream()
			.reduce(0, (max, n) -> {
				return max < n ? n : max;
			});
		System.out.println(result4);
		
		/////////////////////////////////////////////////////////////////
		
		class Member{
            String name;
            int age;
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public int getAge() {
                return age;
            }
            public void setAge(int age) {
                this.age = age;
            }
            public Member(String name, int age) {
                super();
                this.name = name;
                this.age = age;
            }
            @Override
            public String toString() {
                return "Member [name=" + name + ", age=" + age + "]";
            }
        }
        
		List<Member> arr = Arrays.asList(
                new Member("홍길동", 35),
                new Member("신사임당", 40),
                new Member("세종", 45),
                new Member("홍난파", 80),
                new Member("전달력", 69)
            );
		
		// Member 객체배열에서 최고령자 구하기
		Member maxAgePerson = arr.stream()
								//.filter(m -> m.getAge() > 100)
								.reduce((p1, p2) -> {
									return p1.getAge() > p2.getAge() ? p1 : p2;
								})
								.get();
		System.out.println(maxAgePerson);
		// 매개변수ㅗ 없는 리듀스ㅡ 함수 -> 초기값을 생략 시 항상 스트림의 첫번쨰 요소가 p1에 추가
		// Optional Member 
		// get()은 요소 안에 null값을 nullPointerException을 처리하는게 아니라
		// 아예 값이 안남는 경우, filter를 통해 요소가 아예 남아있지 않은 경우에 
		// noSuchElementException을 방어하기 위함
		
		// Member 객체에서 나이의 합 구하기
		int ageSum = arr.stream()
						.map(member -> member.getAge())
						.reduce(0, (init, age) -> {
							return init + age;
						});
		System.out.println(ageSum);
		
		// Matching계열
        // 1) anyMatch : 스트림의 요소들 중 하나라도 true가 나오면 true.
        boolean bool =
        		Arrays.asList("1", "b2", "c", "d5","5")
        		.stream()
        		.anyMatch((str) -> str.startsWith("b"));
        System.out.println(bool); // true
	
        // 2) noneMatch : 스트림의 요소 모두가 false면 true
        bool = Arrays
        		.asList("홍길동", "123", "가나다")
        		.stream()
        		.noneMatch((str) -> str.length()>4);
        System.out.println(bool); // true
        // 3) allMatch : 스트림의 모든 요소가 true인 경우 true
        bool = Arrays
        		.asList("홍길동", "123", "가나다")
        		.stream()
        		.allMatch((str) -> str.length()<=3); // 모두가 3개 이하인지
        System.out.println(bool); // true
        // 4) findFirst : 스트림 요소 중 조건을 만족하는 첫번째 요소를 찾은 후 반환.
        String str = Arrays
        		.asList("홍길동", "111", "111111", "1가나다")
        		.stream()
        		.filter(s -> s.startsWith("1"))
        		.findFirst()
        		.get();
        System.out.println(str);
        
        // 5) findAny : 스트림 요소가 하나라도 존재한다면 해당 요소를 즉시 반환
		str = Arrays.asList("홍길동2","123","ㅎㅎㅎㅎㅎ")
					.stream()
					.filter(s -> s.length() <= 4)
					.findAny()
					.get();
		System.out.println(str);
	}
}
