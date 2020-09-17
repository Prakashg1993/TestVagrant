package listeners;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import container.extentReportUtil;

public class testListeners implements ITestListener{
	
	public static extentReportUtil extentReport;
	public void test() {
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extentReportUtil extentReport=new extentReportUtil();
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.extent.flush();
	}
	

}
