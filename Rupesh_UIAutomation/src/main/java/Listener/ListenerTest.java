package Listener;

import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import driver.DriverFactory;
import extentReportpackage.ExtentManager;
import uitiles.log;

public class ListenerTest extends DriverFactory implements ITestListener {

	@Override
	public void onFinish(ITestContext iTestContext) {
		log.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
       //ExtentManager.extentReports.flush();
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", DriverFactory.driver);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("The name of the testcase failed is :" + iTestResult.getName());
		log.info("I am in Fail method " + iTestResult.getName());
        
		//log.info(getTestMethodName(iTestContext) + " test is failed.");
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        DriverFactory driverfactory=new DriverFactory();
        WebDriver driver = driverfactory.getDriver();
        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        //ExtentReports log and screenshot operations for failed tests.
       // getTest().log(Status.FAIL, "Test Failed",
          //  getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
		
	}

	// When Test case get Skipped, this method is called.
	@Override
	public void onTestSkipped(ITestResult iTestContext) {
		System.out.println("The name of the testcase Skipped is :" + iTestContext.getName());
	}

	// When Test case get Started, this method is called.
	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println(iTestResult.getName() + " test case started");
		//log.info(getTestMethodName(iTestResult) + " test is starting.");
	}

	// When Test case get passed, this method is called.
	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("The name of the testcase passed is :" + iTestResult.getName());
	}

}