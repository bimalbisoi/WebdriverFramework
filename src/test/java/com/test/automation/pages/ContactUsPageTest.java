package com.test.automation.pages;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.test.automation.basePage.BasePage;
import com.test.automation.basePage.BaseTest;
import com.test.automation.dataProviders.LoginPageDataProvider;
import com.test.automation.pageObjects.ContactUsPage;
import com.test.automation.validators.ContactUsPageValidator;

public class ContactUsPageTest extends BaseTest{

     /**
	 * This method do the login with the provided credentials
	 *
	 * @param url the url
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 * @param comments the comments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test(dataProvider="LoginPageCredentialsDataProvider",dataProviderClass=LoginPageDataProvider.class,enabled=true)
   public void loginPageTest(String url,String firstName,String lastName,String email,String comments ) throws IOException
	{
	extentTest=extent.createTest("loginPageTest");
	WebDriver driver=BasePage.getDriver();
	SoftAssert sa= new SoftAssert();
	ContactUsPage.getContactUs().open(url);
    ContactUsPageValidator validator= new ContactUsPageValidator(driver,sa);
	validator.validatesContactusPageTitle();
	ContactUsPage.getContactUs().submitAllInformationViaContactUsForm(firstName, lastName, email, comments);
	validator.validatesSuccessfulSubmission();
	//ContactUsPage.getContactUs().close();
	sa.assertAll();

	}

}
