package com.kh.practice.network.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("호스트명 : ");
		String hostname = sc.nextLine();
		
		try {
			InetAddress[] address = InetAddress.getAllByName(hostname);
			System.out.println(hostname+"는 "+address.length+"개의 IP주소를 가지고 있습니다.");
			for (int i = 0; i < address.length; i++) {
				System.out.println(i+1 +"번 IP = "+address[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
