package com.gspann.pageobjects;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class RodanFieldConsultantPage {

	 WebDriver driver;
	 String handle;
	
	private static By Become_consultant=By.xpath("//a[contains(text(),'BECOME A CONSULTANT')]");
	private static By Enroll_Now=By.xpath("//a[contains(text(),'Enroll Now')]");
	private static By Rodanfield_Policies=By.xpath("//a[contains(text(),'Rodan + Fields Policies and Procedures')]");
	private static By Enter_Text=By.xpath("//input[@id='sponserparam']");
	private static By ClickOnSearch_Btn=By.xpath("//button[@id='search-sponsor-button']");
	private static By Select_Btn=By.xpath("//div[@id='search-results']/div/div[1]/form/div");
	private static By Verify_Name=By.xpath("//div[@id='sponsorInfo']/div[1]/a");
	
	public RodanFieldConsultantPage(WebDriver driver){
		this.driver = driver;
	}
	public void openUrl(){
		String Url = "https://www.rodanandfields.com/ca/";
		driver.get(Url);
	}
	public void ImplicitWait(){
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void maximizeWindow(){
		driver.manage().window().maximize();
	}
	public void clickOnBecomeConsultant() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Become_consultant).click();
	}
	public void clickOnEnrollNow() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Enroll_Now).click();
	}
	public void clickOnRodanFieldPoliciesLink() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Rodanfield_Policies).click();
	}
	public void switchWindowHandle(){
		handle = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		 for(String s : allwin){
			 if(s.equals(handle)== false){
				 driver.switchTo().window(s);
				 
			 }
		 }
	}
	
	public String verifyPoliciesAndProcedurePage(){
		String policies = driver.getCurrentUrl();
		return policies;
	}
	public void windowHandle() throws InterruptedException{
		driver.close();
		driver.switchTo().window(handle);
	}
	
	public void enterText(String text) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Enter_Text).sendKeys(text);
	}
	public void clickOnSearchButton(){
		driver.findElement(ClickOnSearch_Btn).click();
	}
	public void clickOnSelectButton() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Select_Btn).click();
	}
	public String VerifyName() throws InterruptedException{
		Thread.sleep(3000);
		String name = driver.findElement(Verify_Name).getText();
		return name;
	}
	public void takeScreenShot() throws IOException{
		 File sFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sFile, new File("E:/Selenium_shubham/SeleniumTest/test-output/ScreenShot/images.png"));
	 }
}
