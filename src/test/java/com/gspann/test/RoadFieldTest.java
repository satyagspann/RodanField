package com.gspann.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gspann.pageobjects.RodanFieldHomePage;

public class RoadFieldTest {

	WebDriver driver;
	
	@BeforeMethod
	public void initializeDriver(){
		driver = new FirefoxDriver();
		
	}
	@Test
	public void rodanFieldTestCase() throws InterruptedException, IOException{
		RodanFieldHomePage page = new RodanFieldHomePage(driver);
		page.openUrl();
		page.implicitWait();
		page.maximizeWindow();
		page.printCurrentUrl();
		page.clickOnShopeSkine();
		page.clickOnAllProducts();
		String url=page.verifyurl();
		Assert.assertTrue(url.contains("quickShop"), "The user is not navigate to other page");
		System.out.println("The user is navigated to quickShop page");
		page.clickOnRedefineBox();
		page.clickOnRedefineCheckBox();
		page.clickOnReverseProduct();
		page.clickOnReverseCheckBox();
		page.clickOnPrice();
		page.clickOnPriceChooseBox();
		String redefine = page.verifyOnRedefineLabel();
		Assert.assertEquals(redefine, "REDEFINE");
		System.out.println("The label Redefine Exists on page");
		String reverse = page.verifyOnReverseLabel();
		Assert.assertEquals(reverse, "REVERSE");
		System.out.println("The label Reverse Exists on page");
		String checkedBox = page.SelectedRedefineCheckBox();
		Assert.assertTrue(checkedBox.equalsIgnoreCase("repaired-checkbox checked"),"checkedBox");
		System.out.println("The selected box is checked on page");
		String RevrcheckedBox = page.SelectedRedefineCheckBox();
		Assert.assertTrue(RevrcheckedBox.equalsIgnoreCase("repaired-checkbox checked"),"RevrcheckedBox");
		System.out.println("The selected box is checked on page");
		boolean PriceVerify = page.verifyProductPrice();
		Assert.assertTrue(PriceVerify, "The verifyPrice value");
		System.out.println("Verify the product range in CAD$50 TO CAD$199.99");
		page.takeScreenShot();
		driver.close();
	}
}
