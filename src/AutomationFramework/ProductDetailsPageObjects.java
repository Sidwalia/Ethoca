package AutomationFramework;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;

public class ProductDetailsPageObjects {

	WebDriver driver;
	 
	@FindBy(how = How.CLASS_NAME, using = "wpsc_buy_button")
 
	public WebElement AddToCartButton;	
	
}
