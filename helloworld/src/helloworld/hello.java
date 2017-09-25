package helloworld;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ClassInfo.GetInfo("helloworld.Student");
		// System.out.println("+++++++++++++++++++++++++");
		// ClassInfo.GetInfo("helloworld.StudentComparator");
		// System.out.println("+++++++++++++++++++++++++");
		// ClassInfo.GetInfo("helloworld.ClassInfo");

		try {
			Class<?> c = Class.forName("helloworld.Student");
			Method mi;
			try {
				mi = c.getMethod("printALL", String.class);

				try {
					Object o = mi.invoke(c, "hahaaaaha");

					System.out.println(o);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
