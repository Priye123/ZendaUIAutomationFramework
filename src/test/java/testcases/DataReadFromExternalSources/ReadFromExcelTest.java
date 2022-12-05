package testcases.DataReadFromExternalSources;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ActivateCampaignPage2;
import pages.LoginAndDashboardPage;
import reports.ExtentFactory;
import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class ReadFromExcelTest extends TestBase {

	ActivateCampaignPage2 activateCampaignPage = new ActivateCampaignPage2();
	LoginAndDashboardPage loginAndDashboardPage = new LoginAndDashboardPage();
	ExcelOperations excel = new ExcelOperations("TaskCreationData");

	@Test(dataProvider = "taskCreationData")
	public void TC1(Object obj1) throws Throwable {

		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		loginAndDashboardPage.login(testData.get("UserName"), testData.get("Password"));

		activateCampaignPage.submitActivateCampaignRequest(testData.get("Campaign ID"), testData.get("Number"),
				testData.get("Account ID"));
	}

	// Dataprovider method --> return object array
	@DataProvider(name = "taskCreationData")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][2];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

	}

}
