package helloworld;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInfo {

	private static Class<?> currentClass = null;

	public static void GetInfo(String classFullName) {

		try {
			currentClass = Class.forName(classFullName);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentClass != null) {

			// 获取方法
			printClassMethodInfo(currentClass);

			System.out.println("------------------------");
			// 获取成员
			printClassFieldInfo(currentClass);

			System.out.println("------------------------");
			// 获取构造函数
			printClassConstructor(currentClass);

		}
	}

	private static void printClassConstructor(Class<?> c) {
		/*
		 * 构造函数也是对象 Constructor
		 */

		Constructor<?>[] cs = c.getDeclaredConstructors();

		for (Constructor<?> constructor : cs) {
			System.out.println("构造函数名：" + constructor.getName());

			Class<?>[] prams = constructor.getParameterTypes();

			for (Class<?> class1 : prams) {
				System.out.println("构造函数参数：" + class1.getName() + " ");
			}
		}
	}

	private static void printClassFieldInfo(Class<?> c) {
		Field[] fs = c.getDeclaredFields();

		for (Field field : fs) {
			Class<?> fieldType = field.getType();

			String typeName = fieldType.getName();
			String fieldName = field.getName();

			System.out.println(typeName + " " + fieldName);
		}
	}

	private static void printClassMethodInfo(Class<?> c) {
		Method[] ms = c.getMethods();

		for (Method m : ms) {

			Class<?> returnType = m.getReturnType();

			System.out.println("方法名：" + m.getName());

			System.out.print("返回值：" + returnType.getName());
			System.out.println();
			Class<?>[] paramTypes = m.getParameterTypes();

			for (Class<?> class1 : paramTypes) {
				System.out.print("参数名：" + class1.getName());
			}

			System.out.println();
		}
	}
}
