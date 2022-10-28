package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilies.Logs;

public class ITListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Logs.info("On Test Start...!!!" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Logs.info("On Test Success....!!!!" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		Logs.info("On Test Failure....!!!!" + result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Logs.info("Test Cases Skipped....!!!!!" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		Logs.info("Test on Start.....!!!!!" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		Logs.info("On Test Case Finished....!!!!" + context.getName());
	}

}
