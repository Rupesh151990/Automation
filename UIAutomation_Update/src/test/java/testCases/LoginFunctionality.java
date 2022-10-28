package testCases;

import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.*;
import factory.DriverFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.LoginPage;
import propertyConfiguration.PropertyConfig;
import utilies.Logs;

public class LoginFunctionality {

	DriverFactory driverfactory;
	LoginPage loginpage;
	PropertyConfig propertyconfig;
	Properties prop;
	public Logs log;

	@BeforeMethod
	public void browserSetup() {
		Logs.info("Reading the Property File and calling the browser Setup Function");
		propertyconfig = new PropertyConfig();
		prop = propertyconfig.getProperty();

		String browserName = prop.getProperty("browser");
		String browserUrl = prop.getProperty("url");

		driverfactory = new DriverFactory();
		driverfactory.DriverIntilization(browserName);
		driverfactory.getDriver().get(browserUrl);

	}

	@Test(priority = 0, description = "Verify the Login Functionality with Valid Credentails")
	@Severity(SeverityLevel.NORMAL)
	@Feature("Login Functionality")
	@Epic("EP001")
	@Story("ST01-Verify the login functionality")
	@Step("Login by entering userName and Password")

	public void VerifyVaildLogin() throws InterruptedException {
		Logs.info("Verifying the Login Functionality with Vaild Credentials");
		loginpage = new LoginPage();
		loginpage.loginCred(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(Integer.parseInt(prop.getProperty("WaitTime")));

	}

	@Test(priority = 1, description = "Verify the Login Functionality with In-Valid Credentails")
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Login Functionality")
	@Epic("EP001")
	@Story("ST02-Verify the login functionality")
	@Step("Login by entering userName and Password")
	public void VerifyInvalidCred() throws NumberFormatException, InterruptedException{
		Logs.info("Verifying the Login Functionality with In-Vaild Credentials");
		loginpage = new LoginPage();
		loginpage.loginCred(prop.getProperty("username"), prop.getProperty("InValidPassword"));
		Thread.sleep(Integer.parseInt(prop.getProperty("WaitTime")));
	}

	@Test(priority = 2, description = "Verify the HomePage Title")
	@Severity(SeverityLevel.NORMAL)
	@Feature("Home Page Title")
	@Epic("EP001")
	@Story("ST03-Verify the HomePage Title")
	@Step("Login by entering userName and Password and Validate the Home Page title")
	public void verifyHomePage() throws InterruptedException {
		Logs.info("Verifying the Title of the HomePage");
		VerifyVaildLogin();
		String title = loginpage.getHomePagetile();
		Assert.assertEquals(title, "AssetPanda - Management System12345");
	}

	@AfterMethod
	public void tearDown() {
		driverfactory.getDriver().close();

	}

}
