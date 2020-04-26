package com.test.automation.basePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.utils.WebEventListener;

public class BasePage {

	public static  WebDriver driver;
	
	public static EventFiringWebDriver edriver;
	public static WebEventListener eventListner;
	/**
	 * 
	 * This method initialise the driver and return the driver instance.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver() 
	
	{
		String browserName= "chrome";
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/bimalendu/chromedriver");
			driver= new ChromeDriver();
			}

		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","/Users/bimalendu/IEDriver");
			driver=new InternetExplorerDriver();
		}
		
		edriver= new EventFiringWebDriver(driver);
		//Creating the object of WebEventListener class (which defined under Utils package) to register it with EventFiringWebdriver
		eventListner = new WebEventListener();
		edriver.register(eventListner);
		driver=edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	/**
	 * This method opens a url
	 *
	 * @param url the url
	 */
	public void open(String url)
	{
		driver.get(url);
	}
	
	/**
	 * This method Closes browser.
	 */
	public void close()
	{
		driver.quit();
	}
}
