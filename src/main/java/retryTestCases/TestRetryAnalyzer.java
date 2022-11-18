package retryTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author: Priya Ranjan
 * @Blog: https://medium.com/@priyerock
 */

public class TestRetryAnalyzer implements IRetryAnalyzer{

	int counter = 1;
	int retryMaxLimit = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retryMaxLimit) {
			counter++;
			return true;
		}
		return false;
	}

}

//@Override
//public boolean retry(ITestResult result) {
//	int counter = 1;
//	int retryMaxLimit = 0;
//	try {
//		retryMaxLimit = Integer.valueOf(PropertiesOperations.getPropertyValueByKey("retryCount"));
//	} catch (NumberFormatException e) {
//		e.printStackTrace();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	if (counter < retryMaxLimit) {
//		counter++;
//		return true;
//	}
//	return false;
//}
