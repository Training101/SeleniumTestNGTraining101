package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataDriven {
  @Test(dataProvider = "data")
  public void f(Integer n, String s) {
	  System.out.println("The integer value is: "+n+" and the String value is: "+s);
  }

  @DataProvider
  public Object[][] data() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
