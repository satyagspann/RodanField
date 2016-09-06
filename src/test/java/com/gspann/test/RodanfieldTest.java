package com.gspann.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class RodanfieldTest {

	WebDriver driver; 	
	@Parameters(" browser ")
	@Test
	public void test(String browser) throws InterruptedException, IOException{
		
		
		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"F:/Software/chromedriver.exe/");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.rodanandfields.com/ca/");
		driver.findElement(By.xpath("//a[@id='our-products']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'All Products')]")).click();
		
		//Verify page

		 String URL = driver.getCurrentUrl();
	     System.out.println(URL);
	     Assert.assertTrue(URL.contains("/quickShop"),"Mismatch");
		
		driver.findElement(By.xpath("//div[@id='quick-refine']/div[2]/div[1]/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'REDEFINE')]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@class='repaired-checkbox']")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[contains(text(),'REVERSE')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@id='quick-refine']/div[2]/div[2]/input")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[text()='CAD$0 TO CAD$49.99']")).click();
	    
	    //Verify the Reverse and Redefine filter labels along with checkboxes on the page
	    Assert.assertFalse(driver.findElement(By.xpath("//div[@class='repaired-checkbox")).isSelected(),"Mismatch");
	    Assert.assertFalse(driver.findElement(By.xpath("//div[@class='repaired-checkbox")).isSelected(),"Mismatch");
	    
	    File sFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sFile, new File("E:/image.jpg"));
        
		driver.close();
		
	}
}
