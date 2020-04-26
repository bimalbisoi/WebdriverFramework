package com.test.automation.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.automation.basePage.BasePage;
import com.test.automation.pageObjects.ContactUsPage;

public class ContactUsPageTestDemo extends BasePage{

	@BeforeMethod
	public void setUp()
	{
		getDriver();
		open("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
	}
	@AfterMethod
	public void tearDown()
	{
		close();
	}
	@Test
   public void ContactUsTest()
	{

	ContactUsPage.getContactUs().submitAllInformationViaContactUsForm("Sachin", "tendukar", "sachin@test.com", "crickter");
		
		
	}
	

}
