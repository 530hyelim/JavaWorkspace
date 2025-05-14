package com.kh.chap02_udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {
	public static void main(String[] args) {
		try {
			InetAddress server = InetAddress.getByName("localhost");
			int serverPort = 30001;
			
			DatagramSocket socket = new DatagramSocket(); // 포트번호를 제시하지 않으면 사용하지 않는 포트번호를 자동으로 얻어옴
			// 클라이언트에서 데이터를 전송할 때 .getPort() 메서드로 클라이언트의 포트번호를 가져오기 때문에 랜덤 포트번호 사용 가능
			String message = "udp 클라이언트가 작성한 메세지";
			byte[] sendData = message.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
															server, serverPort);
			socket.send(sendPacket);
			
			// 서버로부터 데이터 수신 대기
			socket.receive(sendPacket);
			
			String receiveData = new String(sendPacket.getData(), 0, sendPacket.getLength());
			System.out.println(receiveData);
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
