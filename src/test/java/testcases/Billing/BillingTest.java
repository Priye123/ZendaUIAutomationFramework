package testcases.Billing;

import java.util.HashMap;

import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.CreateCampaignPage;
import pages.LoginAndDashboardPage2;
import reports.ExtentFactory;
import reusableComponents.FilloOperations;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

//@Listeners(ListenersImplementation.class)
public class BillingTest extends TestBase {

	ActivateCampaignPage2 activateCampaignPage = new ActivateCampaignPage2();
	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();
	CreateCampaignPage createCampaignPage = new CreateCampaignPage();
	FilloOperations fillo = new FilloOperations();

	// this testcase is used to create campaign with billing ON
	@Test(description = "It is used to create campaign with billing ON", priority = 5, enabled = false)
	public void TC1() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("5", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		createCampaignPage.createCampaignWithBillingON(testData.get("ACCOUNTNAME"),
				Boolean.parseBoolean(testData.get("ENABLETCRBILLING")));
	}

	// this testcase is used to create campaign with billing ON with Sinch Account
	@Test(description = "It is used to create campaign with billing ON", priority = 5, enabled = false)
	public void TC2() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("7", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		createCampaignPage.createCampaignWithBillingON(testData.get("ACCOUNTNAME"),
				Boolean.parseBoolean(testData.get("ENABLETCRBILLING")));
	}

}
