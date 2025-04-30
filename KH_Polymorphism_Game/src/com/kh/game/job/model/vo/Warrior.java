package com.kh.game.job.model.vo;

import com.kh.game.monster.model.vo.Monster;

public class Warrior extends Characters{
	
	public Warrior() {
		
	}

	public Warrior(String name, int level, int atk, int hp, int maxHp, int exp) {
		super(name, level, atk, hp, maxHp, exp);
	}

	@Override
	public String toString() {
		return "직업 : 전사, " + super.toString();
	}

	@Override
	public void useSkill(Monster m) {
		int dmg = getAtk() * 2;
		System.out.println(getName()+"가 스킬 강타를 사용했습니다.");
		m.setHp(m.getHp()-dmg);
		System.out.println(m.getName()+" 체력 -"+dmg+", 남은체력: "+m.getHp());
	}

	@Override
	public void attack(Monster m) {
		int random = (int)(Math.random() * (getAtk() * 3) + 1);
		System.out.println(getName()+"가 검을 휘둘렀습니다!");
		m.setHp(m.getHp()-random);
		System.out.println(m.getName()+" 체력 -"+random+", 남은체력: "+m.getHp());
	}

	@Override
	public void levelup() {
		setLevel(getLevel()+1);
		setMaxHp(getMaxHp()+10);
		setAtk(getAtk()+2);
		setHp(getMaxHp());
		
		System.out.println("레벨업!!");
		System.out.println("현재 정보 :");
		System.out.println(toString());
	}
	
}
