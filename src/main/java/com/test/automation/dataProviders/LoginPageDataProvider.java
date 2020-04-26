package com.test.automation.dataProviders;

import org.testng.annotations.DataProvider;

import com.test.automation.utils.Config;

public class LoginPageDataProvider {

	/**
	 * This DataProvider returns login page crdentials as well as the login page url
	 *
	 * @return the login page crdentials
	 */
	@DataProvider(name = "LoginPageCredentialsDataProvider")
	public static Object[][] getLoginPageCrdentials() {
		String loginPageUrl = Config.getConfigProperty("BASE_URL");
		String firstName = Config.getConfigProperty("FIRST_NAME");
		String lastName = Config.getConfigProperty("LAST_NAME");
		String email = Config.getConfigProperty("EMAIL");
		String comments = Config.getConfigProperty("COMMENTS");

		return new Object[][] { { loginPageUrl, firstName, lastName, email, comments } };

	}

}
