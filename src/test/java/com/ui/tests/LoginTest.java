package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listners.TestListener.class)
public class LoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@Test(description = "Verify if the Valid user able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Tushar Shelar");

	}

	@Test(description = "Verify if the Valid user able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginDataProviderCSV")
	public void loginTestCSV(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Tushar Shelar");

	}

	@Test(description = "Verify if the Valid user able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginDataProviderExcel", retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
	public void loginTestExcel(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Tushar Shelar");

	}

}
