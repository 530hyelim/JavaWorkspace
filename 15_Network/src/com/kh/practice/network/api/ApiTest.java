package com.kh.practice.network.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ApiTest {
	public static void main(String[] args) {
		try {
			String request = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";
			String apiKey = "iM95VnzzP5xS2CPVMP5diIF8k5vltH%2BXD9IPglg6fTmaJH9HnmtwwIxRsJGpWCaXobk6A3rraidZF%2FeES6hiGw%3D%3D";
			request += "?serviceKey=" + apiKey;
			request += "&stationName=" + URLEncoder.encode("종로구","UTF-8");
			request += "&dataTerm=" + "DAILY";
			//System.out.println(request);
			URL url = new URL(request);
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String data = "";
			while((data = br.readLine()) != null) {
				System.out.println(data);
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
