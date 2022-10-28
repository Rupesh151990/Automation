package stepDefinition;

import java.util.List;

import org.junit.Assert;

//import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.*;
import io.cucumber.java.en.*;
import pages.GroupCreationPO;
//import pages.HomePagePO;
//import pages.LoginPagePO;
//import factory.DriverFactory;

public class GroupCreationSteps {

	String title;
	GroupCreationPO grpcreationpo = new GroupCreationPO(DriverFactory.getDriver());

	@Given("User clicks on the setting icon")
	public void user_clicks_on_the_setting_icon() throws InterruptedException {
		grpcreationpo.grpsettingicon();
	}

	@When("user clicks on the Group Setting option")
	public void user_clicks_on_the_group_setting_option() {

	}

	@Then("verify the list count should be {int}")
	public void verify_the_list_count_should_be(Integer expectedCount) {
		System.out.println("printing the expected count " + expectedCount);
		int ActualCount = grpcreationpo.settingCount();
		System.out.println("printing the Actual Count " + ActualCount);
		Assert.assertTrue(grpcreationpo.settingCount() == expectedCount);
	}

	@Then("user clicks on the group Setting option on the drop down")
	public void user_clicks_on_the_group_Setting_option_on_the_drop_down(DataTable SettingList) {

		List<String> expectedList = SettingList.asList();
		System.out.println("Printing the Expected List = " + expectedList);

		List<String> actualList = grpcreationpo.getsettingList();
		System.out.println("Pribting the Actual List = " + actualList);

		Assert.assertTrue(expectedList.containsAll(actualList));
		Assert.assertEquals(expectedList, actualList);

	}

	@Given("User is on the group creation page")
	public void user_is_on_the_group_creation_page() {

		String title = grpcreationpo.getGrpPageTitle();
		System.out.println("Printing the Create Group Page title = " + title);
		Assert.assertTrue(title.contains(grpcreationpo.getGrpPageTitle()));
	}

	@When("user clicks on the Add New Group button")
	public void user_clicks_on_the_add_new_group_button() throws InterruptedException {

		grpcreationpo.GroupSettingButton();
		Thread.sleep(2000);
		grpcreationpo.AddNewGroupButton();
	}

	@When("user naviagte to the Adding Groups and their Fields page")
	public void user_naviagte_to_the_adding_groups_and_their_fields_page() {
		Assert.assertTrue(grpcreationpo.getCreateGrpPageHeader());

	}

}
