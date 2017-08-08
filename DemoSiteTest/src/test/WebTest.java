package test;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

public class WebTest {
	
	@Before
	public void Before(){
		System.out.println("Before");
	}
	
	@Test
	public void Test(){
		System.out.println("Test");
	}
	
	@After
	public void After(){
		System.out.println("After");
	}
	
}
