package Common_Methods;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	ExtentSparkReporter sparkReporter;
	ExtentReports extentReport;
	ExtentTest test;

	public void reportConfigurations() {
		sparkReporter = new ExtentSparkReporter(".\\extent-report\\report.html");
		extentReport = new ExtentReports();

		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("OS", "Windows 11");
		extentReport.setSystemInfo("user", "e2e2");
		sparkReporter.config().setDocumentTitle("Restassured_listener_report");
		sparkReporter.config().setReportName("extentreport01");
		sparkReporter.config().setTheme(Theme.DARK);
	}

	public void onStart(ITestContext result) {
		reportConfigurations();
		System.out.println("On Start method invoked....");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed...." + result.getName());
		test = extentReport.createTest(result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("name of the failed test case is :" + result.getName(), ExtentColor.RED));

	}

	public void onTestSkipped(ITestContext result) {
		System.out.println("Name of test method skipped...." + result.getName());
		test = extentReport.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("name of the skipped test case is :" + result.getName(), ExtentColor.YELLOW));

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started...." + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("name of the test method executed successfully..." + result.getName());
		test = extentReport.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("name of the PASSED test case is :" + result.getName(), ExtentColor.GREEN));

	}

	public void onFinish(ITestContext result) {
		System.out.println("On finished method invoked....");
		extentReport.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Implementation details not shown in the snippet
	}
}
