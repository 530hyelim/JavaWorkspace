package com.kh.practice.generics.model.vo;

import java.util.Objects;

public class Nut {
	private String name;
	
	public Nut() {
		
	}

	public Nut(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Nut [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Nut))
			return false;
		Nut other = (Nut) obj;
		return Objects.equals(name, other.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
