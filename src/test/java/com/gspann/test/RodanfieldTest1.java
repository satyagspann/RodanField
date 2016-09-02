package com.gspann.test;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RodanfieldTest1 {

	@Test
	
	public void test1() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.rodanandfields.com/ca/");
		
		driver.findElement(By.xpath("//a[contains(text(),'BECOME A CONSULTANT')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Enroll Now')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Rodan + Fields Policies and Procedures')]")).click();
		Thread.sleep(3000);
		 String handle = driver.getWindowHandle();
		 Set<String> allwin = driver.getWindowHandles();
		 for(String s : allwin){
			 if(s.equals(handle)== false){
				 driver.switchTo().window(s);
			 }
		 }
		//verify the opened link is of Policies_Procedures
		String URL = driver.getCurrentUrl();
	    System.out.println(URL);
	    Assert.assertTrue(URL.contains("Policies_Procedures_CANADA.pdf"),"Mismatch");
	    
	    driver.navigate().back();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//input[@id='sponserparam']")).sendKeys("test");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@id='search-sponsor-button']")).click();
	    Thread.sleep(3000);
	    
	    List <WebElement> list = driver.findElements(By.xpath("//input[@class='btn btn-primary']"));		   
	    System.out.println("Total number of list:" +list );
	    
	    driver.close();
	    
	}
}
