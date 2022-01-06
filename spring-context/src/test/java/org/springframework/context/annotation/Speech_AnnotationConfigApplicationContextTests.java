package org.springframework.context.annotation;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.speech.bean1.Bean1Config;
import org.springframework.context.annotation.speech.bean1.MyBean1;
import org.springframework.context.annotation.speech.bean2.MyBean2;

public class Speech_AnnotationConfigApplicationContextTests {

	@Test
	public void testFromConstruct(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Bean1Config.class);
		MyBean1 bean = applicationContext.getBean(MyBean1.class);
		System.out.println(bean);
		Assert.assertEquals("myBean1", bean.getName());
	}

	@Test
	public void testFromScan(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("org.springframework.context.annotation.speech.bean2");
		applicationContext.refresh();
		MyBean2 bean = applicationContext.getBean(MyBean2.class);
		System.out.println(bean);
		Assert.assertEquals("myBean2", bean.getName());
	}
}
