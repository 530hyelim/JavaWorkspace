package com.kh.practice.score.model.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScoreDAO {
	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		try(DataOutputStream ds = new DataOutputStream(new FileOutputStream("student.txt", true))) {
			ds.writeUTF(name);
			ds.writeInt(kor);
			ds.writeInt(eng);
			ds.writeInt(math);
			ds.writeInt(sum);
			ds.writeDouble(avg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DataInputStream readScore() throws FileNotFoundException {
		return new DataInputStream(new FileInputStream("student.txt"));
	}
}
