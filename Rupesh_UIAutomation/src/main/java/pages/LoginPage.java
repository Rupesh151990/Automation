package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.DriverFactory;

public class LoginPage extends DriverFactory {

	@FindBy(id = "user_email")
	WebElement userEmail;

	@FindBy(id = "asset-panda-pwfield")
	WebElement password;

	@FindBy(name = "commit")
	WebElement loginButton;

	@FindBy(xpath = "//li[@class='dropdown mega-menu-item mega-menu-signin signin dropdown_img']//span[@class='submenu_icon dropdown-toggle']")
	WebElement AccountIcon;

	@FindBy(xpath = "//a[@id='user-logout']")
	WebElement logOut;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void loginCred(String email, String pwd) {
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		loginButton.click();
	}

	public void ClickLogOut() {
		AccountIcon.click();
		logOut.click();
	}

}
