package testBase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import reusableComponents.ActionEngine;
import reusableComponents.PropertiesOperations;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class TestBase extends ActionEngine {
	BrowserFactory bf = new BrowserFactory();

	@BeforeMethod
	public void LaunchApplication() throws Exception {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("staging.url1");
		// String url = PropertiesOperations.getPropertyValueByKey("production.url");

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));

		DriverFactory.getInstance().getDriver().manage().deleteAllCookies();
		DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().navigate().to(url);
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}

//	@AfterSuite
//	public void endSetup() throws AddressException, IOException, MessagingException {
//
//		Runtime r = Runtime.getRuntime();
//		r.addShutdownHook(new Thread() {
//
//			public void run() {
//				Mailing sm = new Mailing();
//				try {
//					sm.mail();
//					System.out.println("Report has been sent");
//				} catch (MessagingException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//
//			}
//		});
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
}
