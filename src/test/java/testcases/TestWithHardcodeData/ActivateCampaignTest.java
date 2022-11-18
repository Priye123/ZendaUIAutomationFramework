package testcases.TestWithHardcodeData;

import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.CreateCampaignPage;
import pages.LoginAndDashboardPage2;
import testBase.TestBase;

public class ActivateCampaignTest extends TestBase {
	ActivateCampaignPage2 activateCampaignPage = new ActivateCampaignPage2();
	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();
	CreateCampaignPage createCampaignPage = new CreateCampaignPage();

	// this testcase is used to check provision flow
	@Test(description = "It is use to provision the number", enabled = false)
	public void TC2() {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		activateCampaignPage.submitActivateCampaignRequest("CB9AAYH", "12436944798", "Mariusz_Staging");

	}

	// testcase with migrate flow ON
	@Test(description = "Provision number with migrate flow ON", enabled = false)
	public void TC3() {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		activateCampaignPage.submitActivateCampaignRequest("CB9AAYH", "12436945760", "Mariusz_Staging", true);

	}

	// next 3 testcases will provision number with PROCURED,IMPORTED & TEXT-ENABLED
	@Test(description = "Provision number with Number type 1(PROCURED)", enabled = false)
	public void TC4Part1() {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		activateCampaignPage.submitActivateCampaignRequest("CB9AAYH", "12436945760", "PROCURED", "Mariusz_Staging");

	}

	@Test(description = "Provision number with Number type 2(IMPORTED)", enabled = false)
	public void TC4Part2() {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		activateCampaignPage.submitActivateCampaignRequest("CB9AAYH", "12436945761", "IMPORTED", "Mariusz_Staging");

	}

	@Test(description = "Provision number with Number type 3(TEXT-ENABLED)", enabled = false)
	public void TC4Part3() {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		activateCampaignPage.submitActivateCampaignRequest("CB9AAYH", "12436945762", "TEXT-ENABLED", "Mariusz_Staging");

	}

	// this testcase will provision number with project-id
	@Test(description = "Provision number with project-id", enabled = false)
	public void TC5() {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		activateCampaignPage.submitActivateCampaignRequest("CB9AAYH", "12436945762", true, "Mariusz_Staging");

	}

	// testcase for provision number with nnid to test PROCURED number validation
	@Test(description = "Provision number with nnid", enabled = false)
	public void TC6() {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		activateCampaignPage.submitActivateCampaignRequest("CB9AAYH", "12436945762", "PROCURED", "Mariusz_Staging",
				true);
	}

	// testcase for provision number with number pool campaign
	@Test(description = "It is use to provision the number with number pool campaign", enabled = false)
	public void TC7() {
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		activateCampaignPage.submitActivateCampaignRequest("C5VOBSQ", true, "12436944798", "Mariusz_Staging");

	}

}
