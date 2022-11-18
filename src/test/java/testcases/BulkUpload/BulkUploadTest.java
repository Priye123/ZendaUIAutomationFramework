package testcases.BulkUpload;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.LoginAndDashboardPage2;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

public class BulkUploadTest extends TestBase {

	ActivateCampaignPage2 activateCampaignPage = new ActivateCampaignPage2();
	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();
	By activateCampaignOption = By.xpath("//span[contains(text(),'Activate Campaign')]");
	By clickOnFile = By.xpath("//span[text()=\"CHOOSE FILE\"]");
	By clickOnConfirm = By.xpath("//span[text()=\"CONFIRM\"]");

	@Test
	public void TC1() throws Throwable {
		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		click_custom(activateCampaignOption, "activateCampaignOption");
		click_custom(clickOnFile, "clickonFile");
		String filepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testData" + File.separator
				+ "test_batchupload (2).csv";
		fileUpload(filepath);
		// fileUpload("C:\\Users\\priran\\eclipse-workspace\\Advance_10DLC_Admin_Portal_Automation_Framework\\src\\test\\resources\\testData\\test_batchupload
		// (2).csv");
		click_custom(clickOnConfirm, "clickOnConfirm");
	}

}
