package com.kh.game.job.model.vo;

import com.kh.game.monster.model.vo.Monster;

public class Wizard extends Characters{
	public Wizard() {
		
	}

	public Wizard(String name, int level, int atk, int hp, int maxHp, int exp) {
		super(name, level, atk, hp, maxHp, exp);
	}

	@Override
	public String toString() {
		return "직업 : 마법사, " + super.toString();
	}

	@Override
	public void useSkill(Monster m) {
		int dmg = getAtk() * 3;
		System.out.println(getName()+"가 스킬 지건을 사용했습니다.");
		m.setHp(m.getHp()-dmg);
		System.out.println(m.getName()+" 체력 -"+dmg+", 남은체력: "+m.getHp());
	}

	@Override
	public void attack(Monster m) {
		System.out.println(getName()+"가 지팡이를 휘둘렀습니다!");
		m.setHp(m.getHp()-getAtk());
		System.out.println(m.getName()+" 체력 -"+getAtk()+", 남은체력: "+m.getHp());
	}

	@Override
	public void levelup() {
		setLevel(getLevel()+1);
		setMaxHp(getMaxHp()+100);
		setAtk(getAtk()+500);
		setHp(getMaxHp());
		
		System.out.println("레벨업!!");
		System.out.println("현재 정보 :");
		System.out.println(toString());
	}
}
