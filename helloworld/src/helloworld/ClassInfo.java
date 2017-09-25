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

			// ��ȡ����
			printClassMethodInfo(currentClass);

			System.out.println("------------------------");
			// ��ȡ��Ա
			printClassFieldInfo(currentClass);

			System.out.println("------------------------");
			// ��ȡ���캯��
			printClassConstructor(currentClass);

		}
	}

	private static void printClassConstructor(Class<?> c) {
		/*
		 * ���캯��Ҳ�Ƕ��� Constructor
		 */

		Constructor<?>[] cs = c.getDeclaredConstructors();

		for (Constructor<?> constructor : cs) {
			System.out.println("���캯������" + constructor.getName());

			Class<?>[] prams = constructor.getParameterTypes();

			for (Class<?> class1 : prams) {
				System.out.println("���캯��������" + class1.getName() + " ");
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

			System.out.println("��������" + m.getName());

			System.out.print("����ֵ��" + returnType.getName());
			System.out.println();
			Class<?>[] paramTypes = m.getParameterTypes();

			for (Class<?> class1 : paramTypes) {
				System.out.print("��������" + class1.getName());
			}

			System.out.println();
		}
	}
}
