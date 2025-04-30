package com.kh.game.monster.model.vo;

import com.kh.game.job.model.vo.Characters;

public class Orc extends Monster{
	private int count;
	
	public Orc() {
		
	}

	public Orc(String name, int atk, int hp, int exp) {
		super(name, atk, hp, exp);
	}
	
	@Override
	public void attack(Characters c) {
		if (count == 2) {
			heal();
			count = 0;
		}
		System.out.println("오크가 도끼를 휘두릅니다!");
		c.setHp(c.getHp()-getAtk());
		System.out.println(c.getName()+" 체력 -"+getAtk()+", 남은체력: "+c.getHp());
		count++;
	}
	
	public void heal() {
		System.out.println("오크가 휴식을 취합니다 !");
		setHp(getHp()+20);
		System.out.println("오크의 체력 +20, 남은체력: "+getHp());
	}
}
