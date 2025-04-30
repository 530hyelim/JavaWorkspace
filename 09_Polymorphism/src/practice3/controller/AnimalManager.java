package practice3.controller;

import practice3.model.vo.*;

public class AnimalManager {
	public static void main(String[] args) {
		Animal[] arr = new Animal[5];
		arr[0] = new Cat("나비","노란괭이","거실","노랑");
		arr[1] = new Dog("까망","요키",3);
		arr[2] = new Dog("초코","믹스",4);
		arr[3] = new Cat("네로","냐옹이",Dog.PLACE,"검정");
		arr[4] = new Dog("만땅","믹스",9);
		
		for(Animal a : arr) {
			a.speak();
		}
	}
}
