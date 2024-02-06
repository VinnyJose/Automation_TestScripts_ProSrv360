package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericLibraries.WebDriverUtility;

public class UserAccess_Page {
 //declaration
	@FindBy(xpath="//h1[contains(text(),'User Details')]") private WebElement header;
	@FindBy(xpath="//button[contains(@class,'center text-white rounded-full bg-primary')]") private WebElement create_newUser_button;
	@FindBy(xpath="//span[text()='Active']/parent::button") private WebElement active_tab;
	@FindBy(xpath="//span[text()='Active']/parent::li/parent::ul") private WebElement active_SelectionList;
	@FindBy(xpath="//input[@type='search']")private WebElement serch_field;
	@FindBy(xpath="//table[contains(@class,'relative')]/descendant::td/child::div[contains(text(),'ctive')]") private WebElement user_status_Field;
	@FindBy(xpath="//div[contains(text(),'Motiveminds')]/parent::td/parent::tr") private WebElement tableRow;
	@FindBy(xpath="//table/descendant::tbody/descendant::td[3]") private WebElement userNameField_fromTable;
	
//initialization
	public UserAccess_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
//utilization	
	/*
	 * This method is used to get header
	 */
	public String getHeader()
	{
		return header.getText();
	}
	 /*
	  * This method is used to perform click operation on create_newUser_button
	  */
	 public void setcreate_newUser_button()
	 {
		 create_newUser_button.click();
	 }
	 /*
	  * This method is used to perform click operation on active tab
	  */
	 public void setActive()
	 {
		 
		 active_tab.click();
		 System.out.println("clicked");
		 
	 }
	 /*
	  * This method is used to perform selection from the active list
	  */
	 public void setSelection_fromActive(WebDriverUtility web,WebDriver driver)
	 {
		    String selection="All";
		    String current_state = active_tab.getText();
		    System.out.println("State :" + current_state);
		    
		    WebDriverWait wait = new WebDriverWait(driver, 10);
		    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(active_SelectionList));
		    web.selectFromList(selection, dropdown);
		   
	}
	 /*
	  * This method is used to enter search key
	  */
	 public void setSearchfield(String text)
	 {
		 
		 serch_field.sendKeys(text);
		 //WebDriverWait wait = new WebDriverWait(driver, 10);
		 //wait.until(ExpectedConditions.textToBePresentInElementValue(serch_field, text));
		 
		
		 
	 }
	 /*
	  * This method is used to perform click operation on the table Row selection
	  */
	 public void set_TableRow(WebDriver driver,String username)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.textToBePresentInElement(tableRow,username ));
		 wait.until(ExpectedConditions.elementToBeClickable(tableRow));
		 tableRow.click();
	 }
	 /*
	  * This method is used to get current user status
	  */
	 public String getStaus(String username,WebDriver driver)
	 {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(tableRow,username ));
		 return user_status_Field.getText();
		 
	 }
	/*
	 * This method is used to perform click operation on search text field
	 */
	 public void clickonSearch()
	 {
		 serch_field.click();
	 }
	 /*
	  * This method is used to get text from user name field from table
	  */
	 public String getUserName_fromTable()
	 {
		 return userNameField_fromTable.getText();
	 }
 
}
