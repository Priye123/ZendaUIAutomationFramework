package pages;

import org.openqa.selenium.By;

import testBase.TestBase;

public class FeeConfigurationPage extends TestBase {

	By feePage = By.xpath("//span[text()='Fee Configuration ']");
	By search = By.xpath("//input[@placeholder='Global Student Search']");
	//By angleIcon = By.xpath("(//mat-panel-description[text()='Current Outstanding: 350 ']");
	By selectBox = By.xpath("//*[@id='mat-checkbox-11']/label/div");
	By paymentModeasCash = By.xpath("//mat-select[@aria-label='Payment Mode']//span[text()='Cash']");
	By payBtn = By.xpath("//span[text()='Pay']");


	public void feeCollect() {

		explicitWait(feePage, "click on fee section");
//		click_custom(angleIcon, "Icon");
//		click_custom(feePage, "feePage");
		sendKeys_custom(search, "search", "200011312");
		sendKeys_custom(search, "search", "Keys.ENTER");
		sleepTime_custom(2000);
		//click_custom(angleIcon, "click on arrow Icon");
		//explicitWait(selectBox, "checkbox");
		//click_custom(paymentModeasCash, "choose cash from payment mode dropdown");
	}
}
