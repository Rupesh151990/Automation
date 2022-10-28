package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.CreateGroupPO;

public class CreateGroupSteps {

	
	WebDriver driver;
	CreateGroupPO creategroupPO=new CreateGroupPO(DriverFactory.getDriver());
	
	@Given("user is on create page")
	public void user_is_on_create_page() {
	    		String pageTitle=creategroupPO.getcreatePage();
	    		System.out.println("Page Title = " + pageTitle);
	}

	@When("user enter the Name {string}")
	public void user_enter_the_name(String Username) throws InterruptedException {
		Thread.sleep(2000);
	   creategroupPO.enterGroupName(Username);
		
	}

	@When("user select the required check box")
	public void user_select_the_required_check_box() {
	   
		creategroupPO.Isapeoplegroup();
		creategroupPO.AttachmentCheckBox();
		
	}

	@Then("user click on save button")
	public void user_click_on_save_button() {
	   
		creategroupPO.saveGroup();
	}
	
	@Then("user view the successful message {string}")
	public void user_view_the_successful_message(String expectedMessage) {
	    
		String ActualMessage=creategroupPO.getSuccessMessage();
		
		Assert.assertTrue(ActualMessage.contains(expectedMessage));
	}
	
	
	@Then("User click on the detele button")
	public void user_click_on_the_detele_button() throws InterruptedException {
	    creategroupPO.DeleteGroup();
	    Thread.sleep(2000);
	    
	}

	@Then("User confrim the popup")
	public void user_confrim_the_popup() {
		creategroupPO.ConfirmDelete();
	}

}
