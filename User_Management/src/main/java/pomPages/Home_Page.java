package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	//declaration
	@FindBy(xpath="//h1[contains(text(),' Welcome')]") private WebElement header;
	@FindBy(xpath="//button[contains(@id,'menu-button')]") private WebElement menu_button;
	@FindBy(xpath="//button[text()='Logout']") private WebElement logout_Button;
	@FindBy(xpath="//div[text()='Admin']") private WebElement admin_button;
	@FindBy(xpath="//a[text()='User Access']") private WebElement userAccess_button;
	
	
	//initialization
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	/*
	 * This method is used to get page header
	 */
	public String getHeader()
	{
		return header.getText();
	}
	/*
	 * This method is used to perform click operation on admin_button
	 */
	 public void setadmin_button()
	 {
		 admin_button.click();
	 }
	 /*
	  * This method is used to perform click operation on userAccess_button
	  */
	 public void setuserAccess_button()
	 {
		 userAccess_button.click();
	 }
	 
	/*
	 * This method is used to logout from the application
	 */
	 public void setLogout()
	 {
		 menu_button.click();
		 logout_Button.click();
	 }
 
}
