package com.eric.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("==============================================================");
		Method[] methods = Object.class.getMethods();
		for (Method method : methods) {
			System.out.println("method = " + method.getName());
		}
		
		System.out.println("\n\n==============================================================");
		Class<Object> clazz1 = Object.class;
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		
		
		System.out.println("\n\n==============================================================");
		Class<Object> clazz2 = Object.class;
		int modifiers = clazz2.getModifiers();
		System.out.println(modifiers);
		System.out.println(Modifier.isPublic(modifiers));
		
		
		System.out.println("\n\n==============================================================");
		Class<?> clazz3 = Test2.class;
		Method method1 = clazz3.getMethod("test1", new Class[]{String.class});
		method1.invoke(null, "this is test1");//调用静态方法可以使用null
		Method method2 = clazz3.getMethod("test2", new Class[]{String.class, String.class});
		Test2 instance = new Test2();
		method2.invoke(instance, new Object[] {"this is test", " teshiss"});
	}

}
