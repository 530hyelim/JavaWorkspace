package com.kh.practice;

public class LambdaPractice3 {
	 public static void main(String[] args) { 
         MyFunction <Integer, String> intToString = i -> "Value: " + i; 
         MyFunction <String, Integer> strToLength = s -> s.length(); 

         System.out.println(intToString.apply(42));              // Value: 42 
         System.out.println(strToLength.apply("lambda")); // 6 
     }
}

@FunctionalInterface
interface MyFunction<T, V> {
	V apply (T x);
}
