package com.test.automation.dataProviders;

import org.testng.annotations.DataProvider;

import com.test.automation.utils.Config;

public class LoginPageDataProvider {

	/*
	 * String loginPageUrl = Config.getConfigProperty("BASE_URL"); => Here we read
	 * the url from properties file Here we are passing it from command prompt(using
	 * "mvn test -DbaseUrl=http://www.webdriveruniversity.com/Contact-Us/contactus.html"
	 * ) instead of read the url from properties file
	 */

	public static String baseUrl = System.getProperty("baseUrl");

	/**
	 * This DataProvider returns login page crdentials as well as the login page url
	 *
	 * @return the login page crdentials
	 */
	@DataProvider(name = "LoginPageCredentialsDataProvider")
	public static Object[][] getLoginPageCrdentials() {
		String loginPageUrl = baseUrl;
		String firstName = Config.getConfigProperty("FIRST_NAME");
		String lastName = Config.getConfigProperty("LAST_NAME");
		String email = Config.getConfigProperty("EMAIL");
		String comments = Config.getConfigProperty("COMMENTS");

		return new Object[][] { { loginPageUrl, firstName, lastName, email, comments } };

	}

}
