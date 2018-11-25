package com.selenium.datadriven.fileread;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.ReadFromExcel;

public class DataDrivenExcel {

    private WebDriver driver;

    @DataProvider(name = "WikiDataProvider")
    public Object[][] WikiDataProviderMehod() {
        ReadFromExcel excelReader = new ReadFromExcel("data"+File.separator+"DataSheet.xlsx", "DataTable1");
        return excelReader.getSheetData();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "WikiDataProvider")
    public void tcWikipedia(String vegetable) throws Exception {
        driver.get("http://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys(vegetable);
        driver.findElement(By.className("formBtn")).click();
        String fruitName = driver.findElement(By.xpath("//h1[@id='firstHeading']")).getText();
        Assert.assertTrue(vegetable.equals(fruitName.trim()));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    
}
