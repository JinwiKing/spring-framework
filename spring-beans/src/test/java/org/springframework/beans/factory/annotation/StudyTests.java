package org.springframework.beans.factory.annotation;

import org.junit.jupiter.api.Test;

public class StudyTests {

	@Test
	void testPackageInfo(){
		Package aPackage = Package.getPackage("org.springframework.beans.factory.annotation");
		System.out.println(aPackage);
		System.out.println();
	}
}
