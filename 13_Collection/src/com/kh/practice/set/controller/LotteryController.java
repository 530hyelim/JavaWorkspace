package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet lottery = new HashSet();
	private HashSet win = new HashSet();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		boolean remove = lottery.remove(l);
		if(remove && win != null)
			win.remove(l);
		return remove;
	}
	
	public HashSet winObject() {
		if(lottery.size() < 4) {
			return null;
		}
		ArrayList<Lottery> arrList = new ArrayList<>(lottery);
		for(int i = 0; i < 4 - win.size(); i++) {
			int random = (int)Math.random()*lottery.size()+1;
			Lottery winner = arrList.get(random);
			if(win.contains(winner)) {
				i--;
			}
			win.add(winner);
		}
		return win;
	}
	
	public TreeSet sortedWinObject() {
		TreeSet<Lottery> tSet = new 
		return null;
	}
	
	public boolean searchWinner(Lottery l) {
		return false;
	}
}
