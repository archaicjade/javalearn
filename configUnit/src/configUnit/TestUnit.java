package configUnit;

import org.junit.Test;

public class TestUnit {

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("性能测试");

		long start = System.currentTimeMillis();

		int a = 0;
		while (a < 99999999) {
			a++;
		}

		System.out.println(System.currentTimeMillis() - start);

		start = System.currentTimeMillis();

		StringBuilder s = new StringBuilder(99999);
		while (s.length() < 99999) {
			s.append(Integer.valueOf("1" + "2"));
		}

		System.out.println(System.currentTimeMillis() - start);

	}

}
