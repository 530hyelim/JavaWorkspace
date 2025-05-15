package com.kh.chap01_innerClass.part02_static.model.dto;
// dto: api요청을 보낼 때 api마다 응답 형식이 다름. 하나의 api에서도 다 다름. (필수/옵션 사항때문에)

import java.util.Date;

// @Getter @Setter @NoArgumentsConstructor => 프레임워크 사용시 어노테이션 추가로 클래스 파일 컴파일 후 자동생성됨
public class KakaoUserInfoResponse {
	/*
	 * DTO (Data Transfer Object)
	 * 	 - 값을 전달하기 위해 사용하는 클래스
	 * 	 - API서버, DB서버 간에 데이터 송수신하기 위한 용도의 객체들을 정의하는 클래스
	 * 	 - VO 클래스와는 다르게 데이터 "송수신"이 주 목적이기 때문에 불필요한 메서드들(equals, hashcode)들이 존재하지 않는다.
	 * 	 - api 서버들에는 다양한 기능이 존재하며, 기능마다 요구하는 데이터의 양식, 반환되는 응답 데이터의 양식이 다양하기 때문에,
	 * 		이에 맞춰서 DTO클래스들을 설계하면 굉장히 많은 양의 클래스가 나온다.
	 * 	 - 너무 많은 DTO클래스가 파일로 존재하면 관리가 힘들어지므로 정적 내부클래스에 필요한 클래스들을 모아서 관리하는게 일반적이다.
	 * 
	 * VO (Value Object)
	 * 	 - 가치가 있는 클래스를 표현하기 위한 목적으로 사용하는 클래스
	 * 	 - 객체지향적으로 설계된 클래스 (api, db 데이터 송수신 하기도 함)
	 * 	 - 어플리케이션의 핵심적인 역할을 하는 클래스를 정의하는 클래스이며, 데이터 불변성이 유지되어야 한다.
	 * 	   따라서 데이터를 중간에 변경하는 setter 메서드가 존재하지 않는것이 관례임.(매개변수 있는 생성자로만)
	 * 	 - 캡슐화 및 상속이 구현되어 있으며, equals, hashcode 등 객체의 기능을 정의하는 메서드들이 들어가있다.
	 */
	private Long id;
	private Date synched_at;
	private KakaoAccount kakao_account;
	
	public static class KakaoAccount {
		private Boolean profile_needs_agreement;
		private KakaoProfile profile;
	}
	
	public static class KakaoProfile {
		
	}
}
