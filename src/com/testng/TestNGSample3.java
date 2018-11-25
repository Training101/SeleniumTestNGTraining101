package com.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGSample3 {
	@Parameters({"browser", "testParam"})
	@BeforeMethod
	public void beforeMethod(String test, String name) {
		System.out.println("My browser is: "+test+" and my name is:"+name);
	}

	@Test
	public void f() {
		System.out.println("@Test - f() - third TestNG Class");
	}

	@AfterMethod
	public void afterTest() {
		System.out.println("This is @AfterMethod - second");
	}
}
