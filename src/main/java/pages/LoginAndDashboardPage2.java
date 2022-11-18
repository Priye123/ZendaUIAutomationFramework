package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import reusableComponents.ActionEngine;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class LoginAndDashboardPage2 extends ActionEngine {

	By LOGIN_FIRST = By.xpath("//button//span[text()=\"Login\"]");
	By USERNAME = By.id("username");
	By PASSWORD = By.id("password");
	By LOGIN_BTN = By.xpath("//button[@type='submit']");
	By WIDGET_BTN = By.xpath("//h6[contains(text(),'SMS Campaign Admin')]");
	By LEFT_ARROW_ICON = By.xpath("//div[@class='jss11'] //span[@class='MuiTouchRipple-root']");

	// login to App
	public void login(String Username, String password) {

		click_custom(LOGIN_FIRST, "Appears first time when we login");
		sendKeys_custom(USERNAME, "LoginUsernameFIeld", Username);
		sendKeys_custom(PASSWORD, "LoginPasswordFIeld", password);
		click_custom(LOGIN_BTN, "LoginButton");
		// sleepTime_custom(1500);
		click_custom(WIDGET_BTN, "Click the SMS Campaign Admin widget!");
		click_leftarrowIcon(LEFT_ARROW_ICON);
	}

	// login to App
	public void logintoVerifyCredentials(String Username, String password) {

		click_custom(LOGIN_FIRST, "Appears first time when we login");
		sendKeys_custom(USERNAME, "LoginUsernameFIeld", Username);
		sendKeys_custom(PASSWORD, "LoginPasswordFIeld", password);
		click_custom(LOGIN_BTN, "LoginButton");		
	}
}
