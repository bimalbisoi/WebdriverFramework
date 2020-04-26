package com.test.automation.validators;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.test.automation.pageObjects.ContactUsPage;
import com.test.automation.utils.Config;

/**
 * The Class ContactUsPageValidator.
 */
public class ContactUsPageValidator {

	public WebDriver driver;
	public SoftAssert softAssert;

	/**
	 * Instantiates a new contact us page validator.
	 *
	 * @param driver     the driver
	 * @param softAssert the soft assert
	 */
	public ContactUsPageValidator(WebDriver driver, SoftAssert softAssert) {
		this.driver = driver;
		this.softAssert = softAssert;
	}

	/**
	 * Validates contactus page title.
	 *
	 * @return the contact us page validator
	 */
	public ContactUsPageValidator validatesContactusPageTitle()

	{
		softAssert.assertEquals(ContactUsPage.getContactUs().getContactUsPageTitle(),
				Config.getConfigProperty("LOGIN_PAGE_TITLE"), "ContactUs Page Title did not match");
		return this;

	}

	/**
	 * Validates successful submission.
	 */
	public void validatesSuccessfulSubmission()

	{
		softAssert.assertEquals(ContactUsPage.getContactUs().getSuccessfulSubmissionHeader().isDisplayed(), true,
				"Login did not successful");

	}
}
