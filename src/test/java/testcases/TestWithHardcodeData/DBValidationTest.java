package testcases.TestWithHardcodeData;

import java.util.HashMap;

import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.CreateCampaignPage;
import pages.LoginAndDashboardPage2;
import reusableComponents.DB_Operations;
import reusableComponents.FilloOperations;
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
		loginAndDashboardPage.login("testing_10dlc", "fWVkHEOvTAij6K8APlJq");
		activateCampaignPage.submitActivateCampaignRequest("CUMPOXQ", "12436955799", "Mariusz_Staging");

		// verify DB
		String sql = "SELECT * FROM `campaign_number` WHERE number='+12436955799' and campaign_id=2109";
		HashMap<String, String> dbData = dbOps.getSqlResultInMap(sql);
		String actualNumber = dbData.get("number");
		assertEqualsString_custom("+12436955798", actualNumber, "DB_Number");
	}
}
