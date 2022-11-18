package testcases.DatabaseValidation;

import java.util.HashMap;

import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.CreateCampaignPage;
import pages.LoginAndDashboardPage2;
import reports.ExtentFactory;
import reusableComponents.DB_Operations;
import reusableComponents.FilloOperations;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

public class DBValidationTest extends TestBase {

	ActivateCampaignPage2 activateCampaignPage = new ActivateCampaignPage2();
	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();
	CreateCampaignPage createCampaignPage = new CreateCampaignPage();
	FilloOperations fillo = new FilloOperations();
	DB_Operations dbOps = new DB_Operations();

	// this testcase is used to number provision on UI and verify whether that
	// number is inserted in database or not using campaign_number table
	@Test(enabled = false)
	public void TC1() throws Throwable {

		HashMap<String, String> testData = fillo.getTestData("9", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"),
				Boolean.parseBoolean(testData.get("NUMBERPOOLCAMPAIGN")), testData.get("ACCOUNTID"), "12436944799");

		// verify DB
		String sql = "SELECT * FROM `campaign_number` WHERE number='+12436944799' and campaign_id=1919";
		HashMap<String, String> dbData = dbOps.getSqlResultInMap(sql);
		String actualNumber = dbData.get("number");
		assertEqualsString_custom("+12436944799", actualNumber, "DB_Number");
	}

	// this testcase is used to create campaign on UI and verify whether that
	// campaign is inserted in database or not using campaign table
	@Test(enabled = false)
	public void TC2() throws Throwable {

		HashMap<String, String> testData = fillo.getTestData("1", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		String actualTcrCampaignID = createCampaignPage.createCampaignAndValidate(testData.get("ACCOUNTNAME"), false);

		// verify DB
		String sql = "SELECT * FROM `campaign` WHERE tcr_campaign_id='" + actualTcrCampaignID + "'";
		HashMap<String, String> dbData = dbOps.getSqlResultInMap(sql);
		assertEqualsBoolean_custom(dbData.get("tcr_campaign_id").startsWith("C"), true, actualTcrCampaignID);
	}

	// this testcase is used to create campaign on UI and verify whether it
	// is present in event table with status as TCR_CAMPAIGN_APPROVED
	@Test(enabled = true)
	public void TC3() throws Throwable {

		HashMap<String, String> testData = fillo.getTestData("1", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		String actualTcrCampaignID = createCampaignPage.createCampaignAndValidate(testData.get("ACCOUNTNAME"), false);

		// verify DB
		String sql = "SELECT * FROM `event` WHERE  type='TCR_CAMPAIGN_APPROVED' and tcr_campaign_id='"
				+ actualTcrCampaignID + "'";
		HashMap<String, String> dbData = dbOps.getSqlResultInMap(sql);
		assertEqualsBoolean_custom(dbData.get("tcr_campaign_id").startsWith("C"), true, actualTcrCampaignID);
	}
}
