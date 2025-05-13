package com.kh.practice.generics.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.practice.generics.model.vo.Farm;

public class FarmController {
	HashMap<Farm, Integer> hMap = new HashMap<>();
	ArrayList<Farm> list = new ArrayList<>();
	
	public boolean addNewKind(Farm f, int amount) {
		if(hMap.containsKey(f)) return false;
		hMap.put(f, amount);
		return true;
	}
	
	public boolean removeKind(Farm f) {
		
	}
	
	public boolean changeAmount(Farm f, int amount) {
		
	}
	
	public HashMap<Farm, Integer> printFarm() {
		
	}
	
	public boolean buyFarm(Farm f) {
		
	}
	
	public boolean removeFarm(Farm f) {
		
	}
	
	public ArrayList<Farm> printBuyFarm() {
		
	}
}
