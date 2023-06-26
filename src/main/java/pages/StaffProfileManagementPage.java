package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import reusableComponents.ActionEngine;
import testBase.TestBase;

public class StaffProfileManagementPage extends ActionEngine {

	By staffLink = By.xpath("//span[text()='Staff Profile Management ']");
	By staffAdd = By.xpath("//a[@href='addStaff']");
	By staffFullName = By.id("staffFullName");
	By dob = By.id("dob");
	By date = By.xpath("//a[text()='2']");
	By dobddown = By.xpath("//select[@data-handler=\"selectYear\"]");
	By joinDate = By.id("joinDate");
	By staffEmail = By.name("staffEmail");
	By salaryStartDate = By.id("salaryStartDate");
	By submitButton = By.xpath("//button[@id='submitButton']");

	public void addStaff() throws Throwable {
		click_custom(staffLink, "staffLink");
		click_custom(staffAdd, "staffAdd");
		sendKeys_custom(staffFullName, "staffFullName", "Priye Ranjan");
		click_custom(dob, "dob");
		selectDropDownByVisibleText_custom(dobddown, "dobddown", "1997");
		click_custom(date, "date");
		click_custom(joinDate, "joinDate");
		click_custom(date, "date");
		sendKeys_custom(staffEmail, "staffEmail", "priyerock" + getRandomAlphaNumeric() + "@gmail.com");
		click_custom(salaryStartDate, "salaryStartDate");
		click_custom(date, "date");
		click_custom(submitButton, "submitButton");
	}

	public void addStaff(HashMap<String, String> testData) throws Throwable {
		click_custom(staffLink, "staffLink");
		click_custom(staffAdd, "staffAdd");
		sendKeys_custom(staffFullName, "staffFullName", testData.get(testData.get("FULLNAME")));
		click_custom(dob, "dob");
		selectDropDownByVisibleText_custom(dobddown, "dobddown", testData.get("DOB"));
		click_custom(date, "date");
		click_custom(joinDate, "joinDate");
		click_custom(date, "date");
		sendKeys_custom(staffEmail, "staffEmail", "priyerock" + getRandomAlphaNumeric() + "@gmail.com");
		click_custom(salaryStartDate, "salaryStartDate");
		click_custom(date, "date");
		click_custom(submitButton, "submitButton");
	}
}
