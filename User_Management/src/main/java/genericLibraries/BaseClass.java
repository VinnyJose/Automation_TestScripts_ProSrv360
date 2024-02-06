package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddUser_Page;
import pomPages.EditUserDetails_Page;
import pomPages.Home_Page;
import pomPages.Login_Page;
import pomPages.UserAccess_Page;

public class BaseClass {
   protected WebDriver driver;
   protected ExcelFileUtility excel;
   protected JavaUtility java;
   protected PropertyFileUtility property;
   protected WebDriverUtility web;
   protected Login_Page login;
   protected Home_Page home;
   protected AddUser_Page adduser;
   protected UserAccess_Page useraccess;
   protected EditUserDetails_Page edituser;
   public static WebDriver sdriver;
   public static JavaUtility sjavaUtil;
   protected boolean shouldPerformCleanup = true;
   
   @BeforeClass
   
   public void classSetUp()
   {
	   web=new WebDriverUtility();
	   excel=new ExcelFileUtility();
	   java=new JavaUtility();
	   sjavaUtil=java;
	   property=new PropertyFileUtility();
	   property.propertyFileInitialization(iConstantPath.PROPERTY_FILE_PATH);
	   excel.excelInitialization(iConstantPath.EXCEL_FILE_PATH);
	   String url=property.getDataFromProperties("url");
	   String browser=property.getDataFromProperties("browser");
	   long time=Long.parseLong(property.getDataFromProperties("timeouts"));
	   driver=web.openApplication(browser,url,time);
	   sdriver=driver;
	   login=new Login_Page(driver);
	   Assert.assertTrue(login.getheader().contains("Welcome to ProSrv360"));
	   
   }
  @BeforeMethod
   public void methodSetup() 
   {
	  home=new Home_Page(driver);
	  adduser=new AddUser_Page(driver);
	  useraccess=new UserAccess_Page(driver);
	  edituser=new EditUserDetails_Page(driver);
	  String username=property.getDataFromProperties("UserName");
	  String password=property.getDataFromProperties("Password");
	  login.login_to_Application(username, password);
	  Assert.assertTrue(home.getHeader().contains("Welcome"));  
	  
   } 
 @AfterMethod
   public void methodTearDown()
   {
	  if(shouldPerformCleanup)
	   home.setLogout();
	   
   }
 @AfterClass
  public void classTearDown()
   {
	   web.closebrowser();
	   excel.closeExcel();
   } 
  
}   
