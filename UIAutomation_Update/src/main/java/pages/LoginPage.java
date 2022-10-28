package pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;

public class LoginPage extends DriverFactory {

	Properties prop;

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='asset-panda-pwfield']")
	WebElement password;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement loginButton;
	

	// Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Action
	public String getHomePagetile() {
		return driver.getTitle();
	}
	
	public void loginCred(String email, String pwd)  {
		username.sendKeys(email);
		password.sendKeys(pwd);
		loginButton.click();
	}

}
