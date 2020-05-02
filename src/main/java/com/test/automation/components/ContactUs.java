package com.test.automation.components;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.basePage.BasePage;

public class ContactUs extends BasePage {
  //Intializing the Page Objects:
	
	public ContactUs()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[name='first_name']")
	private WebElement firstName;

	@FindBy(css="input[name='last_name']") 
	private WebElement lastName;

	@FindBy(css="input[name='email']")
	private WebElement emailAddress;

	@FindBy(css="textarea[name='message']")
	private WebElement comments;

	@FindBy(css="input[value='SUBMIT']")
	private WebElement submitButton;

	@FindBy(css="input[value='RESET']")
	private WebElement resetButton;

	@FindBy(css="#contact_reply > h1")
	private WebElement successfulSubmissionHeader;

	@FindBy(css="body")
	private WebElement unSuccessfulSubmissionHeader;

	public WebElement getFirstName()
	{
		return this.firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName.sendKeys(firstName);
	}

	public WebElement getLastName()
	{
		return this.lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName.sendKeys(lastName);
	}
	public WebElement getEmailAddress()
	{
		return this.emailAddress;
	}
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress.sendKeys(emailAddress);
	}
	public WebElement getComments()
	{
		return this.comments;
	}
	public void setComments(String comments)
	{
		this.comments.sendKeys(comments);
	}
	public WebElement getSubmitButton()
	{
		return this.submitButton;
	}
	public void clickSubmitButton()
	{
		this.submitButton.click();
	}
	public WebElement getResetButton()
	{
		return this.resetButton;
	}
	public void clickResetButton()
	{
		this.resetButton.click();
	}
	public WebElement getSuccessfulSubmissionHeader()
	{
		return this.successfulSubmissionHeader;
	}
	public WebElement getUnSuccessfulSubmissionHeader()
	{
		return this.unSuccessfulSubmissionHeader;
	}
	// Actions
	public void submitAllInformationViaContactUsForm(String firstName,String lastName,String emailAddress,String comments)
	{
		this.getFirstName().sendKeys(firstName);
		this.getLastName().sendKeys(lastName);
		this.getEmailAddress().sendKeys(emailAddress);
		this.getComments().sendKeys(comments);
		this.getSubmitButton().click();
	}

	public String getContactUsPageTitle()
	{
		return driver.getTitle();

	}
}
