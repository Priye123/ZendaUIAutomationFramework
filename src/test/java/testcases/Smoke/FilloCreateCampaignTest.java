package testcases.Smoke;

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.CreateCampaignPage;
import pages.LoginAndDashboardPage2;
import reports.ExtentFactory;
import reports.ListenersImplementation;
import reusableComponents.FilloOperations;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

//@Listeners(ListenersImplementation.class)
public class FilloCreateCampaignTest extends TestBase {

	ActivateCampaignPage2 activateCampaignPage = new ActivateCampaignPage2();
	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();
	CreateCampaignPage createCampaignPage = new CreateCampaignPage();
	FilloOperations fillo = new FilloOperations();

	// this testcase is used to check create campaign flow
	@Test(description = "It is used to check create campaign flow", priority = 1, enabled = false)
	public void TC1() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("1", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));
//		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("production.username"),
//				PropertiesOperations.getPropertyValueByKey("production.password"));

		// createCampaignPage.createCampaign(testData.get("ACCOUNTNAME"));
	}

	// this testcase is used to create campaign with Sinch Account
	@Test(description = "It is used to create campaign flow with Sinch Account", priority = 2)
	public void TC2() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("2", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		createCampaignPage.createCampaign(testData.get("ACCOUNTNAME"));
	}

	// this testcase is used to create campaign with Mariusz_Staging Account
	// Account
	@Test(description = "It is used to create campaign flow with Mariusz_Staging Account", priority = 3, enabled = false)
	public void TC3() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("3", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		createCampaignPage.createCampaign(testData.get("ACCOUNTNAME"));
	}

	// this testcase is used to create campaign with mock brand
	@Test(description = "It is used to create campaign with mock brand", priority = 4, enabled = false)
	public void TC4() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("4", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		createCampaignPage.createCampaignWithMockBrand(testData.get("ACCOUNTNAME"),
				Boolean.parseBoolean(testData.get("MOCKBRAND")));
	}

	// this testcase is used to create campaign with billing ON
	@Test(description = "It is used to create campaign with billing ON", priority = 5, enabled = false)
	public void TC5() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("5", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		createCampaignPage.createCampaignWithBillingON(testData.get("ACCOUNTNAME"),
				Boolean.parseBoolean(testData.get("ENABLETCRBILLING")));
	}

	// this testcase is used to create campaign with NNID
	@Test(description = "It is used to create campaign with NNID", priority = 6, enabled = false)
	public void TC6() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("6", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		// createCampaignPage.createCampaign(testData.get("ACCOUNTNAME"),
		// Boolean.parseBoolean(testData.get("NNID")));
	}

	// this testcase is used to create campaign with billing ON with Sinch Account
	@Test(description = "It is used to create campaign with billing ON", priority = 5)
	public void TC7() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("7", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		createCampaignPage.createCampaignWithBillingON(testData.get("ACCOUNTNAME"),
				Boolean.parseBoolean(testData.get("ENABLETCRBILLING")));
	}

}
