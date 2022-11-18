package testcases.Smoke;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import jira_integration.JiraPolicy;
import pages.LoginAndDashboardPage2;
import reports.ListenersImplementation;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

//@Listeners(ListenersImplementation.class)
public class LoginDashboardTest extends TestBase {

	LoginAndDashboardPage2 loginAndDashboardPage = new LoginAndDashboardPage2();

	@JiraPolicy(logTicketReady = false)

	// wrong username with wrong password
	@Test(description = "wrong username with wrong password", priority = 1, enabled = false)
	public void TC1() throws Exception {
		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.wrongusername"),
				PropertiesOperations.getPropertyValueByKey("staging.wrongpassword"));
	}

	// wrong username with right password
	@Test(description = "wrong username with right password", priority = 2, enabled = false)
	public void TC2() throws Exception {
		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.wrongusername"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));
	}

	// right username with wrong password
	@Test(description = "right username with wrong password", priority = 3, enabled = false)
	public void TC3() throws Exception {
		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.wrongpassword"));
	}

	// right username with right password
	@Test(description = "right username with right password", priority = 4, enabled = false)
	public void TC4() throws Exception {
		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"),
				PropertiesOperations.getPropertyValueByKey("staging.password"));
	}

	// blank username with wrong password
	@Test(description = "blank username with wrong password", priority = 5, enabled = false)
	public void TC5() throws Exception {
		loginAndDashboardPage.login(" ", PropertiesOperations.getPropertyValueByKey("staging.wrongpassword"));
	}

	// blank username with right password
	@Test(description = "blank username with right password", priority = 6, enabled = false)
	public void TC6() throws Exception {
		loginAndDashboardPage.login(" ", PropertiesOperations.getPropertyValueByKey("staging.password"));
	}

	// wrong username with blank password
	@Test(description = "wrong username with blank password", priority = 7, enabled = false)
	public void TC7() throws Exception {
		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.wrongusername"), " ");
	}

	// right username with blank password
	@Test(description = "right username with blank password", priority = 8, enabled = false)
	public void TC8() throws Exception {
		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.username"), " ");
	}

	// blank username with blank password
	@Test(description = "blank username with blank password", priority = 9, enabled = false)
	public void TC9() throws Exception {
		loginAndDashboardPage.login(" ", " ");
	}

	// capital username with capital password
	@Test(description = "capital username with capital password", priority = 10, enabled = false)
	public void TC10() throws Exception {
		loginAndDashboardPage.login(PropertiesOperations.getPropertyValueByKey("staging.capitalusername"),
				PropertiesOperations.getPropertyValueByKey("staging.capitalpassword"));
	}

}
