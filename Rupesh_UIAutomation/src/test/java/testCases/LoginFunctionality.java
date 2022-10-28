package testCases;

import java.util.Properties;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import driver.DriverFactory;
import pages.LoginPage;
import propertyConfiguration.PropertyConfig;
import uitiles.log;

public class LoginFunctionality {

	Properties prop;
	DriverFactory driverfactory;
	PropertyConfig propertyconfig;
	LoginPage loginpage;
	ExtentTest extenttest;
	ExtentReports extentreport = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");

	@BeforeTest
	public void extentSetup() {
		extentreport.attachReporter(spark);
		extentreport.setSystemInfo("TesterName", "Rupesh");
	}

	@BeforeMethod
	public void setUp() {

		propertyconfig = new PropertyConfig();
		prop = propertyconfig.getProperty();

		System.out.println("Getting the properties file");

		String browserName = prop.getProperty("browser");
		String browserUrl = prop.getProperty("url");

		driverfactory = new DriverFactory();
		driverfactory.Intilization(browserName);
		driverfactory.getDriver().get(browserUrl);
	}

	@Test(priority = 0)
	public void LoginValidCredentails() throws Exception {

		extenttest = extentreport.createTest("Verify the Case with Vaild Credentails");

		// ExtentTestManager.startTest(method.getName(), "Verify the Case with Vaild
		// Credentails");
		log.info("opening the Vaild Cred");
		loginpage = new LoginPage();
		loginpage.loginCred(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(Integer.parseInt(prop.getProperty("waitTime")));
		loginpage.ClickLogOut();
	}

	@Test(priority = 1)
	public void LoginInvalidCredentails() throws InterruptedException {

		extenttest = extentreport.createTest("Verify the Case with In-Vaild Credentails");
		// ExtentTestManager.startTest(method.getName(), "Verify the Case with In-Vaild
		// Credentails");
		loginpage = new LoginPage();
		loginpage.loginCred(prop.getProperty("username"), prop.getProperty("InvalidPassword123"));
		Thread.sleep(Integer.parseInt(prop.getProperty("waitTime")));
	}

	@AfterMethod
	public void tearDown(ITestResult itResult) {
		if (itResult.getStatus() == ITestResult.FAILURE) {
			extenttest.log(Status.FAIL, "TestCase Failed" + itResult.getName()); // to add the name in extent report
			extenttest.log(Status.FAIL, "TestCase Failed" + itResult.getThrowable()); // to add error / Exception
		} else if (itResult.getStatus() == ITestResult.SKIP) {
			extenttest.log(Status.SKIP, "TestCase Skipped" + itResult.getName());
		} else if (itResult.getStatus() == ITestResult.SUCCESS) {
			extenttest.log(Status.PASS, "TestCase Passed" + itResult.getName());
		}

		driverfactory.getDriver().close();
	}

	@AfterTest
	public void endTestReport() {
		extentreport.flush();
	}

}
