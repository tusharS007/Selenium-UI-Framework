package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_LOCATOR = By.name("email");
	private static final By PASSWORD_LOCATOR = By.name("passwd");
	private static final By SUBMIT_LOCATOR = By.name("SubmitLogin");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MyAccountPage doLoginWith(String email, String password) {
		
		enterText(email, EMAIL_LOCATOR);
		enterText(password, PASSWORD_LOCATOR);
		clickOn(SUBMIT_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
		
	}

}
