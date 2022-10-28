package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilies.TestUtilies;

public class DriverFactory {

	public static WebDriver driver;

	public WebDriver DriverIntilization(String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(TestUtilies.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilies.IMPLICT_WAIT, TimeUnit.SECONDS);
		return getDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
