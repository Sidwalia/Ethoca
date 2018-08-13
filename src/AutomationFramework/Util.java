package AutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Util {
	static WebDriver driver;
		
	public static void OpenBrowser() throws InterruptedException 
	{
		
   System.setProperty("webdriver.gecko.driver", "C:\\selenium-2.53.0\\geckodriver.exe");
	driver= new FirefoxDriver();
	Thread.sleep(3000);
	driver.manage().deleteAllCookies();
		
	}
			
	public static void Navigate(String URL)
	{
		driver.get(URL);
	}
	 
	public static void WaitFor (WebElement a)
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(a)).isDisplayed();
		
	}
	
	
}


