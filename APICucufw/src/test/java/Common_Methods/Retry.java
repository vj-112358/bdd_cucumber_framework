package Common_Methods;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int countstart = 0;
	private int max = 4;

	@Override
	public boolean retry(ITestResult result) {
		if (countstart < max) {
			String testcasename = result.getName();
			System.out.println("retrying"+testcasename+" "+countstart+" iteration");
			countstart ++;
			return true;
		}

		return false;
	}

}

