package com.kh.chap01_poly.part02_electronic.model.vo;

public class Desktop extends Electronic{
	public static final String CPU = "intel";
	private String graphic;
	
	public Desktop() {
		super();
	}
	
	public Desktop(String brand, String name, int price, String graphic) {
		super(brand, name, price);
		this.graphic = graphic;
	}
	
	@Override
	public String toString() {
		return "Desktop [graphic=" + graphic + ", " + super.toString() + "]";
	}

	public String getGraphic() {
		return graphic;
	}

	public void setGraphic(String graphic) {
		this.graphic = graphic;
	}
	
	//CPU와 같은 static 필드들은 getter/setter 안쓴다 (에러는 안남)
	//왜냐? 스태틱한 방법으로 가져오면 되기때문에
}
