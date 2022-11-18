package pages;

import org.openqa.selenium.By;
import testBase.*;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class ActivateCampaignPage extends TestBase {

	By activateCampaignOption = By.xpath("//span[contains(text(),'Activate Campaign')]");
	By hActivateCampaign = By.xpath("//h1[contains(text(),'Activate Campaign')]");
	By txtCampaignId = By.name("campaign ID");
	By lblCampaignStatus = By.xpath("//i[1]");
	By txtNumber = By.name("number");
	By drpNumberType = By.xpath("//p[contains(text(), '')]");
	By drpNumberTypeOption = By.xpath("//div[contains(@id,\"option-1\")]");
	By srcAccountName = By.xpath("//input[@id='search-account-name']");
	By selectAccount = By.xpath("//li[@id='search-account-name-option-5']");
	By btnSubmit = By.className("MuiButton-label");
	By lblSubTitle = By.cssSelector(".MuiTypography-root.MuiTypography-subtitle1");
	By lblCampaignName = By.cssSelector(".MuiTypography-root.MuiTypography-h1");
	By srcAccountName1 = By.xpath("//input[@id='search-account-name']");
	By selectAccount1 = By.xpath("//li[@id='search-account-name-option-0']");

	public void submitActivateCampaignRequest(String campaignId, String number, String accountName) {
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(activateCampaignOption));
		click_custom(DriverFactory.getInstance().getDriver().findElement(activateCampaignOption),
				"activateCampaignOption");
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(txtCampaignId));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txtCampaignId), "txtCampaignId",
				campaignId);
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(txtNumber));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(txtNumber), "txtNumber", number);
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(drpNumberType));
		click_custom(DriverFactory.getInstance().getDriver().findElement(drpNumberType), "drpNumberType");
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(drpNumberTypeOption));
		click_custom(DriverFactory.getInstance().getDriver().findElement(drpNumberTypeOption), "drpNumberTypeOption");
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(srcAccountName1));
		click_custom(DriverFactory.getInstance().getDriver().findElement(srcAccountName1), "srcAccountName1");
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(srcAccountName1));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(srcAccountName1), "srcAccountName1",
				accountName);
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(selectAccount1));
		click_custom(DriverFactory.getInstance().getDriver().findElement(selectAccount1), "selectAccount1");
		highLight_Element(DriverFactory.getInstance().getDriver().findElement(btnSubmit));
		click_custom(DriverFactory.getInstance().getDriver().findElement(btnSubmit),"btnSubmit");
	}
}

//click_custom(activateCampaignOption, "activateCampaignOption");
//sendKeys_custom(txtCampaignId, "txtCampaignId", campaignId);
////DriverFactory.getInstance().getDriver().findElement(lblCampaignStatus).isDisplayed();
//sendKeys_custom(txtNumber, "txtNumber", number);
//click_custom(drpNumberType, "drpNumberType");
//click_custom(drpNumberTypeOption, "drpNumberTypeOption");
//click_custom(srcAccountName1, "srcAccountName1");
//sendKeys_custom(srcAccountName1, "srcAccountName1", accountName);
//click_custom(selectAccount1, "selectAccount1");
//click_custom(btnSubmit, "btnSubmit");
