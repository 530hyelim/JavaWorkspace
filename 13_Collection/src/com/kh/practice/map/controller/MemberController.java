package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {
	private HashMap map = new HashMap();
	
	public boolean joinMembership(String id, Member m) {
		if(map.containsKey(id)) return false;
		map.put(id, m);
		return true;
	}
	
	public String logIn(String id, String password) {
		Member m = (Member) map.get(id);
		if(m == null) {
			return null;			
		}
		if(m.getPassword().equals(password)) {
			return m.getName();
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		if(logIn(id, oldPw) != null) {
			((Member)map.get(id)).setPassword(newPw);
			//map.replace(id, new Member(id, newPw));
			
			return true;
		}
		return false;
	}
	
	public void changeName(String id, String newName) {
		Member m = (Member) map.get(id);
		if (m != null) {
			m.setName(newName);
		}
	}
	
	public TreeMap sameName(String name) {
		Set<String> keySet = map.keySet();
		TreeMap tm = new TreeMap();
		for(String key : keySet) {
			Member m = (Member) map.get(key);
			if(m.getName().equals(name)) {
				tm.put(key, m);
			}
		}
		return tm;
	}
	
}
