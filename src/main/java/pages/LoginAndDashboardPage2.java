package pages;

import org.openqa.selenium.By;

import reusableComponents.ActionEngine;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class LoginAndDashboardPage2 extends ActionEngine {

	By USERNAME = By.id("txtuser");
	By PASSWORD = By.id("txtpassword");
	By LOGIN_BTN = By.id("log-btn");
	

	// login to App
	public void login(String Username, String password) {

		sendKeys_custom(USERNAME, "LoginUsernameFIeld", Username);
		sendKeys_custom(PASSWORD, "LoginPasswordFIeld", password);
		click_custom(LOGIN_BTN, "LoginButton");

	}

}
