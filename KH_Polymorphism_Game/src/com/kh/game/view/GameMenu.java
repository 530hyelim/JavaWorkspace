package com.kh.game.view;

import java.util.Scanner;

import com.kh.game.controller.GameController;
import com.kh.game.job.model.vo.Characters;
import com.kh.game.monster.model.vo.Monster;

public class GameMenu {
	private GameController gc;
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		gc = new GameController();
		while(true) {
			System.out.println("=======  메뉴  =======");
			System.out.println("1. 캐릭터 생성");
			System.out.println("2. 게임 시작");
			System.out.println("3. 캐릭터 정보 확인");
			System.out.println("4. 게임 종료");
			System.out.print("메뉴번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 4:
				System.out.println("게임을 종료합니다");
				return;
			case 1:
				createCharacter();
				break;
			case 3:
				if(gc.getCharacter() != null) {
					characterInfo();
					break;					
				}
			case 2:
				if(gc.getCharacter() != null) {
					gameStart();
					break;
				}
			default:
				System.out.println("잘못된 번호입니다");
			}
		}
	}
	
	public void createCharacter() {
		if(gc.getCharacter() != null) {
			System.out.println("이미 캐릭터가 생성되었습니다. 메인메뉴로 돌아갑니다.");
			return;
		}
		while(true) {
			System.out.print("직업을 선택하세요(1.전사, 2.궁수, 3.마법사) : ");
			int job = sc.nextInt();
			sc.nextLine();
			
			String s = "";
			switch(job) {
			case 1:
				s = "전사";
				break;
			case 2:
				s = "궁수";
				break;
			case 3:
				s = "마법사";
				break;
			default:
				System.out.println("존재하지 않는 직업입니다. 1-3번의 직업을 선택해 주세요.");
				continue;
			}
			System.out.print("캐릭터 이름을 입력하세요 : ");
			gc.createCharacter(job, sc.nextLine());
			
			Characters c = gc.getCharacter();
			System.out.print(s+" 캐릭터 "+c.getName()+"가 생성되었습니다. ");
			System.out.println("(LV:"+c.getLevel()+", 공격력:"+c.getAtk()+", 체력:"+c.getHp()+")");
			return;
		}
	}
	
	public void gameStart() {
		System.out.println("출전할 몬스터를 선택하세요 :");
		System.out.println("1. 고블린(lv1): 초보용");
		System.out.println("2. 오크(lv10): 중수용");
		System.out.println("3. 드래곤(lv100): 고수용");
		System.out.print("몬스터 선택 : ");
		int mon = sc.nextInt();
		sc.nextLine();
		
		if(mon != 1 && mon != 2 && mon != 3) {
			System.out.println("존재하지 않는 몬스터입니다.");
			gameStart();
			return;
		}
		Monster m = GameController.createMonster(mon);
		Characters c = gc.getCharacter();
		
		System.out.println("전투를 시작합니다!");
		while(true) {
			System.out.println(c.getName()+"의 턴!");
			System.out.println("1. 공격");
			System.out.println("2. 스킬(5레벨부터 사용가능)");
			System.out.println("3. 도망치기");
			int ans = sc.nextInt();
			sc.nextLine();
			
			switch(ans) {
			case 1:
				c.attack(m);
				break;
			case 2:
				if(c.getLevel() < 5) {
					System.out.println("레벨 부족으로 스킬을 사용할 수 없습니다");
					continue;
				}
				c.useSkill(m);					
				break;
			case 3:
				System.out.println("전투에서 도망갑니다.");
				return;
			default:
				System.out.println("잘못된 명령입니다.");
				continue;
			}
			
			if(m.getHp() <= 0) {
				System.out.println(m.getName()+" 처치! 전투에서 승리했습니다!!");
				System.out.println(m.getExp()+" 경험치를 획득했습니다!");
				c.setExp(c.getExp()+m.getExp());
				return;
			} else {
				m.attack(c);				
			}

			if(c.getHp() <= 0) {
				System.out.println("전투에서 패배했습니다!");
				c.setHp(c.getMaxHp());
				return;
			}
		}		
	}
	
	public void characterInfo() {
		System.out.println(gc.getCharacter());
	}
}
