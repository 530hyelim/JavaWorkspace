package com.kh.chap04_assist.part01_buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDao {
	/*
	 * 보조스트림
	 * 	 - 기반스트림의 부족한 기능들을 "확장"시킬 수 있는 스트림들
	 * 	 - 보조스트림은 단독으로는 사용이 불가능
	 * 
	 * [표현법]
	 * 보조스트림 변수명 = new 보조스트림(기반스트림 객체);
	 * 
	 * 보조스트림 여러개 추가
	 * 보조수트림1 변수명 = new 보조스트림1(new 보조스트림2(기반스트림 객체));
	 * => 데코레이터 패턴
	 * 
	 * BufferedXXX : "속도 성능 향상" 목적의 보조스트림 (가장 자주 사용되는 스트림 중 하나)
	 * => 데이터를 바로 입출력 하는것이 아니라 크기가 큰 버퍼공간을 만들어서 데이터를 모아두었다가 한번에 입출력을 진행
	 */
	
	// BufferedReader / BufferedWriter (문자스트림 계열만 감쌀 수 있음)
	public void fileSave() {
		// 만약 보조스트림이 Writer면 기반스트림도 Writer
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))) {
			// 동일한 데이터 유형을 전달하는 스트림을 매개변수로 넣어야 함
			bw.write("안녕하세요");
			bw.newLine(); // 개행문자 추가
			bw.write("저리가세요\n");
			
			// 버퍼공간 비워주는 메서드
			bw.flush(); // close() 실행시 자동으로 호출되는 메서드
			// 버퍼공간이 다 채워지지 않은 상태에서 메서드가 종료될 때, 버퍼에 담겨있는 데이터가 누락될 수 있기때문
			
			// 출력 후 10초 대기
			Thread.sleep(10000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {
			String value = null;
			while((value = br.readLine()) != null) {
				System.out.println(value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
