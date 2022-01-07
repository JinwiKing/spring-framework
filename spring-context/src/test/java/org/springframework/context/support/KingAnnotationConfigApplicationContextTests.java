package org.springframework.context.support;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.kingannotation.BeanConfig;
import org.springframework.context.kingannotation.MyAutowire;
import org.springframework.context.kingannotation.MyBean;
import org.springframework.context.kingannotation.MyInfrastructure;

public class KingAnnotationConfigApplicationContextTests {


	@Test
	public void testAnnotationConfig(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(BeanConfig.class);
		MyBean bean = applicationContext.getBean(MyBean.class);
		System.out.println(bean);
		System.out.println(applicationContext.getBean(MyInfrastructure.class));
		System.out.println(applicationContext.getBean(MyAutowire.class));
	}

}
