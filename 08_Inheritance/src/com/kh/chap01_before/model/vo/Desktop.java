package com.kh.chap01_before.model.vo;

//@Setter // 컴파일단계에서 세터메서드가 생긴다
//프레임워크 단계에서(직접 만들지 않아도 개발가능하게 도와주는 기능)
public class Desktop extends Product{
//	private String brand;
//	private String pCode;
//	private String pName;
//	private int price;
	private boolean allInOne;
	
	public Desktop(String brand, String pCode, String pName, int price, boolean allInOne) {
//		super(); // 현재 클래스의 부모클래스의 주소값을 담고있는 변수(식별자)
				 // 예약어: this 현재객체주소값, super 부모객체주소값
				 // super(): 부모클래스의 매개변수 없는 생성자를 호출하는 것
		
		//부모객체 내부의 필드값들을 초기화할 수 있는 방법
		//1.부모클래스의 매개변수 생성자를 호출하여 필드 초기화
//		super(brand, pCode, pName, price); // 부모생성자는 항상 자식생성자의 첫번째줄에 기술
		
		//2.부모클래스의 setter함수를 이용하여 초기화
		super();
		super.setBrand(brand);
		this.setpCode(pCode);
		setpName(pName);
		setPrice(price); // this안에있는 setBrand()먼저 찾아보고 없으면 super안에서 찾음
		// 따라서 super.setBrand()로 명시해주는것이 좋음
		
		//3.부모클래스의 필드들의 접근제한자를 protected로 변경하여 초기화
		//protected: 서로 다른 클래스에 있더라도 상속관계에 있는 클래스에서는 직접 접근이 가능하다
		super.brand = brand;
		super.pCode = pCode;
		super.pName = pName;
		super.price = price;
		//지금은 같은 패키지 내에 있기때문에 디폴트도 가능하지만 만약 다른패키지에 부모클래스가 있을경우
		//프로텍티드 접근제한자를 사용해야함
		
		this.allInOne = allInOne;
		//자바에서는 항상 객체 생성 전에 부모객체가 생성되기 때문에
		//JVM이 모든 생성자의 첫줄에 super();를 써준다
	}
	/*
	 * TV, Desktop, Smartphone, ... 가전제품 클래스들을 만들때마다
	 * 각 클래스에 필요한 필드들을 작성시 "중복으로 들어가는 코드가 많은 경우"
	 * 유지보수 과정에서 수정이 필요한 경우 모든 필드들을 일일이 수정해야 하는
	 * 번거로움이나, 새로운 공통 필드 추가시의 번거로움등, 생산성 측면에서
	 * 안좋은 영향을 끼치게 된다.
	 * 
	 * 이럴 때는 상속이라는 개념을 적용시켜서 매 클래스마다 중복된 필드 및 메서드들을
	 * 하나의 클래스에 정의해둔 후, 해당 클래스를 "상속"받는 식으로 작업하는게 좋다.
	 */

	public boolean isAllInOne() { //불린 자료형 특징 is로 시작
		return allInOne;
	}

	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	//오버라이딩: 부모클래스의 메소드를 자식클래스에서 변경하는 행위
	public String information() {
//		return "brand : "+getBrand()+", pCode : "+getpCode()+
//				", pName : "+pName+", allInOne : "+allInOne;
//		super.information(); //super.예약어가 없을경우 현재클래스의 information()함수를
		//실행할 것이기 때문에 함수가 무한반복되며 메모리부족 현상
		return super.information()+", allInOne : "+allInOne;
	}
	
}
