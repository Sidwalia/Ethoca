package AutomationFramework;

import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;


public class HomePageObjects {

	 WebDriver driver;
	 
	@FindBy(how = How.ID, using = "menu-item-33")
 
	public WebElement ProductCategory;
	
	@FindBy(how = How.CLASS_NAME, using = "cart_icon")
	 
	public WebElement CartIcon;	
 

	public HomePageObjects(WebDriver driver)
 
	{
 
		this.driver = driver;
 
		}
	
	
}
