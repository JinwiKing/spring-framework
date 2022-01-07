package org.springframework.core.annotation;

import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class KingTests {

	static class Parent{
		private static String staticParentName;
		private String parentName;
	}

	interface intf{
		default String me() {return "";}
	}

	static class Children extends Parent implements intf{
		private static String staticChildrenName;
		private String childrenName;
		public String publicChildrenName;

		@Override
		public String me() {
			return "1";
		}
	}

	@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface MyAnnotation{
		String name() default "";

		String[] arr() default {""};

		Repeatable[] value() default {};

		@AliasFor()
		String myAlias() default "";
	}

	@MyAnnotation
	private static String name;

	@Test
	public void testAnnotationIsClass(){
		Field[] declaredFields = KingTests.class.getDeclaredFields();
		Field declaredField = declaredFields[0];
		MyAnnotation myAnnotation = declaredField.getAnnotation(MyAnnotation.class);
		System.out.println(myAnnotation);
		Class<? extends Annotation> annotationType = myAnnotation.annotationType();
		System.out.println(annotationType);
		Method[] methods = annotationType.getMethods();
		Method[] declaredMethods = annotationType.getDeclaredMethods();

		System.out.println(methods);
		System.out.println(declaredMethods);

		for (Method method : methods){
			System.out.println(method);
		}
		System.out.println("---");
		for (Method method : declaredMethods){
			System.out.println(method);
		}

		System.out.println();

		System.out.println(Annotation.class.isAssignableFrom(MyAnnotation.class));
	}

	@Test
	public void copyNullElementInArrayTests(){
		Object[] objects = {new Object(), null, new Object()};
		for (Object object : objects){
			System.out.println(object);
		}
		System.out.println("----");
		Object[] objectsCopy = Arrays.copyOf(objects, 2);
		for (Object object : objectsCopy){
			System.out.println(object);
		}
	}

	@Test
	public void isAssignFromTest(){
		KingTests kingTests = new KingTests();
		System.out.println(Object.class.isAssignableFrom(kingTests.getClass()));

		// isAssignableFrom 检查确定调用者是否可以代表给定者
		// isAssignableFrom 调用者可以代表给定者
		// isAssignableFrom 给定者是否可以窄化到调用者
		System.out.println(Children.class.isAssignableFrom(Parent.class));
		System.out.println(Parent.class.isAssignableFrom(Children.class));

//		Children children = new Children();

	}

	@Test
	public void arrayTests(){
		KingTests[][] arr = new KingTests[10][10];
		Class<? extends KingTests[][]> aClass = arr.getClass();
		System.out.println(aClass);
		System.out.println(aClass.isArray());
		Class<?> componentType = aClass.getComponentType();
		System.out.println(componentType.isArray());
		System.out.println(componentType);
	}

	@Test
	public void getDeclareFieldsTest(){
		Field[] declaredFields = Children.class.getDeclaredFields();
		for (Field field : declaredFields){
			System.out.println(field.getName());
		}
	}

	@Test
	public void getClassInterfaceMethod() {
		System.out.println();
		Class<Children> childrenClass = Children.class;
		Method[] declaredMethods = childrenClass.getDeclaredMethods();
		for (Method method : declaredMethods){
			System.out.println(method.getName());
		}
		System.out.println();
		Class<?>[] interfaces = childrenClass.getInterfaces();
		for (Class<?> intf : interfaces){
			Method[] methods = intf.getMethods();
			for (Method method : methods){
				if (!Modifier.isAbstract(method.getModifiers())){
					System.out.println(method.getName());
				}
			}
		}
		System.out.println();
	}

	public void annotatedEleTests(){

		AnnotatedElement ae = MyAnnotation.class;
	}
}
