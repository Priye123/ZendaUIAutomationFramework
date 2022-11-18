package testcases.TestWithHardcodeData;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.CreateCampaignPage;
import pages.LoginAndDashboardPage;
import testBase.DriverFactory;
import testBase.TestBase;

public class CreateCampaignTest extends TestBase {

	ActivateCampaignPage2 activateCampaignPage = new ActivateCampaignPage2();
	LoginAndDashboardPage loginAndDashboardPage = new LoginAndDashboardPage();
	CreateCampaignPage createCampaignPage = new CreateCampaignPage();

	// this testcase is used to check create campaign flow
	@Test(enabled = false)
	public void TC1() throws Exception {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		createCampaignPage.createCampaign("Mariusz_Staging");
	}

	// this testcase is used to create campaign with billing ON
	@Test(enabled = false)
	public void TC2() throws Throwable {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		createCampaignPage.createCampaignWithBillingON("Mariusz_Staging", true);
	}

	@Test(enabled = false)
	public void TC3() throws Throwable {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		String actualTcrCampaignID = createCampaignPage.createCampaignAndValidate("Mariusz_Staging", false);
		activateCampaignPage.submitActivateCampaignRequest(actualTcrCampaignID, "12436945208", "Mariusz_Staging");
		Thread.sleep(80000);// sleep of 1 min 33 secs
		refresh_page_custom("Refresh");
		if (DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//span[@title=\"DCA Provisioning finished\"]//span[text()=\"Active\"]"))
				.getText().equalsIgnoreCase("Active")) {
			System.out.println("The flow is working perfectly..TestCase Passed");
		}

	}

	@Test(enabled = false)
	public void TC4() throws Throwable {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		String actualTcrCampaignID = createCampaignPage.createCampaignAndValidate("Sinch", false);
		activateCampaignPage.submitActivateCampaignRequest(actualTcrCampaignID, "12436945208", "Sinch");
		Thread.sleep(80000);// sleep of 1 min 33 secs
		refresh_page_custom("Refresh");
		if (DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//span[@title=\"DCA Provisioning finished\"]//span[text()=\"Active\"]"))
				.getText().equalsIgnoreCase("Active")) {
			System.out.println("The flow is working perfectly..TestCase Passed");
		}
	}

}
