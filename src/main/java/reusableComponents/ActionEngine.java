package reusableComponents;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import reports.ExtentFactory;
import testBase.DriverFactory;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class ActionEngine {

	public void highLight_Element(By element) {
		WebElement ele = DriverFactory.getInstance().getDriver().findElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].style.border='3px solid green'", ele);
	}

	public void highLight_Element(WebElement element) {
		// WebElement ele =
		// DriverFactory.getInstance().getDriver().findElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].style.border='3px solid green'", element);
	}

	// custom click method to log every click action in to extent report
	public void click_custom(WebElement element, String fieldName) {
		try {
			// highLight_Element(element);
			element.click();
			// log success message in exgent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Clicked Successfully! ");
		} catch (Exception e) {
			// log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to click on field: " + fieldName + " due to exception: " + e);
		}
	}

	// Customized sendkeys method-> To log sendkeys message for every occ.
	public void sendKeys_custom(WebElement element, String fieldName, String valueToBeSent) {
		try {
			element.sendKeys(valueToBeSent);
			// log success message in exgent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Ented value as: " + valueToBeSent);
		} catch (Exception e) {
			// log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Value enter in field: " + fieldName + " is failed due to exception: " + e);
		}
	}

	// custom Scroll into view
	public void scrollIntoView_custom(By element, String fieldName) {
		try {
			WebElement ele = DriverFactory.getInstance().getDriver().findElement(element);
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Screen scrolled into view Successfully! ");
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to scrolled into view on field: " + fieldName + " due to exception: " + e);
		}
	}

	// Put some static sleep
	public void sleepTime_custom(long millis) {
		try {
			Thread.sleep(millis);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "==> wait for " + millis + " milliseconds");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Timeout due to exception: " + e);
			// Thread.sleep(millis);
		}
	}

	// Refresh the page
	public void refresh_page_custom(String message) {
		try {
			DriverFactory.getInstance().getDriver().navigate().refresh();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "==> " + message);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Refresh is not working due to exception: " + e);
		}
	}

	public void click_leftarrowIcon(WebElement element) {
		try {
			// WebElement ele =
			// DriverFactory.getInstance().getDriver().findElement(element);
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "==> Clicked on left arrow icon Successfully! ");
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to click on left arrow icon: due to exception: " + e);
		}
	}

	public void click_leftarrowIcon(By element) {
		try {
			WebElement ele = DriverFactory.getInstance().getDriver().findElement(element);
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", ele);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "==> Clicked on left arrow icon Successfully! ");
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to click on left arrow icon: due to exception: " + e);
		}
	}

	// String Asserts
	public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
		try {
			if (actualValue.equals(expvalue)) {
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field "
						+ locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
			} else {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field "
						+ locatorName + " Expected value was: " + expvalue + " actual value is: " + actualValue);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false, e.toString());
		}
	}

	public void fileUpload(String strFilepath) {
		try {
			sleepTime_custom(5500);
			// log.info("STEP : Asset File Path: "+filePath);
			StringSelection selection = new StringSelection(strFilepath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
			Robot rs = new Robot();
			rs.keyPress(KeyEvent.VK_CONTROL);
			rs.keyPress(KeyEvent.VK_V);
			rs.keyRelease(KeyEvent.VK_V);
			rs.keyRelease(KeyEvent.VK_CONTROL);
			rs.keyPress(KeyEvent.VK_ENTER);
			rs.keyRelease(KeyEvent.VK_ENTER);
			rs.keyRelease(KeyEvent.VK_ENTER);
			rs.delay(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// custom click method to log every click action in to extent report
	public void click_custom(By element, String fieldName) {
		try {
			getElement(element).click();
//			highLight_Element(element);
//			DriverFactory.getInstance().getDriver().findElement(element).click();
			// log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Clicked Successfully! ");
		} catch (Exception e) {
			// log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to click on field: " + fieldName + " due to exception: " + e);
			getElement(element).click();
		}

	}
	
	public void explicitWait(By element,String fieldName) {
		try {
			getElement(element);
			new WebDriverWait(DriverFactory.getInstance().getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element)).click();
//			highLight_Element(element);
//			DriverFactory.getInstance().getDriver().findElement(element).click();
			// log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Clicked Successfully! ");
		} catch (Exception e) {
			// log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to click on field: " + fieldName + " due to exception: " + e);
			getElement(element).click();
		}
	}

	// Select dropdown value value by visibleText
	public void selectDropDownByVisibleText_custom(By element, String fieldName, String ddVisibleText)
			throws Throwable {
		try {
			Select s = new Select(getElement(element));
			s.selectByVisibleText(ddVisibleText);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Dropdown Value Selected by visible text: " + ddVisibleText);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
		}
	}

	// Customized sendkeys method-> To log sendkeys message for every occ.
	public void sendKeys_custom(By element, String fieldName, String valueToBeSent) {
		try {
			if (valueToBeSent.equals("Keys.ENTER"))
				getElement(element).sendKeys(Keys.ENTER);
			else
				getElement(element).sendKeys(valueToBeSent);
//			highLight_Element(element);
//			DriverFactory.getInstance().getDriver().findElement(element).sendKeys(valueToBeSent);
			// log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Ented value as: " + valueToBeSent);
		} catch (Exception e) {
			// log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Value enter in field: " + fieldName + " is failed due to exception: " + e);
			getElement(element).sendKeys(valueToBeSent);
		}
	}

	// clear data from field
	public void clear_custom(WebElement element, String fieldName) {
		try {
			element.clear();
			Thread.sleep(250);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Data Cleared Successfully! ");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to clear Data on field: " + fieldName + " due to exception: " + e);
		}
	}

	// custom mouseHover
	public void moveToElement_custom(WebElement element, String fieldName) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());
			actions.moveToElement(element).build().perform();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Mouse hovered Successfully! ");
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Unable to hover mouse on field: " + fieldName + " due to exception: " + e);

		}
	}

	// check if element is Present
	public boolean isElementPresent_custom(WebElement element, String fieldName) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Presence of field is: " + flag);
			return flag;
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Checking for presence of field: " + fieldName + " not tested due to exception: " + e);
			return flag;
		}
	}

	// Select dropdown value value by value
	public void selectDropDownByValue_custom(WebElement element, String fieldName, String ddValue) throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByValue(ddValue);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Dropdown Value Selected by visible text: " + ddValue);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
		}
	}

	// Get text from webelement
	public String getText_custom(WebElement element, String fieldName) {
		String text = "";
		try {
			text = element.getText();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Text retried is: " + text);
			return text;
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					fieldName + "==> Text not retried due to exception: " + e);

		}
		return text;
	}

	public WebElement getElement(By element) {
		WebElement webElement = DriverFactory.getInstance().getDriver().findElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].style.border='3px solid green'", webElement);
		return webElement;
	}

	// Boolean Asserts
	public void assertEqualsBoolean_custom(boolean actualvalue, boolean expvalue, String actualTcrCampaignID)
			throws Throwable {
		try {
			if (actualvalue == expvalue) {
				ExtentFactory.getInstance().getExtent().log(Status.PASS,
						"boolean Assertion is successful and we get " + actualTcrCampaignID + " Expected value was: "
								+ expvalue + " actual value is: " + actualvalue);
			} else {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL,
						"boolean Assertion FAILED and we get " + actualTcrCampaignID + " Expected value was: "
								+ expvalue + " actual value is: " + actualvalue);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false, e.toString());
		}
	}

	// Random aplhanumeric values
	public String getRandomAlphaNumeric() {
		int length = 5;
		Random random = new SecureRandom();
		char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++) {
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(CHARSET_AZ_09.length);
			result[i] = CHARSET_AZ_09[randomCharIndex];
		}
		return new String(result);
	}
}
