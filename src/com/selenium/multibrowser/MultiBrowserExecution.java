package com.selenium.multibrowser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MultiBrowserExecution {

    private WebDriver driver;
    private String URL = "http://www.calculator.net";
    @Parameters("browser")
    @BeforeTest
    public void launchapp(String browser)
    {
       if (browser.equalsIgnoreCase("firefox"))
       {
          System.out.println(" Executing on FireFox");
          driver = new FirefoxDriver();
          driver.get(URL);
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.manage().window().maximize();
       }
       else if (browser.equalsIgnoreCase("chrome"))
       {
          System.out.println(" Executing on CHROME");
          System.out.println("Executing on IE");
          
          File f = new File("lib"+File.separator+"chromedriver_win.exe");
          
          System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
          driver = new ChromeDriver();
          driver.get(URL);
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.manage().window().maximize();
       }
       else if (browser.equalsIgnoreCase("ie"))
       {
          System.out.println("Executing on IE");
          
          File f = new File("lib"+File.separator+"IEDriverServer(x86).exe");
          
          System.setProperty("webdriver.ie.driver", f.getAbsolutePath());
          driver = new InternetExplorerDriver();
          driver.get(URL);
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.manage().window().maximize();
       }
       else
       {
          throw new IllegalArgumentException("The Browser Type is Undefined");
       }
    }
    
    @Test
    public void calculatepercent()
    {
       // Click on Math Calculators
       driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a")).click();
       // Click on Percent Calculators
       driver.findElement(By.xpath(".//*[@id='menu']/div[4]/div[3]/a")).click();
       // Enter value 10 in the first number of the percent Calculator
       driver.findElement(By.id("cpar1")).sendKeys("10");
       // Enter value 50 in the second number of the percent Calculator
       driver.findElement(By.id("cpar2")).sendKeys("50");
       // Click Calculate Button
       driver.findElement(By.xpath("//input[@value='Calculate']")).click();
       // Get the Result Text based on its xpath
       String result = driver.findElement(By.xpath("//p[@class='verybigtext']/font[@color='green']/b")).getText();        
       
       // Print a Log In message to the screen
       System.out.println(" The Result is " + result);
       
       if(result.equals("5"))
       {
          System.out.println(" The Result is Pass");
       }
       else
       {
          System.out.println(" The Result is Fail");
       }
    }
    
    @AfterTest
    public void closeBrowser()
    {
       driver.quit();
    }
    
}
