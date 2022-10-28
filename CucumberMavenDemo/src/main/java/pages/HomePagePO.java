package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePO 
{
	private WebDriver driver;
	private By DropDown =By.xpath("//span[@class='submenu_dropdown dropdown-toggle']");
	
	public HomePagePO(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public int getDropDownCount()
	{
		return driver.findElements(DropDown).size();
	}
	
	public List<String> getDropDownList()
	{
		List<String> list=new ArrayList<String>();
		 List<WebElement> dropdownlist=driver.findElements(DropDown);
		 for(WebElement e: dropdownlist)
		 {
			String text=e.getText(); 
			System.out.println("Printing the List of  dropDown on header " + text);
			list.add(text);
		 }
		 return list;
	}
	
	
}
