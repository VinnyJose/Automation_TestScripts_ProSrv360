package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * This class contains all reusable methods to perform WebDriver actions
 */
public class WebDriverUtility {
	WebDriver driver;
	/*
	 * This method is used to open the application
	 * @param browser
	 * @param url;
	 * @param time;
	 */
	public WebDriver openApplication(String browser,String url,long time)
	{
		switch(browser)
		{
		case "chrome" :WebDriverManager.chromedriver().setup();
		               driver=new ChromeDriver();
		               break;
		case "firefox":WebDriverManager.firefoxdriver().setup();
		               driver=new FirefoxDriver();
		               break;
		case "edge"   :WebDriverManager.edgedriver().setup();
		               driver=new EdgeDriver();
		               break;
		default       :System.out.println("Invalid browser name");
		               break;
		               
		               
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		return driver;
	}
	/*
	 * This method is used to take screenshots of failed test cases
	 */
	public String getScreenShot(JavaUtility javaUtility,WebDriver driver,String result)
	{
		String currenttime=javaUtility.currentTime();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File("./ScreenShot/"+result+"_"+currenttime+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return des.getAbsolutePath();
	}
	public String getScreenShot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		String src=ts.getScreenshotAs(OutputType.BASE64);
		return src;
	}
	/*
	 * This method is to close the browser
	 */
	public void closebrowser()
	{
		driver.quit();
	}
	/*
	 * This method is used to switch to frame
	 */
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	/*
	 * This method is used to switch back from frame
	 */
	public void switchBackFrame()
	{
		driver.switchTo().defaultContent();
	}
	/*
	 * This method is used to navigate back to previous page
	 */
	public void navigateBack(String url)
	{
		driver.navigate().to(url);
	}
	/*
	 * These methods are used to select element from a drop down list
	 */
	public void dropDown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void dropDown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void dropDown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
		System.out.println("Selected option: " + text);
	}
	/*
	 * This method is used to perform click operation on an element
	 */
	public void clickOnElement(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
	/*
	 * This method is used to select given item from a list
	 */
	public void selectFromList(String text, WebElement dropDown) {
	    List<WebElement> options1 = dropDown.findElements(By.tagName("li"));
	    List<WebElement> options2 = dropDown.findElements(By.tagName("span"));
	    List<WebElement> allOptions = new ArrayList<>();
	    allOptions.addAll(options1);
	    allOptions.addAll(options2);
        
	    for (WebElement option : allOptions) {
	        if (option.getText().equals(text)) {
	            option.click();
	            System.out.println("Selected option: " + text);
	            return;
	        }
	    }

	     System.out.println("Option not found: " + text);
	}


}
