package helloworld;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	public StudentComparator() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
