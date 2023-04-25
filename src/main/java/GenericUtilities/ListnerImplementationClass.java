package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	public void onFinish(ITestContext context) {

		System.out.println("-----Suite Execution is Finished------");
		report.flush();
	}

	public void onStart(ITestContext context) {

		System.out.println("-----Suite Execution is Started------");

		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new WebDriverUtility().getsystemDateFormat()+" .html");
		htmlReport.config().setDocumentTitle("Extent Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("HR1 Execution Report");

		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("System OS","Windows");
		report.setSystemInfo("Base URl", "https://demo.actitime.com/login.do");
		report.setSystemInfo("Author", "Gopi");
	}

	public void onTestFailure(ITestResult result) {
		WebDriverUtility wUtil=new WebDriverUtility();
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "Test script is Failed..!!!");
		test.log(Status.FAIL,result.getThrowable());
		String screenshotName = methodName+" "+wUtil.getsystemDateFormat();
		try {
			String path = wUtil.screenshot(Base_Utility.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, "Test Script is Skipped...!!!"+methodName);
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
	    test=report.createTest(methodName);
		test.log(Status.INFO,"Test Execution Started...!!!"+methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
	    test.log(Status.PASS, "Test Script Passed...!!!"+methodName);
	}
}
