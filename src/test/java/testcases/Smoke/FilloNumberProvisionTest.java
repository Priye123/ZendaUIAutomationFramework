package testcases.Smoke;

import java.util.HashMap;

import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.LoginAndDashboardPage2;
import reports.ExtentFactory;
import reusableComponents.FilloOperations;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

//@Listeners(ListenersImplementation.class)
public class FilloNumberProvisionTest extends TestBase {

	ActivateCampaignPage2 activateCampaignPage = new ActivateCampaignPage2();
	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();
	FilloOperations fillo = new FilloOperations();

	// this testcase is used to check provision flow
	@Test(description = "It is use to provision the number", priority = 1, enabled = false)
	public void TC1() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("1", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"), getPhoneNumber(),
				testData.get("ACCOUNTID"));
	}

	// testcase with migrate flow ON
	@Test(description = "Provision number with migrate flow ON", priority = 2, enabled = false)
	public void TC2() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("2", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"), getPhoneNumber(),
				testData.get("ACCOUNTID"), Boolean.parseBoolean(testData.get("MIGRATEFLAG")));
	}

	// next 3 testcases will provision number with PROCURED,IMPORTED & TEXT-ENABLED
	@Test(description = "Provision number with Number type 1(PROCURED)", priority = 3, enabled = false)
	public void TC3() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("3", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"), getPhoneNumber(),
				testData.get("NUMBERTYPE"), testData.get("ACCOUNTID"));
	}

	@Test(description = "Provision number with Number type 2(IMPORTED)", priority = 4, enabled = false)
	public void TC4() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("4", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"), getPhoneNumber(),
				testData.get("NUMBERTYPE"), testData.get("ACCOUNTID"));
	}

	@Test(description = "Provision number with Number type 3(TEXT-ENABLED)", priority = 5, enabled = false)
	public void TC5() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("5", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"), getPhoneNumber(),
				testData.get("NUMBERTYPE"), testData.get("ACCOUNTID"));
	}

	// this testcase will provision number with project-id
	@Test(description = "Provision number with project-id", priority = 6, enabled = false)
	public void TC6() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("6", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"), getPhoneNumber(),
				Boolean.parseBoolean(testData.get("PROJECTID")), testData.get("ACCOUNTID"));
	}

	// testcase for provision number with nnid to test PROCURED number validation
	@Test(description = "Provision number with nnid for PROCURED number", priority = 7, enabled = false)
	public void TC7() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("7", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"), getPhoneNumber(),
				testData.get("NUMBERTYPE"), testData.get("ACCOUNTID"), Boolean.parseBoolean(testData.get("NNID")));
	}

	// testcase for provision number with nnid to test TEXT-ENABLED number
	// validation
	@Test(description = "Provision number with nnid for TEXT-ENABLED number", priority = 8, enabled = false)
	public void TC8() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("8", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"), getPhoneNumber(),
				testData.get("NUMBERTYPE"), testData.get("ACCOUNTID"), Boolean.parseBoolean(testData.get("NNID")));
	}

	// testcase for provision number with number pool campaign
	@Test(description = "It is use to provision the number with number pool campaign", priority = 9, enabled = false)
	public void TC9() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("9", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"),
				Boolean.parseBoolean(testData.get("NUMBERPOOLCAMPAIGN")), testData.get("ACCOUNTID"), getPhoneNumber());
	}

	// this testcase is used to check provision flow with Sinch Account(campaign is
	// linked with Sinch account)
	@Test(description = "It is use to provision the number with Sinch Account", priority = 10, enabled = false)
	public void TC10() throws Exception {

		HashMap<String, String> testData = fillo.getTestData("10", "NumberProvisionData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("CAMPAIGNID"), getPhoneNumber(),
				testData.get("ACCOUNTID"));
	}
}
