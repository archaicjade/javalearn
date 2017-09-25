package com.bigball.helloworld;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ClassInfo {

	private static Class<?> currentClass = null;

	public static void GetClassInfo(String className) throws ClassNotFoundException {

		if (className == null || className.isEmpty())
			return;

		currentClass = Class.forName(className);

		if (currentClass == null)
			return;

		System.out.println("++++++++++++++++++++++++++");
		getMethodInfo();
		System.out.println("++++++++++++++++++++++++++");
		getFieldInfo();
		System.out.println("++++++++++++++++++++++++++");
		getConstructorInfo();

	}

	private static void getConstructorInfo() {
		Constructor<?>[] con = currentClass.getConstructors();

		for (Constructor<?> constructor : con) {
			System.out.println("+构造函数：" + constructor.getName());

			for (Class<?> prams : constructor.getParameterTypes()) {

				if (prams == null)
					continue;
				System.out.println("+参数类型：" + prams.getName());
			}
		}
	}

	private static void getFieldInfo() {
		Field[] fs = currentClass.getFields();

		if (fs != null && fs.length > 0) {
			for (Field field : fs) {
				System.out.println("+成员变量：" + field.getName() + "类型：" + field.getType().getName());
			}
		}
	}

	private static void getMethodInfo() {
		Method[] ms = currentClass.getMethods();

		for (Method method : ms) {

			System.out.println("+方法名：" + method.getName());

			Class<?> returnType = method.getReturnType();

			System.out.println("+返回类型：" + returnType.getName());

			Class<?>[] params = method.getParameterTypes();

			if (params != null && params.length > 0) {
				for (Class<?> class1 : params) {
					System.out.print("+参数类型：（" + class1.getName() + ";");
				}

				System.out.println("）");
			}

		}
	}

}
