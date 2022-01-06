package org.springframework.context.kingannotation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;

public class BeanConfig implements InitializingBean {

	@Bean
	public MyBean myBean(){
		MyBean myBean = new MyBean();
		myBean.name = "my";
		return myBean;
	}

	@Bean
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public MyInfrastructure myInfrastructure(){
		MyInfrastructure myInfrastructure = new MyInfrastructure();
		myInfrastructure.setName("infrastructure");
		return myInfrastructure;
	}

	@Bean
	public MyAutowire myAutowire(){
		return new MyAutowire();
	}

	@Bean
	public MyBeanAndBeanPostProcessor myBeanAndBeanPostProcessor(){
		MyBeanAndBeanPostProcessor myBeanAndBeanPostProcessor = new MyBeanAndBeanPostProcessor();
		myBeanAndBeanPostProcessor.setName("myBeanAndBeanPostProcessor");
		return myBeanAndBeanPostProcessor;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanConfig afterPropertiesSet");
	}
}
