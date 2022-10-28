package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GroupCreationPO {
	WebDriver driver;

	By accountsetting = By
			.xpath("//li[@class='dropdown setting-icon dropdown_img']//span[@class='submenu_icon dropdown-toggle']");
	By settingList = By.xpath("//ul[@class='dropdown-menu user-settings dropdown-menu-right show']//li");
	By Group_Settings = By.xpath("//li[@class='fifth']");
	By Add_New_Group = By.xpath("//li//a[@class='btn btn-info btn-sm action-button add']");
	By createPageheader = By.xpath("//div//div//h2[contains(text(),'Adding Groups and their Fields')]");

	public GroupCreationPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedGrpSetting() {
		return driver.findElement(accountsetting).isDisplayed();
	}

	public void grpsettingicon() throws InterruptedException {
		driver.findElement(accountsetting).click();
		Thread.sleep(2000);

	}

	public void GroupSettingButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Group_Settings).isDisplayed();
		driver.findElement(Group_Settings).click();
	}

	public void AddNewGroupButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Add_New_Group).isDisplayed();
		driver.findElement(Add_New_Group).click();
	}

	public String getGrpPageTitle() {
		return driver.getTitle();
	}

	public boolean getCreateGrpPageHeader() {
		return driver.findElement(createPageheader).isDisplayed();
	}

	public int settingCount() {
		return driver.findElements(settingList).size();
	}

	public List<String> getsettingList() {
		List<String> text = new ArrayList<String>();
		List<WebElement> list = driver.findElements(settingList);
		System.out.println(settingList);
		for (WebElement e : list) {
			String settingL = e.getText();
			System.out.println("printing the Setting List option = " + settingL);
			text.add(settingL);
		}
		return text;

	}

}
