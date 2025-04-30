package com.kh.game.job.model.vo;

import com.kh.game.monster.model.vo.Monster;

public abstract class Characters implements Skill{
	private String name;
	private int level;
	private int atk;
	private int hp;
	private int maxHp;
	private int exp;
	
	protected Characters() {
		
	}

	public Characters(String name, int level, int atk, int hp, int maxHp, int exp) {
		this.name = name;
		this.level = level;
		this.atk = atk;
		this.hp = hp;
		this.maxHp = maxHp;
		this.exp = exp;
	}
	
	@Override
	public String toString() {
		return "이름: "+name+", 레벨: "+level+", 공격력: "+atk+", HP: "+hp+", 경험치: "+exp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
		if(this.exp >= getLevel()*100) levelup();
	}
	
	public abstract void attack(Monster m);
	
	//public abstract void useSkill(Monster m);
	
	public abstract void levelup();
}
