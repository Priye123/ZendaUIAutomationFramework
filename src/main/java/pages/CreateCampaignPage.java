package pages;

import org.openqa.selenium.By;

import testBase.TestBase;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class CreateCampaignPage extends TestBase {

	By createCampaignOption = By.xpath("//span[contains(text(),'Create Campaign')]");
	By srcAccountName = By.xpath("//input[@id='search-account-name']");
	By selectAccount = By.xpath("//li[@id='search-account-name-option-0']");
	By selectAccount1 = By.xpath("//li[@id='search-account-name-option-70']");
	By clickOnProjectId = By.xpath("(//div[@aria-invalid=\"false\"])[2]");
	By selectProjectId = By.xpath("//div[text()=\"6c97f06c-0b64-456c-b4be-70bf17bee5f7\"]");
	By selectProjectId1 = By.xpath("//div[text()=\"0fc52975-636a-4700-8943-68759df5c9e1\"]");
	By nextBtn = By.xpath("//button//span[text()=\"Next\"]");
	By srcBrand = By.xpath("//div[@class=\"css-1pcexqc-container\"]");
	By selectBrandOption = By.xpath("//div[text()=\"BS1MBHL | Bundle 27.07.2022 \"]");
	By selectBrandOption1 = By.xpath("//div[text()=\"BK7OVPO | Bundle 2 27.07.2022 revet\"]");
	By selectBrandOption2 = By.xpath("//div[text()=\"BK6PGHA | Sinch Test Mike\"]");
	By selectBrandOption3 = By.xpath("//div[text()=\"B6UDKYI | ABC Mobile\"]");
	By srcUsecase = By.xpath("//p[contains(text(), '')]");
	By selectUsecaseOption = By.xpath("//div[text()=\"2FA\"]");
	By chkQualifyBtn = By.xpath("//button//span[text()=\"Check Qualification\"]");
	By next = By.xpath("//span[normalize-space()='Next']");
	By campaignName = By.xpath("//input[@placeholder='Enter Campaign Name']");
	By campaignDesc = By.xpath("//textarea[@placeholder='Enter Campaign Description']");
	By srcVertical = By.xpath("//p[contains(text(), '')]");
	By selectVerticalOption = By.xpath("//div[contains(@id,\"option-0\")]");
	// By disableTMO = By.xpath("//input[@name='enableTmoBilling' and
	// @value=\"false\" ]");
	By enableNumberPool = By.xpath("//input[@name='numberPool' and @value=\"true\" ]");
	By disableTCR = By.xpath("//input[@name='enableTcrBilling' and @value=\"false\" ]");
	// By msgFlow = By.xpath("//input[@placeholder='Enter Message Flow']");
	By callToAction = By.xpath("//input[@placeholder='Enter Call to Action']");
	By helpMsg = By.xpath("//input[@placeholder='Enter Help Message']");
	By optInKeywords = By.name("optinKeyword");
	By optInMessage = By.name("optinMessage");
	By optoutMessage = By.name("optoutMessage");
	By samp1 = By.xpath("//input[@placeholder='Enter Sample Message 1']");
	By samp2 = By.xpath("//input[@placeholder='Enter Sample Message 2']");
	By samp3 = By.xpath("//input[@placeholder='Enter Sample Message 3']");
	By finishBtn = By.xpath("//button//span[text()=\"Finish\"]");
	By submitBtn = By.xpath("//button//span[text()=\"Submit\"]");
	By viewCampDetail = By.xpath("//a//strong[text()=\"View Campaign Details\"]");
	// By backToList = By.xpath("//span[normalize-space()='BACK TO 10DLC CAMPAIGN
	// LIST']");
	By TcrCampaignID = By.xpath(
			"(//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-md-3 MuiGrid-grid-lg-3\"])[1]");

	public void createCampaignWithBillingON(String accountName, boolean billing) {

		click_custom(createCampaignOption, "createCampaignOption");
		click_custom(srcAccountName, "srcAccountName");
		if (accountName.equals("Sinch")) {
			sendKeys_custom(srcAccountName, "srcAccountName", accountName);
			click_custom(selectAccount1, "selectAccount1");
			sleepTime_custom(500);
			click_custom(clickOnProjectId, "clickOnProjectId");
			click_custom(selectProjectId1, "selectProjectId");
			sleepTime_custom(500);
			click_custom(nextBtn, "nextBtn");
			click_custom(srcBrand, "srcBrand");
			scrollIntoView_custom(selectBrandOption2, "selectBrandOption");
			click_custom(selectBrandOption2, "selectBrandOption");
		} else {
			sendKeys_custom(srcAccountName, "srcAccountName", accountName);
			click_custom(selectAccount, "selectAccount");
			sleepTime_custom(500);
			click_custom(clickOnProjectId, "clickOnProjectId");
			click_custom(selectProjectId, "selectProjectId");
			sleepTime_custom(500);
			click_custom(nextBtn, "nextBtn");
			click_custom(srcBrand, "srcBrand");
			scrollIntoView_custom(selectBrandOption, "selectBrandOption");
			click_custom(selectBrandOption, "selectBrandOption");
		}
		click_custom(nextBtn, "nextBtn");
		click_custom(srcUsecase, "srcUsecase");
		click_custom(selectUsecaseOption, "selectUsecaseOption");
		sleepTime_custom(500);
		click_custom(chkQualifyBtn, "chkQualifyBtn");
		sleepTime_custom(2000);
		scrollIntoView_custom(next, "next");
		click_custom(nextBtn, "nextBtn");
		sendKeys_custom(campaignName, "campaignName", getCampaignName());
		sendKeys_custom(campaignDesc, "campaignDesc", "Creating Campaign through UI Automation by Priye");
		click_custom(srcVertical, "srcVertical");
		click_custom(selectVerticalOption, "selectVerticalOption");
		if (billing == false)
			click_custom(disableTCR, "disableTCR");
		sendKeys_custom(callToAction, "helpMsg", "Confirming whether m able to do or not by automation");
		sendKeys_custom(helpMsg, "helpMsg", "Automation is an art");
		sendKeys_custom(optInKeywords, "optInKeywords", "Using optin keywords");
		sendKeys_custom(optInMessage, "optInMessage", "OPT-IN-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(optoutMessage, "optoutMessage", "OPT-OUT-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(samp1, "samp1", "1-SAMPLE-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(samp2, "samp2", "2-SAMPLE-MESSAGE-WITH-LIMIT-20-WORDS");
		click_custom(finishBtn, "nextBtn");
		click_custom(submitBtn, "submitBtn");
	}

	public String createCampaignAndValidate(String accountName, boolean billing) throws Throwable {

		click_custom(createCampaignOption, "createCampaignOption");
		click_custom(srcAccountName, "srcAccountName");
		if (accountName.equals("Sinch")) {
			sendKeys_custom(srcAccountName, "srcAccountName", accountName);
			click_custom(selectAccount1, "selectAccount1");
			sleepTime_custom(500);
			click_custom(clickOnProjectId, "clickOnProjectId");
			click_custom(selectProjectId1, "selectProjectId");
			sleepTime_custom(500);
			click_custom(nextBtn, "nextBtn");
			click_custom(srcBrand, "srcBrand");
			scrollIntoView_custom(selectBrandOption2, "selectBrandOption");
			click_custom(selectBrandOption2, "selectBrandOption");
		} else {
			sendKeys_custom(srcAccountName, "srcAccountName", accountName);
			click_custom(selectAccount, "selectAccount");
			sleepTime_custom(500);
			click_custom(clickOnProjectId, "clickOnProjectId");
			click_custom(selectProjectId, "selectProjectId");
			sleepTime_custom(500);
			click_custom(nextBtn, "nextBtn");
			click_custom(srcBrand, "srcBrand");
			scrollIntoView_custom(selectBrandOption, "selectBrandOption");
			click_custom(selectBrandOption, "selectBrandOption");
		}
		click_custom(nextBtn, "nextBtn");
		click_custom(srcUsecase, "srcUsecase");
		click_custom(selectUsecaseOption, "selectUsecaseOption");
		sleepTime_custom(500);
		click_custom(chkQualifyBtn, "chkQualifyBtn");
		sleepTime_custom(2000);
		scrollIntoView_custom(next, "next");
		click_custom(nextBtn, "nextBtn");
		sendKeys_custom(campaignName, "campaignName", getCampaignName());
		sendKeys_custom(campaignDesc, "campaignDesc", "Creating Campaign through UI Automation by Priye");
		click_custom(srcVertical, "srcVertical");
		click_custom(selectVerticalOption, "selectVerticalOption");
		// click_custom(disableTMO, "disableTMO");
		// click_custom(enableNumberPool, "enableNumberPool");
		if (billing == false)
			click_custom(disableTCR, "disableTCR");
		// sendKeys_custom(msgFlow, "msgFlow", "This is done through automation test
		// scripts");
		sendKeys_custom(callToAction, "helpMsg", "Confirming whether m able to do or not by automation");
		sendKeys_custom(helpMsg, "helpMsg", "Automation is an art");
		sendKeys_custom(optInKeywords, "optInKeywords", "Using optin keywords");
		sendKeys_custom(optInMessage, "optInMessage", "OPT-IN-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(optoutMessage, "optoutMessage", "OPT-OUT-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(samp1, "samp1", "1-SAMPLE-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(samp2, "samp2", "2-SAMPLE-MESSAGE-WITH-LIMIT-20-WORDS");
		// sendKeys_custom(samp3, "samp3", "sms team is genius");
		click_custom(finishBtn, "nextBtn");
		click_custom(submitBtn, "submitBtn");
		click_custom(viewCampDetail, "viewCampDetail");
		sleepTime_custom(2000);
		refresh_page_custom("Refreshing the page to get updated data");
		sleepTime_custom(2000);
		// click_custom(backToList, "backToList");
		String actualTcrCampaignID = getElement(TcrCampaignID).getText();
		System.out.println(actualTcrCampaignID);
		// assertEquals(TcrCampaignID, billing);
		assertEqualsBoolean_custom(actualTcrCampaignID.startsWith("C"), true, actualTcrCampaignID);
		return actualTcrCampaignID;
	}

	public void createCampaign(String accountName) {

		click_custom(createCampaignOption, "createCampaignOption");
		click_custom(srcAccountName, "srcAccountName");
		if (accountName.equals("Sinch")) {
			sendKeys_custom(srcAccountName, "srcAccountName", accountName);
			click_custom(selectAccount1, "selectAccount1");
			sleepTime_custom(500);
			click_custom(clickOnProjectId, "clickOnProjectId");
			click_custom(selectProjectId1, "selectProjectId");
			sleepTime_custom(500);
			click_custom(nextBtn, "nextBtn");
			click_custom(srcBrand, "srcBrand");
			scrollIntoView_custom(selectBrandOption2, "selectBrandOption");
			click_custom(selectBrandOption2, "selectBrandOption");
		} else {
			sendKeys_custom(srcAccountName, "srcAccountName", accountName);
			click_custom(selectAccount, "selectAccount");
			sleepTime_custom(500);
			click_custom(clickOnProjectId, "clickOnProjectId");
			click_custom(selectProjectId, "selectProjectId");
			sleepTime_custom(500);
			click_custom(nextBtn, "nextBtn");
			click_custom(srcBrand, "srcBrand");
			scrollIntoView_custom(selectBrandOption, "selectBrandOption");
			click_custom(selectBrandOption, "selectBrandOption");
		}

		click_custom(nextBtn, "nextBtn");
		click_custom(srcUsecase, "srcUsecase");
		click_custom(selectUsecaseOption, "selectUsecaseOption");
		sleepTime_custom(500);
		click_custom(chkQualifyBtn, "chkQualifyBtn");
		sleepTime_custom(2000);
		scrollIntoView_custom(next, "next");
		click_custom(nextBtn, "nextBtn");
		sendKeys_custom(campaignName, "campaignName", getCampaignName());
		sendKeys_custom(campaignDesc, "campaignDesc", "Creating Campaign through UI Automation by Priye");
		click_custom(srcVertical, "srcVertical");
		click_custom(selectVerticalOption, "selectVerticalOption");
		click_custom(disableTCR, "disableTCR");
		sendKeys_custom(callToAction, "helpMsg", "Confirming whether m able to do or not by automation");
		sendKeys_custom(helpMsg, "helpMsg", "Automation is an art");
		sendKeys_custom(optInKeywords, "optInKeywords", "Using optin keywords");
		sendKeys_custom(optInMessage, "optInMessage", "OPT-IN-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(optoutMessage, "optoutMessage", "OPT-OUT-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(samp1, "samp1", "1-SAMPLE-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(samp2, "samp2", "2-SAMPLE-MESSAGE-WITH-LIMIT-20-WORDS");
		click_custom(finishBtn, "nextBtn");
		click_custom(submitBtn, "submitBtn");
	}

	public void createCampaignWithMockBrand(String accountName, boolean mock) {

		if (mock == false)
			return;

		click_custom(createCampaignOption, "createCampaignOption");
		click_custom(srcAccountName, "srcAccountName");
		sendKeys_custom(srcAccountName, "srcAccountName", accountName);
		click_custom(selectAccount, "selectAccount");
		sleepTime_custom(500);
		click_custom(clickOnProjectId, "clickOnProjectId");
		click_custom(selectProjectId, "selectProjectId");
		sleepTime_custom(500);
		click_custom(nextBtn, "nextBtn");
		click_custom(srcBrand, "srcBrand");
		scrollIntoView_custom(selectBrandOption3, "selectBrandOption3");
		click_custom(selectBrandOption3, "selectBrandOption3");
		click_custom(nextBtn, "nextBtn");
		click_custom(srcUsecase, "srcUsecase");
		click_custom(selectUsecaseOption, "selectUsecaseOption");
		sleepTime_custom(500);
		click_custom(chkQualifyBtn, "chkQualifyBtn");
		sleepTime_custom(2000);
		scrollIntoView_custom(next, "next");
		click_custom(nextBtn, "nextBtn");
		sendKeys_custom(campaignName, "campaignName", getCampaignName());
		sendKeys_custom(campaignDesc, "campaignDesc", "Creating Campaign through UI Automation by Priye");
		click_custom(srcVertical, "srcVertical");
		click_custom(selectVerticalOption, "selectVerticalOption");
		click_custom(disableTCR, "disableTCR");
		sendKeys_custom(callToAction, "helpMsg", "Confirming whether m able to do or not by automation");
		sendKeys_custom(helpMsg, "helpMsg", "Automation is an art");
		sendKeys_custom(optInKeywords, "optInKeywords", "Using optin keywords");
		sendKeys_custom(optInMessage, "optInMessage", "OPT-IN-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(optoutMessage, "optoutMessage", "OPT-OUT-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(samp1, "samp1", "1-SAMPLE-MESSAGE-WITH-LIMIT-20-WORDS");
		sendKeys_custom(samp2, "samp2", "2-SAMPLE-MESSAGE-WITH-LIMIT-20-WORDS");
		click_custom(finishBtn, "nextBtn");
		click_custom(submitBtn, "submitBtn");
	}
}
