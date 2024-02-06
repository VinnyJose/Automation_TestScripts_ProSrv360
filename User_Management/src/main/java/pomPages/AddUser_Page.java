package pomPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import genericLibraries.WebDriverUtility;

public class AddUser_Page {
	//declaration
	@FindBy(xpath="//h3[text()='Add User']") private WebElement header;
	@FindBy(xpath="//div/label[@for='companyname']/following-sibling::div/button/span") private WebElement company_TextField;
	@FindBy(xpath="//li[@title='Motiveminds IN ']/parent::ul") private WebElement company_DropDown;
	@FindBy(xpath="//div/label[text()='User Type']/following-sibling::div/button") private WebElement userType_TextField;
	@FindBy(xpath="//li[@title='Customer ']/parent::ul") private WebElement userType_DropDown;
	@FindBy(xpath="//label[@for='Role']/parent::div/child::div/child::div/child::button") private WebElement role_TextField;
	@FindBy(xpath="//span[text()='Delivery Manager']/parent::div/parent::div") private WebElement role_DropDown;
	@FindBy(id="firstname") private WebElement firstName_TextField;
	@FindBy(id="lastname") private WebElement lastName_TextField;
	@FindBy(id="emailid") private WebElement emailID_TextField;
	@FindBy(id="username") private WebElement userName_TextField;
	@FindBy(id="mobileno") private WebElement mobileNumber_TextField;
	@FindBy(id="employeecode") private WebElement userCode_TextField;
	@FindBy(xpath="//button[text()='Save']") private WebElement save_Button;
	@FindBy(xpath="//span[text()='Close icon']/parent::button") private WebElement close_Button;
	//initialization
	public AddUser_Page(WebDriver driver)
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
	 * This method is used to enter company
	 */
	public void setCompany_TextField(WebDriverUtility web,String company,WebDriver driver)
	{
		

	   
	    WebDriverWait wait = new WebDriverWait(driver,20);
	    WebElement companyTextField = wait.until(ExpectedConditions.elementToBeClickable(company_TextField));
	    web.clickOnElement(companyTextField);

	    web.clickOnElement(company_TextField);
		web.selectFromList(company,company_DropDown);
	}
	/*
	 * This method is used to enter userType
	 */
	public void setUserType_TextField(WebDriverUtility web,String userType)
	{
		
		userType_TextField.click();
		web.selectFromList(userType,userType_DropDown);
	}
	/*
	 * This method is used to enter role
	 */
	public void setRole_TextField(WebDriverUtility web,String role)
	{
		role_TextField.click();
		web.selectFromList(role,role_DropDown);
	}
	
	/*
	 * This method is used to enter user details
	 */
	public void setUser_Details(String firstname,String lastname,String emailID,String mobileNo,String userCode)
	{
		firstName_TextField.sendKeys(firstname);
		lastName_TextField.sendKeys(lastname);
		emailID_TextField.sendKeys(emailID);
		mobileNumber_TextField.sendKeys(mobileNo);
		userCode_TextField.sendKeys(userCode);
	}
	/*
	 * This method is used to read data from user name field
	 */
	public String getUserName()
	{
		    return userName_TextField.getText();
	}
	/*
	 * This method is used to perform save operation
	 */
	public void setSave()
	{
		save_Button.click();
	}
	/*
	 * This method is used to close add user window
	 */
	public void setClose()
	{
		close_Button.click();
	}
	
	
}
