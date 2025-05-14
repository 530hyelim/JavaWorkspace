package com.kh.chap01_URL.part03_request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AirPollution {
	/*
	 * URLConnection 활용 예시
	 * 1) 웹 크롤링
	 * 2) API 요청
	 * 
	 * API?
	 * 	 - API서버 : 애플리케이션간의 통신에서 데이터를 제공해주는 서버
	 * 	 - API : 애플리케이션간의 통신에서 데이터를 주고 받기 위한 설명서(인터페이스)
	 * 
	 * API서버 주소
	 * 	 - https://www.data.go.kr/data/15073861/openapi.do
	 * 	 - 한국환경공단_대기오염정보
	 * 
	 * 요청변수(Request Parameter): 클라이언트가 서버에게 요청보낼 때 필요한 데이터(항목구분: 필(수) or 옵(션))
	 * 출력결과(Response Element): 클라이언트가 보낸 요청을 토대로 전달해주는 데이터
	 */
	public static void main(String[] args) {
		String requestUrl = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
		// 서비스 별로 요청 주소가 다르니 주의
		String serviceKey = "iM95VnzzP5xS2CPVMP5diIF8k5vltH%2BXD9IPglg6fTmaJH9HnmtwwIxRsJGpWCaXobk6A3rraidZF%2FeES6hiGw%3D%3D";
		
		// 요청주소에 "쿼리스트링(url상?뒤)"으로 요청변수를 묶어주기
		requestUrl += "?serviceKey=" + serviceKey;
		requestUrl += "&pageNo=1";
		
		try {
			URL url = new URL(requestUrl);
			URLConnection conn = url.openConnection();
			
			// 입출력 스트림 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close(); // 편의상
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
