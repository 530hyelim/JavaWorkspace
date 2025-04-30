package practice3.model.vo;

public abstract class Animal {
	private String name;
	private String kinds;
	
	// 클래스 다이어그램 상 #: protected 를 의미
	// 클래스 다이어그램 상 ~: default 를 의미
	protected Animal() {
		
	}
	
	protected Animal(String name, String kinds) {
		this.name = name;
		this.kinds = kinds;
	}
	
	@Override
	public String toString() {
		return "저의 이름은 "+name+"이고, 종류는 "+kinds+"입니다. ";
	}
	
	// 클래스 다이어그램 상 "기울임"글꼴: abstract 를 의미
	public abstract void speak();
}
