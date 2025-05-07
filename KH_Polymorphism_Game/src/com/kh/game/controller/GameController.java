package com.kh.game.controller;

import com.kh.game.job.model.vo.*;
import com.kh.game.monster.model.vo.*;

public class GameController {
	private Characters character;
	
	public void createCharacter(int job, String name) {
		switch(job) {
		case 1:
			//String name, int level, int atk, int hp, int maxHp, int exp
			character = new Warrior(name, 1, 2, 10, 10, 0);
			break;
		case 2:
			character = new Archer(name, 1, 3, 5, 5, 0);
			break;
		case 3:
			character = new Wizard(name, 1, 500, 100, 100, 0);
		}
	}
	
	public Characters getCharacter() {
		return character;
	}
	
	public Monster createMonster(int num) {
		Monster monster = null;
		switch(num) {
		case 1:
			//String name, int atk, int hp, int exp
			monster = new Goblin("고블린", 1, 3, 100);
			break;
		case 2:
			monster = new Orc("오크", 10, 100, 200);
			break;
		case 3:
			monster = new Dragon("드래곤", 2000, 200, 300);
		}
		return monster;
	}
}
