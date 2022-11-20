package testcases.Regression;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.CreateCampaignPage;
import pages.LoginAndDashboardPage2;
import reports.ExtentFactory;
import reusableComponents.FilloOperations;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

//@Listeners(ListenersImplementation.class)

public class RegressionTestCases extends TestBase {

	ActivateCampaignPage2 activateCampaignPage = new ActivateCampaignPage2();
	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();
	CreateCampaignPage createCampaignPage = new CreateCampaignPage();
	FilloOperations fillo = new FilloOperations();

	// this testcase is used to check create campaign flow
	@Test(description = "It is used to check create campaign flow", priority = 1)
	public void TC1() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("4", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));
//		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("production.username"),
//				PropertiesOperations.getPropertyValueByKey("production.password"));

		createCampaignPage.createCampaignWithMockBrand(testData.get("ACCOUNTNAME"),
				Boolean.parseBoolean(testData.get("MOCKBRAND")));
	}

	// this testcase is used to check provision flow
	@Test(description = "It is use to provision the number", priority = 2)
	public void TC2() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("9", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"),
				Boolean.parseBoolean(testData.get("NUMBERPOOLCAMPAIGN")), testData.get("ACCOUNTID"), getPhoneNumber());
	}

	// campaign creation + number provision in same testcase
	@Test(description = "campaign creation + number provision in same testcase", priority = 3)
	public void TC3() throws Throwable {

		HashMap<String, String> testData = fillo.getTestData("1", "CreateCampaignData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		String actualTcrCampaignID = createCampaignPage.createCampaignAndValidate(testData.get("ACCOUNTNAME"), false);
		activateCampaignPage.submitActivateCampaignRequest(actualTcrCampaignID, getPhoneNumber(),
				testData.get("ACCOUNTNAME"));
//		Thread.sleep(80000);// sleep of 1 min 33 secs
//		refresh_page_custom("Refresh");
//		if (DriverFactory.getInstance().getDriver()
//				.findElement(By.xpath("//span[@title=\"DCA Provisioning finished\"]//span[text()=\"Active\"]"))
//				.getText().equalsIgnoreCase("Active")) {
//			System.out.println("The flow is working perfectly..TestCase Passed");
//		}
	}

}
