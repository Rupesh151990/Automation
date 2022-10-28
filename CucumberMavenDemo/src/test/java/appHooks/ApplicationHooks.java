package appHooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.*;
import utility.ConfigProperties;

public class ApplicationHooks {
	WebDriver driver;
	DriverFactory driverfactory;
	private Properties prop;
	ConfigProperties configproperties;

	@Before(order = 0)
	public void getProperty() {
		configproperties = new ConfigProperties();
		prop = configproperties.get_property();
	}

	@Before(order = 1)
	public void launch_Browser() {
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver=driverfactory.init_driver(browserName);

	}

	@After(order = 0)
	public void closeBrowser() {
		driver.quit();
	}

}
