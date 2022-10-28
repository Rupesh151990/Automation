package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePO {

	private WebDriver driver;

	// By Locator

	By emailid = By.id("user_email");
	By password = By.id("asset-panda-pwfield");
	By loginButton =By.name("commit");
	By forgotLink = By.xpath("//a[contains(text(),\"Forgot your password?\")]");

	// Creating the constructor
	public LoginPagePO(WebDriver driver) {
		this.driver = driver;
	}

	// Actions

	public String getpagetitle() {
		return driver.getTitle();
	}

	public boolean isForgotlinkDisplayed() {
		return driver.findElement(forgotLink).isDisplayed();
	}

	public void enterUserName(String email) {
		driver.findElement(emailid).sendKeys(email);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void loginButton() {
		driver.findElement(loginButton).click();
	}
	public HomePagePO doLogin(String un,String pd)
	{
		System.out.println("Printing the username " + un +"password" + pd);
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pd);
		driver.findElement(loginButton).click();
		
		return new HomePagePO(driver);
	}
	

}
