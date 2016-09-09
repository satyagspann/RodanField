package com.gspann.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gspann.pageobjects.RodanFieldConsultantPage;

public class RodanFieldConsultantTest {

	WebDriver driver;
	
	@BeforeMethod
	public void initializeDriver(){
		driver = new FirefoxDriver();
	}
	@Test
	public void RodanSecondTestCase() throws InterruptedException, IOException{
		RodanFieldConsultantPage Cpage = new RodanFieldConsultantPage(driver);
		Cpage.openUrl();
		Cpage.ImplicitWait();
		Cpage.maximizeWindow();
		Cpage.clickOnBecomeConsultant();
		Cpage.clickOnEnrollNow();
		Cpage.clickOnRodanFieldPoliciesLink();
		Cpage.switchWindowHandle();
		String Url = Cpage.verifyPoliciesAndProcedurePage();
		Assert.assertTrue(Url.contains("Policies_Procedures_CANADA.pdf"),"The user is not navigate to other page");
		System.out.println("The Policies_Procedures_CANADA.pdf verify on page");
		Cpage.windowHandle();
		Cpage.enterText("test");
		Cpage.clickOnSearchButton();
		Cpage.clickOnSelectButton();
		String verify = Cpage.VerifyName();
		Assert.assertEquals(verify, "Michael Brand");
		System.out.println("Verified Michael Brand name top left corner");
		Cpage.takeScreenShot();
		driver.quit();
	}
}
