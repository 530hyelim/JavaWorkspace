package com.kh.chap01_URL.part01_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Run {
	public static void main(String[] args) {
		Run run = new Run();
		run.test3();
	}
	
	public void test1() {
		/*
		 * InetAddress
		 * 	 - IP주소에 대한 정보를 가진 클래스
		 * 	 - IP: 4 or 6 바이트로 이루어진 인터넷 주소
		 * 	 - hostname: naver.com(도메인: 사용자가 보기 편리하도록)
		 * 	 - 모든 메서드가 static
		 */
		try {
			InetAddress naver = InetAddress.getByName("naver.com");
			System.out.println(naver.getHostAddress());
			
			InetAddress google = InetAddress.getByName("google.com");
			System.out.println(google.getHostAddress());
			
			InetAddress[] arr = InetAddress.getAllByName("google.com");
			System.out.println(Arrays.toString(arr));
			
			// 내 컴퓨터의 ip주소
			//	 - localhost
			//	 - 127.0.0.1
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void test2() {
		/*
		 * URL(Uniformed Resource Locator)
		 * 	 - 인터넷상에 존재하는 서버들의 자원에 접근할 수 있는 주소(표기법)
		 * 	 - 자바에서는 URL클래스로 URL자원을 다룰 수 있음
		 * 	 - 실제 URL자원에 대한 객체를 생성하여 자원에 연결하고, 데이터를 읽어올 수 있음
		 * 	 - (로컬환경이 아닌 네트워크 환경에서 File클래스와 비슷한 역할을 함)
		 * 
		 * URL의 구조
		 * 	 - https://khedu.co.kr:443/project/teamView.kh?no=5385&cpage=1
		 *   - protocol: 통신규약(http, ftp, smtp, file, ...)
		 *   - hostname: 도메인이름(ip주소) 웹브라우저라 DNS시스템과 통신해서 특정ip주소를 반환하고, 그 아이피에 접근
		 *   - port: 눈에 보이지 않지만 기본 포트가 들어감(생략). 특정 포트번호를 제시하려면 (e.g.8080) 직접 써줘야함
		 * 			서비스번호. 호스트 내에 특정 서비스를 가리키는 논리적인 번호. 포트번호별로 다양한 서비스를 제공 가능
		 * 			(443:https 기본포트, 80:http의 기본포트, ftp의 기본포트 20)
		 * 	 - 자원경로: hostname+port 내부에서 자원이 존재하는 세부 경로(/project/teamView.kh)
		 * 	 - querystring: 자원을 얻기위해 서버에 전달해야하는 값들(?no=5385&cpage=1)
		 */
		try {
			URL url = new URL("https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=8&acq=%EC%9E%90%EB%B0%94&qdt=0&ie=utf8&query=%EC%9E%90%EB%B0%94&ackey=hx2zc2tj");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
//			System.out.println(url.getPort()); //기본포트를 사용하는 경우 제대로 반환이 되지 않음
			System.out.println(url.getPort()+":::"+url.getDefaultPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void test3() {
		/*
		 * URLConnection
		 * 	 - 원격서버와 통신하여 자원을 입출력할 수 있는 스트림을 제공하는 클래스
		 * 	 - URL클래스로 연결할 자원을 기술하고, URLConnection으로 입출력스트림을 사용하여 입출력할 수 있음
		 */
		String address = "https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=8&acq=%EC%9E%90%EB%B0%94&qdt=0&ie=utf8&query=%EC%9E%90%EB%B0%94&ackey=hx2zc2tj";
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			// 웹크롤링, API요청 목적에 주로 사용
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			//URL자원과 직접적으로 연결되는 (바이트)기반스트림 => 버퍼드리더에 바로 사용X
			bw = new BufferedWriter(new FileWriter("naver_search.html"));
			
			String data = "";
			while((data = br.readLine()) != null) {
				bw.write(data);
				bw.newLine();
			}
			System.out.println("검색결과 저장 완료!");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
