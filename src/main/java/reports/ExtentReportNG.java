package reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reusableComponents.PropertiesOperations;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */
public class ExtentReportNG {

	static ExtentReports extent;
	public static String reportPath;

	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_" + actualDate + ".html";

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		sparkReport.config().setDocumentTitle("10DLC");
		sparkReport.config().setTheme(Theme.DARK);
		// sparkReport.config().setReportName("Priya Ranjan");
		sparkReport.loadXMLConfig(System.getProperty("user.dir") + "//ReportConfig.xml");

		extent.setSystemInfo("Executed on Environment: ", PropertiesOperations.getPropertyValueByKey("staging.url1"));
		//extent.setSystemInfo("Executed on Environment: ", PropertiesOperations.getPropertyValueByKey("production.url"));
		extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
		extent.setSystemInfo("project", "10DLC");

		return extent;
	}

}
