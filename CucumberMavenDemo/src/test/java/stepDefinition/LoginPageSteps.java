package stepDefinition;

import org.testng.Assert;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPagePO;

public class LoginPageSteps {

	private String title;
	private LoginPagePO loginpagePO = new LoginPagePO(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://login.assetpanda.com/users/sign_in");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginpagePO.getpagetitle();
		System.out.println("Printing the page title" + title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedtitle) {
		Assert.assertTrue(title.contains(expectedtitle));

	}

	@Then("Forgot link password should be displayed")
	public void forgot_link_password_should_be_displayed() {
		Assert.assertTrue(loginpagePO.isForgotlinkDisplayed());
	}

	@When("user enters the userName {string}")
	public void user_enters_the_user_name(String emailid) {
		loginpagePO.enterUserName(emailid);
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String password) {
		loginpagePO.enterPassword(password);
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		loginpagePO.loginButton();
	}
	

}
