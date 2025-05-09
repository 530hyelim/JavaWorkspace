package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.practice.book.model.vo.Book;

public class BookDAO {
	private Book[] bArr = new Book[10];
	
	public void fileSave(Book[] bArr) {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("book.txt"))) {
			// 프로그램 처음 시작할때 BookMenu()에서 북객체 어레이 저장된값 불러오기 때문에 true써서 이어쓰기하면 에러남
			for(Book b : bArr) {
				if(b != null) os.writeObject(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Book[] fileRead() {
		try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("book.txt"))) {
			int index = 0;
			while(true) {
				bArr[index++] = (Book)os.readObject();
				//만약에 객체를 11개 저장했으면 arrayOutofboundException 뜨려나?????
				//catch clause 추가하거나 while(index < bArr.length)로 바꾸면 될듯
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return bArr;
	}
}
