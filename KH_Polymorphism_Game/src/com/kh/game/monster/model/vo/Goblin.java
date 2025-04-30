package com.kh.game.monster.model.vo;

import com.kh.game.job.model.vo.Characters;

public class Goblin extends Monster{
	public Goblin() {
		
	}

	public Goblin(String name, int atk, int hp, int exp) {
		super(name, atk, hp, exp);
	}
	
	@Override
	public void attack(Characters c) {
		System.out.println("고블린이 공격합니다!");
		c.setHp(c.getHp()-getAtk());
		System.out.println(c.getName()+" 체력 -"+getAtk()+", 남은체력: "+c.getHp());
		return;
	}
}
