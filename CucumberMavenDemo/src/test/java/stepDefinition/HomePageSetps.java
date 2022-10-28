package stepDefinition;

import io.cucumber.java.en.*;
import pages.HomePagePO;
import pages.LoginPagePO;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import factory.DriverFactory;
import io.cucumber.datatable.*;

public class HomePageSetps 
{
	
	String title;
	private LoginPagePO loginpagepo=new LoginPagePO(DriverFactory.getDriver());
	private HomePagePO homepagepo ;
	
	 
	@Given("User is already logged into the application")
	public void user_is_already_logged_into_the_application(DataTable CredTable) {
	List<Map<String,String>> creddetail=CredTable.asMaps();
	String Name = creddetail.get(0).get("UserName");
	String Pass = creddetail.get(0).get("Password");
		
	DriverFactory.getDriver().get("https://login.assetpanda.com/users/sign_in");
	homepagepo=loginpagepo.doLogin(Name, Pass);
	
	}
	
	@Given("user is on homepage")
	public void user_is_on_homepage() {
		
	 title =homepagepo.getHomePageTitle();
	 System.out.println("Printing the title of the homepage = " + title);
		
	}
/*
	@Then("page title should be {string}")
	public void page_title_should_be(String expected) {
		Assert.assertTrue(title.contains(expected));
	   
	}
*/
	@Then("user gets the drop downs")
	public void user_gets_the_drop_downs(DataTable headerList) {
		
		
		List<String> expectedDropdownlist=headerList.asList();
		System.out.println("Printing the expected Drop Down List" + expectedDropdownlist);
		
		List<String> actualDropDownList=homepagepo.getDropDownList();
		System.out.println("Printing the actual Drop Down List" + actualDropDownList);
		
		Assert.assertEquals(expectedDropdownlist, actualDropDownList);
		Assert.assertTrue(expectedDropdownlist.containsAll(actualDropDownList));

	}

	@Then("drop down section will be {int}")
	public void drop_down_section_will_be(Integer exepectedcount) {
		
		Assert.assertTrue(homepagepo.getDropDownCount()==exepectedcount);
	    
	}

	
	
}
