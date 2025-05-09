package com.kh.chap_list.arrayList.model.vo;

import java.util.Comparator;

public class MusicArtistDescending implements Comparator<Music>{
	@Override
	public int compare(Music o1, Music o2) {
		// 문자열 비교시 compareTo, 숫자 비교시 -
		return o1.getArtist().compareTo(o2.getArtist());
	}
}
