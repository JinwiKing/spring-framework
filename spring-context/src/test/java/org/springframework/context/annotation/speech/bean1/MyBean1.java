package org.springframework.context.annotation.speech.bean1;

public class MyBean1 {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyBean1{" +
				"name='" + name + '\'' +
				'}';
	}
}
