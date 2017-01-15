package com.selenium.keyworddriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PercentageCalcPage {

	public static By txt_num_1 = By.id("cpar1");

	public static By txt_num_2 = By.id("cpar2");;

	public static By btn_calc = By.xpath("//input[@value='Calculate']");

	public static By web_result = By
			.xpath("//p[@class='verybigtext']/font[@color='green']/b");

}
