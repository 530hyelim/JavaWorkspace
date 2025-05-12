package com.kh.chap4_map.part03_properties.run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Run {
	/*
	 * Properties : Map계열 구현 클래스. key, value 세트로 값을 저장
	 * 	 단, Properties는 key, value값을 모두 String으로 관리하며, 파일입출력(IO)메서드를 지원하여,
	 *   Properties내부의 데이터를 출력하거나, 읽어들이는 기능을 제공한다
	 *   프로젝트의 설정정보를 기록하는데 자주 사용되는 클래스
	 */
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		// Map계열을 상속받았기 때문에 put메서드가 존재
		//prop.put("다이제", new Snack("초코맛",1500));
		// 컴파일 상에 에러는 없지만 파일입출력을 위해 직렬화할 때 에러발생
		
		// 1. setProperty(String key, String value): 데이터 저장 메서드
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		System.out.println(prop);
		
		// 2. getProperty(String key): 저장된 값을 가져오는 메서드
		System.out.println(prop.getProperty("List"));
		
		try {
			// 3. store(OutputStream os, String comments): prop에 담긴 key, value을 저장
			prop.store(new FileOutputStream("test.properties"), "Properties Test");
			
			// 4. storeToXML(OutputStream os, String comments)
			// XML: 데이터를 계층구조 형태로 관리하는 파일
			prop.storeToXML(new FileOutputStream("test.xml"), "Properties Test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Properties prop2 = new Properties();
		System.out.println(prop2);
		
		try {
			// 5. load(InputStream is): .properties를 읽는데 사용하는 메서드
			//prop2.load(new FileInputStream("test.properties"));
			
			// 6. loadFromXML(InputStream is): .xml을 읽는데 사용하는 메서드
			prop2.loadFromXML(new FileInputStream("test.xml"));
			
			System.out.println(prop2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
