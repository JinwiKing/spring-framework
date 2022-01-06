package org.springframework.context.kingannotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanAndBeanPostProcessor implements BeanPostProcessor {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(bean);
		System.out.println(beanName);
		System.out.println("MyBeanAndBeanPostProcessor postProcessBeforeInitialization");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(bean);
		System.out.println(beanName);
		System.out.println("MyBeanAndBeanPostProcessor postProcessAfterInitialization");
		return bean;
	}
}
