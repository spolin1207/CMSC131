package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sysutilities.Name;

public class StudentTests {

	@Test
	public void test() {
		
		Name Person1 = new Name("Robert", "W.", "Smith", '-');
		System.out.println(Person1);
		
		Name Person2 = new Name("Timothy", "A.", "Chamelet");
		System.out.println(Person2);
		
		Name Person3 = new Name("Julia", "R.", "Roberts", '#');
		System.out.println(Person3);
		
		Name Person4 = new Name("James", "C.", "Clark");
		Person4.setNickname("Jim");
		System.out.println(Person4);
		
		Name.getNumberOfNameObjects();
	}

}
