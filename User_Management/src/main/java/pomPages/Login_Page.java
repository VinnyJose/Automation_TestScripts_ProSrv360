package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
   //declaration
	@FindBy(xpath="//h1[text()='Welcome to ProSrv360']") private WebElement header;
	@FindBy(id="username") private WebElement username_textField;
	@FindBy(id="password") private WebElement password_textField;
	@FindBy(xpath="//button[@type='submit']") private WebElement login_button;
	@FindBy(xpath="//button[text()='Forgot Password?']") private WebElement forgot_password_link;
	
	//initialization
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	/*
	 * This method is used to get the page header
	 */
	public String getheader()
	{
		return header.getText();
	}
	/*
	 * This method is used to enter login credentials
	 */
	public void login_to_Application(String username,String password)
	{
		username_textField.sendKeys(username);
		password_textField.sendKeys(password);
		login_button.click();
	}
	
	
}
