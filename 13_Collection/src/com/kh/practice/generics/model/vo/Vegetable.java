package com.kh.practice.generics.model.vo;

import java.util.Objects;

public class Vegetable {
	private String name;
	
	public Vegetable() {
		
	}

	public Vegetable(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vegetable [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vegetable))
			return false;
		Vegetable other = (Vegetable) obj;
		return Objects.equals(name, other.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
