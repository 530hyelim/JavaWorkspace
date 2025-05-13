package com.kh.practice.generics.model.vo;

import java.util.Objects;

public class Farm {
	private String kind;
	
	public Farm() {
		
	}

	public Farm(String kind) {
		super();
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Farm [kind=" + kind + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(kind);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Farm))
			return false;
		Farm other = (Farm) obj;
		return Objects.equals(kind, other.kind);
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
