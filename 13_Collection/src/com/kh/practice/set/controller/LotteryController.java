package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import com.kh.practice.set.model.compare.SortedLottery;
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
		int winSize = win.size();
		for(int i = 0; i < 4 - winSize; i++) {
			int random = (int)(Math.random()*(lottery.size()));
			Lottery winner = arrList.get(random);
			if(win.contains(winner)) {
				i--;
				continue;
			}
			win.add(winner);
		}
		return win;
	}
	
	public TreeSet sortedWinObject() {
		TreeSet<Lottery> treeSet = new TreeSet<>(new SortedLottery());
		treeSet.addAll(win);
		return treeSet;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}
}
