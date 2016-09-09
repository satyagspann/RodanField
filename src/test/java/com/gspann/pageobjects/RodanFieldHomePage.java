package com.gspann.pageobjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RodanFieldHomePage {

	private WebDriver driver;
    private static  By ShopeSkin=By.xpath("//a[@id='our-products']");
	private static  By All_Products=By.xpath("//a[contains(text(),'All Products')]");
	private static  By products= By.xpath("//input[@class='refine-products-button' and @value='- Product(s) -']");
	private static  By redefine_chk= By.xpath("//div[contains(text(),'REDEFINE')]/following-sibling::div/div");
	private static  By product= By.xpath("//input[@class='refine-products-button' and @value='- Product(s) -']");
	private static  By Revese_chk= By.xpath("//div[contains(text(),'REVERSE')]/following-sibling::div/div");
	private static  By Prices= By.xpath("//input[@class='refine-products-button' and @value='- Price -']");
	private static  By Price_choose= By.xpath("//div[contains(text(),'CAD$50 TO CAD$199.99')]/following-sibling::div/div");
	private static  By Redefine_label= By.xpath("//label[@for='REDEFINE']");
	private static  By Reverse_label= By.xpath("//label[@for='REVERSE']");
	private static  By Redefine_label_chk= By.xpath("//div[@id='quick-filtered']/ul[2]/li[1]/form/div");
	private static  By Reverse_label_chk= By.xpath("//div[@id='quick-filtered']/ul[2]/li[1]/form/div");
	private static  By Price_verify= By.xpath("//span[@class='your-price']");
	
	 public RodanFieldHomePage(WebDriver driver){
		 this.driver=driver;
	 }
	 
	 public void openUrl()
	 {
	    String Rodan_Url = "https://www.rodanandfields.com/ca/";
		driver.get(Rodan_Url);
     }
     public void implicitWait()
		{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		}
     public void maximizeWindow(){
    	 driver.manage().window().maximize();
     }

	 public void printCurrentUrl()
		{
			String currentURl=driver.getCurrentUrl();
			System.out.println("The Current Url is" + currentURl);
		}
	 public void clickOnShopeSkine() throws InterruptedException{
		 Thread.sleep(4000);
		 driver.findElement(ShopeSkin).click();
	 }
	 public void clickOnAllProducts() throws InterruptedException{
		 Thread.sleep(4000);
		 driver.findElement(All_Products).click();
	 }
	 public String verifyurl()
		{
			String quickshopUrl=driver.getCurrentUrl();
			return quickshopUrl;		
		}
	 public void clickOnRedefineBox() throws InterruptedException{
		 Thread.sleep(4000);
		 driver.findElement(products).click();
	 }
	 public void clickOnRedefineCheckBox() throws InterruptedException{
		 Thread.sleep(4000);
		 driver.findElement(redefine_chk).click();
	 }
	 public void clickOnReverseProduct() throws InterruptedException{
		 Thread.sleep(4000);
		 driver.findElement(product).click();
	 }
	 public void clickOnReverseCheckBox() throws InterruptedException{
		 Thread.sleep(4000);
		 driver.findElement(Revese_chk).click();
	 }
	 public void clickOnPrice() throws InterruptedException{
		 Thread.sleep(4000);
		 driver.findElement(Prices).click();
	 }
	 public void clickOnPriceChooseBox() throws InterruptedException{
		 Thread.sleep(4000);
		 driver.findElement(Price_choose).click();
	 }
	 
	 public String verifyOnRedefineLabel(){
		 String string = driver.findElement(Redefine_label).getText();
		 return string;
		 
	 }
	 public String verifyOnReverseLabel(){
		 String string = driver.findElement(Reverse_label).getText();
		 return string;
		 
	 }
	 public String SelectedRedefineCheckBox() throws InterruptedException{
		 Thread.sleep(3000);
		 WebElement redefine = driver.findElement(Redefine_label_chk);
		 String attributeRedefine = redefine.getAttribute("class");
		 System.out.println("The redefineAttribute value is :" +attributeRedefine);
		 return attributeRedefine;
		 }
	 public String SelectedReverseCheckBox() throws InterruptedException{
		 Thread.sleep(3000);
		 WebElement redefine = driver.findElement(Reverse_label_chk);
		 String attributeRedefine = redefine.getAttribute("class");
		 System.out.println("The redefineAttribute value is :" +attributeRedefine);
		 return attributeRedefine;
		 }
	 public boolean verifyProductPrice(){
		 String productPrice = driver.findElement(Price_verify).getText();
		 String prodprice[]=productPrice.split("\\s+");
		 Double amt=Double.parseDouble(prodprice[1]);
		  double startPrice=50.00;
		  double endPrice=199.99;
		  if(startPrice<amt && amt<endPrice){
		   return true;
		  }else{
		   return false;
		  }
		 }
	 
	 public void takeScreenShot() throws IOException{
		 File sFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(sFile, new File("E:/Selenium_shubham/SeleniumTest/test-output/ScreenShot/image.png"));
	 }
}
