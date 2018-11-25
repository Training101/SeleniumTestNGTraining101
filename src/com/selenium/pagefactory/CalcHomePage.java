package com.selenium.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CalcHomePage {

	@FindBy(how = How.XPATH, using = ".//*[@id='menu']/div[3]/a")
	private WebElement lnk_math_calc;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='menu']/div[4]/div[3]/a")
	private WebElement lnk_percent_calc;
	
	public void clickMathCalcLink(){
		lnk_math_calc.click();
	} 
	
	
	public void clickPercentCalcLink(){
		lnk_percent_calc.click();
	} 
	
}
