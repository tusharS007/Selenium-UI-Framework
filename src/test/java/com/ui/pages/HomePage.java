package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constant.Browser;
import com.constant.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LOCATOR = By.className("login");
	
	public HomePage(Browser driver, boolean isHeadless) {
		super(driver, isHeadless);
		//goToWebsite(PropertiesUtil.readProperties(Env.QA, "URL"));
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
	}


	public LoginPage goToLoginPage() {
		logger.info("Performing click operation to go Sign in Page");
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}	
	
}
