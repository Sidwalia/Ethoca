package AutomationFramework;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;

public class ProductCategoryPageObjects {

	WebDriver driver;
	 
	@FindBy(how = How.LINK_TEXT, using = "Magic Mouse")
 
	public WebElement MagicMouseButton;
	
}
