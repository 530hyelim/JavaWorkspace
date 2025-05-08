package com.kh.practice.file.run;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.kh.practice.file.view.FileMenu;

public class Run {
	public static void main(String[] args) {
		FileMenu fm = new FileMenu(); 
		fm.mainMenu();
		
		//initialize();
		//readNcopy();
	}
	
	private static void readNcopy() {
		FileWriter fw = null;
		try(FileReader fr = new FileReader("example.txt")) {
			fw = new FileWriter("example.txt", true);
			int value = 0;
			while((value = fr.read()) != -1) {
				fw.write((char)value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void initialize() {
		try(FileWriter fw = new FileWriter("example.txt")) {
			fw.write("Hello World!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
