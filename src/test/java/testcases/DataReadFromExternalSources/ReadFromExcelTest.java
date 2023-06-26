package testcases.DataReadFromExternalSources;

import java.util.HashMap;

import org.testng.annotations.Test;

import pages.FeeConfigurationPage;
import pages.LoginAndDashboardPage2;
import pages.StaffProfileManagementPage;
import reports.ExtentFactory;
import reusableComponents.FilloOperations;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

public class ReadFromExcelTest extends TestBase {

	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();
	FilloOperations fillo = new FilloOperations();
	StaffProfileManagementPage sp = new StaffProfileManagementPage();
	FeeConfigurationPage fc = new FeeConfigurationPage();

	@Test(description = "It is used to check whether staff is added or not", priority = 1,enabled = false)
	public void TC1() throws Throwable {

		HashMap<String, String> testData = fillo.getTestData("1", "StaffData");
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: " + testData);

		System.out.println(testData);
		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		sp.addStaff(testData);

	}

}
