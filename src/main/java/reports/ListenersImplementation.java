package reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testBase.DriverFactory;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class ListenersImplementation implements ITestListener {
	
	static ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// before each test case
		test = report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(test);
	}

	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.PASS,
				"Test Case: " + result.getMethod().getMethodName() + " is Passed.");
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailure(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,
				"Test Case: " + result.getMethod().getMethodName() + " is Failed.");
//		ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
		
		// add screenshot for failed test.
		File src = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/" + actualDate + ".jpeg";
		File dest = new File(screenshotPath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath,
					"Test case failure screenshot");
			ExtentFactory.getInstance().removeExtentObject();

		} catch (IOException e) {
			e.printStackTrace();
		}
		// JIRA defect creation part
//		String automaticJIRAcreation = null;
//		try {
//			automaticJIRAcreation = PropertiesOperations.getPropertyValueByKey("automatic_Issue_Creation_In_JIRA");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (automaticJIRAcreation.trim().equalsIgnoreCase("ON")) {
//			String issueS = "Automation Test Failed - " + result.getMethod().getMethodName();
//			String issueD = "Test Data to be passed here.";
//			String issueNumber = null;
//			try {
//				issueNumber = jiraOps.createJiraIssue("10DLC Campaign Management (DCM)", issueS, issueD, "None",
//						"Medium - Should", "Q3_2022", "Staging", "Priya.Ranjan@Sinch.Com");
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}

//		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
//		boolean isTicketReady = jiraPolicy.logTicketReady();
//		if (isTicketReady) {
//			// raise jira ticket:
//			System.out.println("is ticket ready for JIRA: " + isTicketReady);
//			JiraServiceProvider jiraSp = new JiraServiceProvider("https://tickets.sinch.com", "Priya.Ranjan@Sinch.Com",
//					"MTYyMjQxMzM4NTcxOvjBxSjiS9XZiyfZRzyycjauR5Uc", "10DLC Campaign Management (DCM)");
//			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()
//					+ "got failed due to some assertion or exception";
//			String issueDescription = result.getThrowable().getMessage() + "\n";
//			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
//
//			jiraSp.createJiraTicket("Bug", issueSummary, issueDescription, "Priya Ranjan");
//		}

	}

	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.SKIP,
				"Test Case: " + result.getMethod().getMethodName() + " is skipped.");
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		try {
			report = ExtentReportNG.setupExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		// close extent
		report.flush();
	}

}
