package com.test.automation.basePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends BasePage{
    public ExtentReports extent;
	public ExtentTest extentTest;

	@BeforeTest
	public void setExtent(){
	/*	Creating the object of ExtentHtmlReporter class and pass the path where do we need to store the report
		Make sure This "Reports" folder should create in advance within our project before start execution"*/
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/Extentreport.html");
		//Creating the object of ExtentReports class
		extent = new ExtentReports();
		extent.attachReporter(reporter);	
	}
	@AfterTest
	public void endReport(){
		//This flush() method to write or update test information to your reporter once execution completed
		extent.flush();
	}
	
	/**
	 * Gets the screenshot.
	 *
	 * @param screenshotName the screenshot name
	 * @return the screenshot path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String getScreenshot(String screenshotName) throws IOException{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile= ts.getScreenshotAs(OutputType.FILE);
		String currentDirectory=System.getProperty("user.dir");
		String destinationpath=currentDirectory + "/ExtentReportScreenshots/" + screenshotName + System.currentTimeMillis() + ".png" ;
		File  destFile= new File(destinationpath);
		FileUtils.copyFile(srcFile, destFile);
		return destinationpath;
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(Status.FAIL, "Test case failed and Test case name is  : "+result.getName()); //to add name of failed test case in extent report	
			String screenshotPath = BaseTest.getScreenshot(result.getName());
			// Calling the created screenshot method which returns the screenshot path		
			//to add screenshot in extent report
		extentTest.log(Status.FAIL, result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(Status.SKIP, "Test Case skipped and Test case name is : " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(Status.PASS, "Test case passed and Test case name is :  " + result.getName());

		}
		//extent.removeTest(extentTest); //ending test and ends the current test and prepare to create html report
		close();
	}

}
