package pages;

import org.openqa.selenium.By;

import testBase.TestBase;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class ActivateCampaignPage2 extends TestBase {

	By activateCampaignOption = By.xpath("//span[contains(text(),'Activate Campaign')]");
	By hActivateCampaign = By.xpath("//h1[contains(text(),'Activate Campaign')]");
	By txtCampaignId = By.name("campaign ID");
	By lblCampaignStatus = By.xpath("//i[1]");
	By txtNumber = By.name("number");
	By drpNumberType = By.xpath("//p[contains(text(), '')]");
	By drpNumberTypeOption0 = By.xpath("//div[contains(@id,\"option-0\")]");
	By drpNumberTypeOption1 = By.xpath("//div[contains(@id,\"option-1\")]");
	By drpNumberTypeOption2 = By.xpath("//div[contains(@id,\"option-2\")]");
	By srcAccountName = By.xpath("//input[@id='search-account-name']");
	By selectAccount = By.xpath("//li[@id='search-account-name-option-5']");
	By selectAccount2 = By.xpath("//li[@id='search-account-name-option-70']");
	By btnSubmit = By.className("MuiButton-label");
	By lblSubTitle = By.cssSelector(".MuiTypography-root.MuiTypography-subtitle1");
	By lblCampaignName = By.cssSelector(".MuiTypography-root.MuiTypography-h1");
	By srcAccountName1 = By.xpath("//input[@id='search-account-name']");
	By selectAccount1 = By.xpath("//li[@id='search-account-name-option-0']");
	By migrateflag = By.xpath("//input[@data-indeterminate=\"false\" and @type=\"checkbox\"]");
	By clickOnProjectId = By.xpath("(//div[@aria-invalid=\"false\"])[3]");
	By selectProjectId = By.xpath("//div[text()=\"6c97f06c-0b64-456c-b4be-70bf17bee5f7\"]");
	By clickOnnnid = By.xpath("(//div[@aria-invalid=\"false\"])[2]");
	By selectnnid = By.xpath("//div[text()=\"104157\"]");

	// check provision flow
	public void submitActivateCampaignRequest(String campaignId, String number, String accountName) {
		click_custom(activateCampaignOption, "activateCampaignOption");
		sendKeys_custom(txtCampaignId, "txtCampaignId", campaignId);
		// DriverFactory.getInstance().getDriver().findElement(lblCampaignStatus).isDisplayed();
		sendKeys_custom(txtNumber, "txtNumber", number);
		click_custom(drpNumberType, "drpNumberType");
		click_custom(drpNumberTypeOption1, "drpNumberTypeOption1");
		click_custom(srcAccountName1, "srcAccountName1");
		sendKeys_custom(srcAccountName1, "srcAccountName1", accountName);

		if (accountName.equals("Sinch"))
			click_custom(selectAccount2, "selectAccount1");
		else
			click_custom(selectAccount1, "selectAccount1");

		click_custom(btnSubmit, "btnSubmit");
	}

	// migrate flow ON
	public void submitActivateCampaignRequest(String campaignId, String number, String accountName,
			boolean migrateFlag) {
		click_custom(activateCampaignOption, "activateCampaignOption");
		sendKeys_custom(txtCampaignId, "txtCampaignId", campaignId);
		// DriverFactory.getInstance().getDriver().findElement(lblCampaignStatus).isDisplayed();
		sendKeys_custom(txtNumber, "txtNumber", number);
		click_custom(drpNumberType, "drpNumberType");
		click_custom(drpNumberTypeOption1, "drpNumberTypeOption1");

		if (migrateFlag) {
			click_custom(migrateflag, "tick the checkbox of migrate flag");
		}

		click_custom(srcAccountName1, "srcAccountName1");
		sendKeys_custom(srcAccountName1, "srcAccountName1", accountName);
		click_custom(selectAccount1, "selectAccount1");
		click_custom(btnSubmit, "btnSubmit");
	}

	// check provision flow with PROCURED,IMPORTED & TEXT-ENABLED
	public void submitActivateCampaignRequest(String campaignId, String number, String numberType, String accountName) {
		click_custom(activateCampaignOption, "activateCampaignOption");
		sendKeys_custom(txtCampaignId, "txtCampaignId", campaignId);
		// DriverFactory.getInstance().getDriver().findElement(lblCampaignStatus).isDisplayed();
		sendKeys_custom(txtNumber, "txtNumber", number);
		click_custom(drpNumberType, "drpNumberType");

		if (numberType.equals("PROCURED")) {
			click_custom(drpNumberTypeOption0, "drpNumberTypeOption0");
		} else if (numberType.equals("IMPORTED")) {
			click_custom(drpNumberTypeOption1, "drpNumberTypeOption1");
		} else {
			click_custom(drpNumberTypeOption2, "drpNumberTypeOption2");
		}

		click_custom(srcAccountName1, "srcAccountName1");
		sendKeys_custom(srcAccountName1, "srcAccountName1", accountName);
		click_custom(selectAccount1, "selectAccount1");
		click_custom(btnSubmit, "btnSubmit");
	}

	// provision number with project-id
	public void submitActivateCampaignRequest(String campaignId, String number, boolean projectIdTaken,
			String accountName) {
		click_custom(activateCampaignOption, "activateCampaignOption");
		sendKeys_custom(txtCampaignId, "txtCampaignId", campaignId);
		// DriverFactory.getInstance().getDriver().findElement(lblCampaignStatus).isDisplayed();
		sendKeys_custom(txtNumber, "txtNumber", number);
		click_custom(drpNumberType, "drpNumberType");
		click_custom(drpNumberTypeOption1, "drpNumberTypeOption1");
		click_custom(srcAccountName1, "srcAccountName1");
		sendKeys_custom(srcAccountName1, "srcAccountName1", accountName);
		click_custom(selectAccount1, "selectAccount1");

		if (projectIdTaken) {
			click_custom(clickOnProjectId, "clickOnProjectId");
			click_custom(selectProjectId, "selectProjectId");
		}
		click_custom(btnSubmit, "btnSubmit");
	}

	// provision number with nnid to test PROCURED/TEXT-ENABLED number validation
	public void submitActivateCampaignRequest(String campaignId, String number, String numberType, String accountName,
			boolean nnidTaken) {
		click_custom(activateCampaignOption, "activateCampaignOption");
		sendKeys_custom(txtCampaignId, "txtCampaignId", campaignId);
		// DriverFactory.getInstance().getDriver().findElement(lblCampaignStatus).isDisplayed();
		sendKeys_custom(txtNumber, "txtNumber", number);
		click_custom(drpNumberType, "drpNumberType");

		if (numberType.equals("PROCURED")) {
			click_custom(drpNumberTypeOption0, "drpNumberTypeOption0");
		} else if (numberType.equals("IMPORTED")) {
			click_custom(drpNumberTypeOption1, "drpNumberTypeOption1");
		} else {
			click_custom(drpNumberTypeOption2, "drpNumberTypeOption2");
		}

		click_custom(srcAccountName1, "srcAccountName1");
		sendKeys_custom(srcAccountName1, "srcAccountName1", accountName);
		click_custom(selectAccount1, "selectAccount1");

		if (nnidTaken) {
			click_custom(clickOnnnid, "clickOnnnid");
			click_custom(selectnnid, "selectnnid");
		}
		click_custom(btnSubmit, "btnSubmit");
	}

	// provision number with number pool campaign
	public void submitActivateCampaignRequest(String campaignId, boolean numberPoolCampaign, String accountName,
			String number) {

		if (!numberPoolCampaign)
			return;

		click_custom(activateCampaignOption, "activateCampaignOption");
		sendKeys_custom(txtCampaignId, "txtCampaignId", campaignId);
		// DriverFactory.getInstance().getDriver().findElement(lblCampaignStatus).isDisplayed();
		sendKeys_custom(txtNumber, "txtNumber", number);
		click_custom(drpNumberType, "drpNumberType");
		click_custom(drpNumberTypeOption1, "drpNumberTypeOption1");
		click_custom(srcAccountName1, "srcAccountName1");
		sendKeys_custom(srcAccountName1, "srcAccountName1", accountName);
		click_custom(selectAccount1, "selectAccount1");
		click_custom(btnSubmit, "btnSubmit");

	}

}
