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
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("book.txt", true))) {
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
//			int index = 0;
//			while(true) {
//				bArr[index++] = (Book)os.readObject();
//			}
			for(int i = 0; i < bArr.length; i++) {
				bArr[i] = (Book)os.readObject();
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
