package org.springframework.context.annotation.speech.bean2;

import org.springframework.stereotype.Component;

@Component
public class MyBean2 {
	private String name = "myBean2";

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
