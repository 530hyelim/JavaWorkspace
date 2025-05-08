package com.kh.chap04_assist.part03_data.model.dao;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DataDAO {
	// DataXXX => 기본자료형 단위로 입출력을 지원하는 보조스트림
	
	public void fileSave() {
		// 기반스트림(FileOutputStream) - 바이트 기반스트림으로 스트림 연결
		// 보조스트림1(DataOutputStream) - 기본 자료형 입출력 기능 추가
		// 보조스트림2(OutputStreamWriter) - 바이트 스트림을 문자 스트림으로 변경
		// 보조스트림3(BufferedWriter) - 속도 성능 향상
		try(BufferedWriter bw = new BufferedWriter(
			new OutputStreamWriter(
				new DataOutputStream(
					new FileOutputStream("sample.txt"))));
			DataOutputStream ds = new DataOutputStream(new FileOutputStream("sample2.txt"))
			) {
			ds.writeBoolean(true);
			ds.writeInt(300);
			ds.writeDouble(3.14);
			ds.writeChar('민');
			ds.writeUTF("문자열 작성"); // 문자를 각각 2byte로 나눠서 보관하기 때문에 가능
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		// 저장된 자료형의 순서에 맞춰서 읽기
		try(DataInputStream ds = new DataInputStream(new FileInputStream("sample2.txt"))) {
			ds.readBoolean();
			System.out.println(ds.readInt());
			System.out.println(ds.readDouble());
			System.out.println(ds.readChar());
			System.out.println(ds.readUTF());
			
			ds.readBoolean(); //EOF exception 발생 (IO exception이 잡아줌)
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
