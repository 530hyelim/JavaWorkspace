package com.kh.game.monster.model.vo;

import com.kh.game.job.model.vo.Characters;

public class Dragon extends Monster{
	private int count;
	
	public Dragon() {
		
	}

	public Dragon(String name, int atk, int hp, int exp) {
		super(name, atk, hp, exp);
	}
	
	@Override
	public void attack(Characters c) {
		if (count == 2) {
			breath(c);
			count = 0;
			return;
		}
		System.out.println("드래곤이 발톱을 휘두릅니다!");
		c.setHp(c.getHp()-getAtk());
		System.out.println(c.getName()+" 체력 -"+getAtk()+", 남은체력: "+c.getHp());
		count++;
	}
	
	public void breath(Characters c) {
		System.out.println("드래곤이 브레스를 내뿜습니다!");
		c.setHp(c.getHp()-getAtk()*5);
		System.out.println(c.getName()+" 체력 -"+getAtk()*5+", 남은체력: "+c.getHp());
	}
}
