package com.selenium.pagefactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class PercentageCalcPage 
{
   	
	@FindBy(how = How.ID, using = "cpar1")
	private WebElement txt_num_1;
	
	@FindBy(how = How.ID, using = "cpar2")
	private WebElement txt_num_2;
 
	@FindBy(how = How.XPATH, using = "//input[@value='Calculate']")
	private WebElement btn_calc;
 
	@FindBy(how = How.XPATH, using = "//p[@class='verybigtext']/font[@color='green']/b")
	private WebElement web_result;
	
	public void enterInputValuesAndCalculate(String value1, String value2){
		txt_num_1.sendKeys(value1);
		txt_num_2.sendKeys(value2);
		btn_calc.click();
	}
	
	public String getCalculatedValue(){
		return web_result.getText();
	}
   
    
 }