package test;

//import org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Example1 {

	@BeforeClass
	public static void BC() {
		System.out.println("Before Class");
	}

	@Before
	public void B() {
		System.out.println("Before");
	}

	@Test
	public void T() {
		System.out.println("Test");
	}

	@After
	public void A() {
		System.out.println("After");
	}

	@AfterClass
	public static void AC() {
		System.out.println("After Class");
	}

}
