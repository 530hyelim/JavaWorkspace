package com.kh.game.job.model.vo;

import com.kh.game.monster.model.vo.Monster;

public class Archer extends Characters{
	public Archer() {
		
	}

	public Archer(String name, int level, int atk, int hp, int maxHp, int exp) {
		super(name, level, atk, hp, maxHp, exp);
	}

	@Override
	public String toString() {
		return "직업 : 궁수, " + super.toString();
	}

	@Override
	public void useSkill(Monster m) {
		int dmg = getAtk() * 2 + getLevel() * 3;
		System.out.println(getName()+"가 스킬 멀티샷을 사용했습니다!");
		m.setHp(m.getHp()-dmg);
		System.out.println(m.getName()+" 체력 -"+dmg+", 남은체력: "+m.getHp());
	}

	@Override
	public void attack(Monster m) {
		int dmg = getAtk() + getLevel() * 2;
		System.out.println(getName()+"가 활을 쐈습니다!");
		m.setHp(m.getHp()-dmg);
		System.out.println(m.getName()+" 체력 -"+dmg+", 남은체력: "+m.getHp());
	}

	@Override
	public void levelup() {
		setLevel(getLevel()+1);
		setMaxHp(getMaxHp()+5);
		setAtk(getAtk()+3);
		setHp(getMaxHp());
		
		System.out.println("레벨업!!");
		System.out.println("현재 정보 :");
		System.out.println(toString());
	}
}
