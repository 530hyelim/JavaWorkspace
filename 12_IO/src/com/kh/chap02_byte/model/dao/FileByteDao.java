package com.kh.chap02_byte.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// DAO(Data Access Object) : 데이터가 보관되어있는 공간과 직접접근해서 데이터를 입출력하는 클래스
public class FileByteDao {
	
	// 자바프로그램에서 작성한 데이터를 File로 기록(출력)
	public void fileSave() {
		// FileOutputStream : 파일로 데이터를 1byte단위로 출력하는 스트림
		FileOutputStream fout = null;
		
		try {
			// FileOutputStream 객체 생성 == 파일과 연결되는 통로를 개설
			//  - 연결하고자하는 파일이 존재하지 않는 경우, "파일을 생성"하면서 통로를 개설
			//  - 연결하고자하는 파일이 존재하더라도, 이어쓰기 여부를 전달하지 않으면 항상 덮어쓰기가 된다
//			fout = new FileOutputStream("a_byte.txt"); // 매개변수: 문자열 or 파일객체
			fout = new FileOutputStream("a_byte.txt", true); // 이어쓰기
			
			// 스트림을 통해 데이터 출력
			//  - write()메서드를 사용하여 출력
			//  - byte의 범위: -128 ~ 127까지의 정수값
			//    0 ~ 127까지의 숫자를 기록 가능 (아스키코드표가 0부터 시작하기 때문에)
			fout.write(97); // 아크시코드표상 문자 a
			fout.write('b');
//			fout.write('민'); // 한글은 2byte로 표현가능한 문자이기 때문에 깨져서 저장
							 // 2byte 이상의 데이터를 입출력하기 위해서는 보조스트림 혹은
							 // 문자스트림을 사용
			byte[] bArr = {99,100,101}; // c d e
			fout.write(bArr);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 예외가 발생했든 안했든 항상 실행되는 코드를 기술하는 영역
			// 다 쓴 스트림자원 반납(필수)
			try {
				fout.close(); // 반납하지 않으면 메모리 누수 에러가 발생할 수 있음
				// 클로즈 메서드가 호출 되어야지만 기록이 된다. 그 전에는 입력 버퍼상에만 존재.
				// 그래서 입력한 값을 제대로 내보내기 위해서도 필수적임
				// 프로그램이 종료되면 가비지컬렉터가 작동하고, Stream객체를 정리할때 자동으로 close
				// 시키고 작동하기 때문에 없어도 작성이 되었던 것
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 파일에 저장된 데이터를 자바 프로그램으로 읽어 오는 메서드
	public void fileRead() {
		FileInputStream fin = null;
		// try문 안에서 객체생성하고 초기화한다면 try문 안에서만 사용할수 있기때문에
		// finally 영역 안에서 close할 수 없음. 따라서 null로 미리 선언.
		try {
			File file = new File("a_byte.txt");
			fin = new FileInputStream(file); // 반드시 존재하는 파일로 경로를 제시
			
			// 연결된 파일의 데이터를 읽는 메서드(read())
//			System.out.println((char)fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());
			
			// 저장된 파일의 모든 데이터를 읽는 방법
			// read()함수로 반환받는 값이 -1이라면 파일의 끝이므로 그전까지 무한반복
			int value = 0;
			while((value = fin.read()) != -1) {
				System.out.println((char)value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
