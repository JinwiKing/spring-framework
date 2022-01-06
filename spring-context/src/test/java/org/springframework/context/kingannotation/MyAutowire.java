package org.springframework.context.kingannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class MyAutowire {

	@Autowired
	private MyInfrastructure myInfrastructure;

	@Override
	public String toString() {
		return "MyAutowire{" +
				"myInfrastructure=" + myInfrastructure +
				'}';
	}
}
