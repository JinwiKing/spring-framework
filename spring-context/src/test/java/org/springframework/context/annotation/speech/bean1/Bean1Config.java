package org.springframework.context.annotation.speech.bean1;

import org.springframework.context.annotation.Bean;

public class Bean1Config {

	@Bean
	public MyBean1 myBean(){
		MyBean1 myBean1 = new MyBean1();
		myBean1.setName("myBean1");
		return myBean1;
	}
}
