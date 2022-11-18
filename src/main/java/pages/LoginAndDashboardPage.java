package pages;

import org.openqa.selenium.By;

import testBase.DriverFactory;
import testBase.TestBase;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class LoginAndDashboardPage extends TestBase {

	By LOGIN_FIRST = By.xpath("//button//span[text()=\"Login\"]");
	By USERNAME = By.id("username");
	By PASSWORD = By.id("password");
	By LOGIN_BTN = By.xpath("//button[@type='submit']");
	By WIDGET_BTN = By.xpath("//h6[contains(text(),'SMS Campaign Admin')]");
	By LEFT_ARROW_ICON = By.xpath("//div[@class='jss11'] //span[@class='MuiTouchRipple-root']");

	// login to App
	public void login(String Username, String password) {

		highLight_Element(DriverFactory.getInstance().getDriver().findElement(LOGIN_FIRST));
		click_custom(DriverFactory.getInstance().getDriver().findElement(LOGIN_FIRST),
				"Appears first time when we login");
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(USERNAME));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(USERNAME), "LoginUsernameFIeld", Username);
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(PASSWORD));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(PASSWORD), "LoginPasswordFIeld", password);
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(LOGIN_BTN));
		click_custom(DriverFactory.getInstance().getDriver().findElement(LOGIN_BTN), "LoginButton");
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(WIDGET_BTN));
		click_custom(DriverFactory.getInstance().getDriver().findElement(WIDGET_BTN),
				"Click the SMS Campaign Admin widget!");
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(LEFT_ARROW_ICON));
		click_leftarrowIcon(DriverFactory.getInstance().getDriver().findElement(LEFT_ARROW_ICON));

	}
}

//login to App
//public void login(String Username, String password) {
//
//	click_custom(LOGIN_FIRST, "Appears first time when we login");
//	sendKeys_custom(USERNAME, "LoginUsernameFIeld", Username);
//	sendKeys_custom(PASSWORD, "LoginPasswordFIeld", password);
//	click_custom(LOGIN_BTN, "LoginButton");
//	click_custom(WIDGET_BTN, "Click the SMS Campaign Admin widget!");
//	click_leftarrowIcon(LEFT_ARROW_ICON);
//}
