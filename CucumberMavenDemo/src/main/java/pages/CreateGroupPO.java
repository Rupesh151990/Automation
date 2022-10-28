package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateGroupPO 
{
	private WebDriver driver;
	
	By GroupName= By.xpath("//div//input[@id='entity_name']");
	By DeleteCommentCheckBox=By.id("entity_require_comment_on_object_delete");
	By LinkedObject=By.id("entity_show_linked");
	By AssoicatedObject=By.id("entity_show_associated");
	By ImageAttachment=By.id("entity_allowed_attachments_image");
	By VoiceAttachment=By.id("entity_allowed_attachments_voicenote");
	By VedioAttachment=By.id("entity_allowed_attachments_video");
	By DocumentAttachment=By.id("entity_allowed_attachments_document");
	By SaveButton=By.xpath("//a[contains(@class,\"btn btn-primary dropdown-toggle\")]");
	By SuccessMessage=By.xpath("//div//p[contains(text(),\"Group successfully saved\")]");
	By DeleteButton=By.xpath("//li//a[text()='Delete']");
	By ConfrimDelete=By.xpath("//div//a[@class='btn btn-background' and text()='Delete Group']");
	
	public CreateGroupPO(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getcreatePage()
	{
		return driver.getTitle();
	}
	
	public void enterGroupName(String name) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(GroupName).sendKeys(name);
	}
	
	public void Isapeoplegroup()
	{
		driver.findElement(DeleteCommentCheckBox).click();
		driver.findElement(LinkedObject).click();
		driver.findElement(AssoicatedObject).click();
	}
	public void AttachmentCheckBox()
	{
		driver.findElement(ImageAttachment).click();
		driver.findElement(VoiceAttachment).click();
		driver.findElement(VedioAttachment).click();
		driver.findElement(DocumentAttachment).click();
	}
	public void saveGroup()
	{
		driver.findElement(SaveButton).click();
	}
	public String getSuccessMessage()
	{
		return driver.findElement(SuccessMessage).getText();
	}
	public void DeleteGroup() {
		driver.findElement(DeleteButton).click();
	}
	public void ConfirmDelete()
	{
		driver.findElement(ConfrimDelete).click();
	}
	
	
}
