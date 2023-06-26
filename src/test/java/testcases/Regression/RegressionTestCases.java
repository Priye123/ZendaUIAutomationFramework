package testcases.Regression;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.FeeConfigurationPage;
import pages.LoginAndDashboardPage2;
import pages.StaffProfileManagementPage;
import reports.ListenersImplementation;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

@Listeners(ListenersImplementation.class)

public class RegressionTestCases extends TestBase {

	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();
	StaffProfileManagementPage sp = new StaffProfileManagementPage();
	FeeConfigurationPage fc = new FeeConfigurationPage();

	// this testcase is used to add staff
	@Test(description = "It is used to check whether staff is added or not", priority = 1)
	public void TC1() throws Throwable {

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("username"),
				PropertiesOperations.getPropertyValueByKey("password"));

		sp.addStaff();

	}

	// this testcase is used to check payment has been completed successfully or not
	@Test(description = "It is used to check payment has been completed successfully or not", priority = 2)
	public void TC2() throws Throwable {

		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));

		fc.feeCollect();

	}

}
