package testBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class BrowserFactory {

	// create webdriver object for given browser
	public WebDriver createBrowserInstance(String browser) throws MalformedURLException {

		WebDriver driver = null;
		// RemoteWebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.silentOutput", "true");

			ChromeOptions options = new ChromeOptions();
			// options.addArguments("--incognito");
			options.setBinary("/usr/bin/google-chrome"); // chrome binary location
			options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("-private");

			// driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"),
			// DesiredCapabilities.firefox());

			driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), foptions);
			// driver = new FirefoxDriver(foptions);

		} else if (browser.equalsIgnoreCase("ie")) {

			WebDriverManager.iedriver().setup();
			InternetExplorerOptions iOptions = new InternetExplorerOptions();
			iOptions.addCommandSwitches("-private");

			driver = new InternetExplorerDriver(iOptions);

		} else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("htmlunit")) {
			// HtmlUnitDriver – Non GUI Browser in Selenium
			driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);

		} else if (browser.equalsIgnoreCase("ChromeHeadless")) {

			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");

			// set chrome as Headless
			options.setHeadless(true);

			driver = new ChromeDriver(options);

		}
		return driver;
	}

}
