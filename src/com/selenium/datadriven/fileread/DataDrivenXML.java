package com.selenium.datadriven.fileread;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.ReadFromXML;

public class DataDrivenXML {

    private WebDriver driver;

    @DataProvider(name = "WikiDataProvider")
    public Object[][] WikiDataProviderMehod() {
        ReadFromXML xmlReader = new ReadFromXML("DataXML.xml");
        return xmlReader.getTableData("Table1");
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "WikiDataProvider")
    public void tcWikipedia(String animal) throws Exception {
        driver.get("http://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys(animal);
        driver.findElement(By.className("formBtn")).click();
        String animalName = driver.findElement(By.xpath("//h1[@id='firstHeading']")).getText();
        Assert.assertTrue(animal.equals(animalName.trim()));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    
}
