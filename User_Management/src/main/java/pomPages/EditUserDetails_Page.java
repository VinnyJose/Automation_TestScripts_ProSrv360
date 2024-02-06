package pomPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditUserDetails_Page {
  //Declaration
	@FindBy(xpath="//h3[text()='Edit User']") private WebElement header;
	@FindBy(xpath="//span[text()='Edit icon']/parent::button") private WebElement edit_Button;
	@FindBy(xpath="//span[text()='Unlock']//parent::button") private WebElement delete_Button;
	@FindBy(xpath="//span[text()='Delete']//parent::button") private WebElement reactivate_Button;
	@FindBy(xpath="//span[text()='Close icon']/parent::button") private WebElement close_Button;
	@FindBy(xpath="//button[text()='Yes']") private WebElement yes_Button;
	@FindBy(xpath="//input[@id='mobileno']") private WebElement mobile;
	@FindBy(xpath="//button[text()='Save']") private WebElement save_Button;
 //Initialization
	
	public EditUserDetails_Page(WebDriver diver)
	{
		PageFactory.initElements(diver,this);
	}
	
 //Utilization
	/*
	 * This method is used to get header
	 */
	public String getHeader()
	{
		return header.getText();
	}
	/*
	 * This method is used to perform click operation on delete button
	 */
	public void setDelete()
	{
		delete_Button.click();
	}
	/*
	 * This method is used to perform click operation on 'Yes' button
	 */
	public void setYes()
	{
		yes_Button.click();
	}
	/*
	 * This method is used to click on edit button
	 */
	public void setEdit()
	{
		edit_Button.click();
	}
	/*
	 * This method is used to perform click on close button
	 */
	public void setClose(WebDriver driver)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(close_Button));
		close_Button.click();
	}
	/*
	 * This method is used to update mobile number
	 */
	public void setMobile(String mobileno,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(mobile));
		//mobile.clear();
		mobile.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE); 
		mobile.sendKeys(mobileno);
		//wait.until(ExpectedConditions.textToBePresentInElement(mobile, mobileno));
		
	}
	/*
	 * This method is used to perform click operation on save button
	 */
	public void setSave(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(save_Button));
		save_Button.click();
	}
	/*
	 * This method is used to perform click operation on reactivate button
	 */
	public void setReactivate()
	{
		reactivate_Button.click();
		yes_Button.click();
	}
	/*
	 * This method is used to get mobile number
	 */
	public String getMobileNo(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(mobile)); 
		return mobile.getText();
	}
	
}

